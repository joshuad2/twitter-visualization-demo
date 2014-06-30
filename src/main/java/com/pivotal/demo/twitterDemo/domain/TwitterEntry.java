package com.pivotal.demo.twitterDemo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TwitterEntry implements java.io.Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 6795607651194963524L;
@Id
private Long id ;
private String fromUser;
private String createdAt;
private String hash_tag;
private Integer followers;
private String languageCode;
private Integer retweetCount;
private String retweet;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFromUser() {
	return fromUser;
}
public void setFromUser(String fromUser) {
	this.fromUser = fromUser;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
public String getHash_tag() {
	return hash_tag;
}
public void setHash_tag(String hash_tag) {
	this.hash_tag = hash_tag;
}
public Integer getFollowers() {
	return followers;
}
public void setFollowers(Integer followers) {
	this.followers = followers;
}
public String getLanguageCode() {
	return languageCode;
}
public void setLanguageCode(String languageCode) {
	this.languageCode = languageCode;
}
public Integer getRetweetCount() {
	return retweetCount;
}
public void setRetweetCount(Integer retweetCount) {
	this.retweetCount = retweetCount;
}
public String getRetweet() {
	return retweet;
}
public void setRetweet(String retweet) {
	this.retweet = retweet;
} 

}
