package com.pivotal.demo.twitterDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pivotal.demo.twitterDemo.service.TwitterStatsService;



@RestController
public class TwitterDemoController {

	@Autowired
	TwitterStatsService twitterStatsService;

private static final String otherData="{\"c\":[{\"v\":\"Onions\",\"f\":null},{\"v\":1,\"f\":null}]},\n"+
		"        {\"c\":[{\"v\":\"Olives\",\"f\":null},{\"v\":1,\"f\":null}]},\n"+
		"        {\"c\":[{\"v\":\"Zucchini\",\"f\":null},{\"v\":1,\"f\":null}]},\n"+
		"        {\"c\":[{\"v\":\"Pepperoni\",\"f\":null},{\"v\":2,\"f\":null}]}";
private static final String testData="{\n"+
"  \"cols\": [\n"+
"        {\"id\":\"\",\"label\":\"Topping\",\"pattern\":\"\",\"type\":\"string\"},\n"+
"        {\"id\":\"\",\"label\":\"Slices\",\"pattern\":\"\",\"type\":\"number\"},\n"+
"        {\"id\":\"\",\"label\":\"Buns\",\"pattern\":\"\",\"type\":\"number\"}\n"+
"      ],\n"+
"  \"rows\": ["+
"        {\"c\":[{\"v\":\"Mushrooms\",\"f\":null},{\"v\":3,\"f\":null},{\"v\":3,\"f\":null}]}\n"+
"      ]\n"+
"}";

@RequestMapping(value="/getData", method=RequestMethod.GET)
public String getData() {
	return twitterStatsService.getTwitterStats();
}
}
