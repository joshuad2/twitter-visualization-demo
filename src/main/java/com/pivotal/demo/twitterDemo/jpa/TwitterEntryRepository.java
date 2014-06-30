package com.pivotal.demo.twitterDemo.jpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.pivotal.demo.twitterDemo.domain.TwitterEntry;
import com.pivotal.demo.twitterDemo.domain.TwitterStat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class TwitterEntryRepository {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	protected JdbcTemplate jdbc;
	
	public TwitterEntry getTwitterEntry(Long id){
		return jdbc.queryForObject("SELECT * from twitter where id=?",twitterEntryMapper,id);
	}

    public List<TwitterEntry> getTwitterEntrys(long[] ids) {
        String inIds = StringUtils.arrayToCommaDelimitedString(ObjectUtils.toObjectArray(ids));
        return jdbc.query("SELECT * FROM tweets WHERE id IN (" + inIds + ")", twitterEntryMapper);
    }
	
    public List<TwitterStat> getTwitterStats(){
      String select="select from_user,sum(followers), count(hash_tag) from tweets group by from_user";
      return jdbc.query(select, twitterStatMapper);
    }
    
	private static final RowMapper<TwitterEntry> twitterEntryMapper= new RowMapper<TwitterEntry>(){
		public TwitterEntry mapRow(ResultSet rs, int rowNum) throws SQLException{
			TwitterEntry te=new TwitterEntry();
			te.setCreatedAt(rs.getString(2));
			te.setFollowers(rs.getInt(4));
			te.setFromUser(rs.getString(1));
			te.setHash_tag(rs.getString(3));
			te.setId(rs.getLong(0));
			te.setLanguageCode(rs.getString(5));
			te.setRetweet(rs.getString(7));
			te.setRetweetCount(6);
			return te;
		}
	};
	
	private static final RowMapper<TwitterStat> twitterStatMapper= new RowMapper<TwitterStat>() {
		public TwitterStat mapRow(ResultSet rs, int rowNum) throws SQLException{
			TwitterStat ts=new TwitterStat();
			ts.setFromUser(rs.getString(1));
			ts.setTotalFollowers(rs.getLong(2));
			ts.setTotalRecount(rs.getLong(3));
			return ts;
		}
	};
}
