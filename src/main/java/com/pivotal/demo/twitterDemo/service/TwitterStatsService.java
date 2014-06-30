package com.pivotal.demo.twitterDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pivotal.demo.twitterDemo.domain.TwitterStat;
import com.pivotal.demo.twitterDemo.jpa.TwitterEntryRepository;

@Component
public class TwitterStatsService {
@Autowired
TwitterEntryRepository twitterEntryRepository;
	
	/*
	"{\n"+
			"  \"cols\": [\n"+
			"        {\"id\":\"\",\"label\":\"Topping\",\"pattern\":\"\",\"type\":\"string\"},\n"+
			"        {\"id\":\"\",\"label\":\"Slices\",\"pattern\":\"\",\"type\":\"number\"},\n"+
			"        {\"id\":\"\",\"label\":\"Buns\",\"pattern\":\"\",\"type\":\"number\"}\n"+
			"      ],\n"+
			"  \"rows\": ["+
			"        {\"c\":[{\"v\":\"Mushrooms\",\"f\":null},
			"        {\"v\":3,\"f\":null},"
			"        {\"v\":3,\"f\":null}]}\n"+
			"      ]\n"+
			"}";*/
    private static final String cols="\"cols\": [\n"+
			"        {\"id\":\"\",\"label\":\"User Name\",\"pattern\":\"\",\"type\":\"string\"},\n"+
			"        {\"id\":\"\",\"label\":\"Total Followers\",\"pattern\":\"\",\"type\":\"number\"},\n"+
			"        {\"id\":\"\",\"label\":\"Retweet Count\",\"pattern\":\"\",\"type\":\"number\"}\n"+
			"      ],\n";
	public String getTwitterStats() {
		StringBuffer sb=new StringBuffer();
		sb.append("{\n");
		sb.append(cols);
		sb.append("  \"rows\": [");
		List<TwitterStat> stats=twitterEntryRepository.getTwitterStats();
		Boolean firstOne=true;
		for (TwitterStat stat:stats) {
			if (firstOne) {
				firstOne=false;
			}else {
				sb.append(",");
			}
			sb.append("{\"c\":[\n");
			sb.append("{\"v\":\""+stat.getFromUser()+"\",\"f\":null},\n");
			sb.append("{\"v\":\""+stat.getTotalFollowers()+"\",\"f\":null},\n");
			sb.append("{\"v\":\""+stat.getTotalRecount()+"\",\"f\":null}\n");
			sb.append("]}\n");
		}
		sb.append("]\n}");
		return sb.toString();
	}
}
