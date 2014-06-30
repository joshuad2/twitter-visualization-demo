package com.pivotal.demo.twitterDemo.domain;

public class TwitterStat implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5136664035063494914L;
	private String fromUser;
	private String hash_tag;
	private Long totalFollowers;
	private Long totalRecount;
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getHash_tag() {
		return hash_tag;
	}
	public void setHash_tag(String hash_tag) {
		this.hash_tag = hash_tag;
	}
	public Long getTotalFollowers() {
		return totalFollowers;
	}
	public void setTotalFollowers(Long totalFollowers) {
		this.totalFollowers = totalFollowers;
	}
	public Long getTotalRecount() {
		return totalRecount;
	}
	public void setTotalRecount(Long totalRecount) {
		this.totalRecount = totalRecount;
	}

	
}
