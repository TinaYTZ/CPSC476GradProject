package com.gradproject.twitter.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;



@RestController
@RequestMapping(TwitterController.Twitter_Base_URI)
public class TwitterController {
	
	public static final String Twitter_Base_URI="/hSearch";
	@Autowired 
	private Twitter twitter;
	
	@RequestMapping(method = RequestMethod.POST)
	public List<String> getHTweets( @RequestParam(value="hashTag", required=false)  String hashTag ){
		List<Tweet> result = twitter.searchOperations().search(hashTag, 50).getTweets();
		List <String> text= new  ArrayList<String>();;
		for (int i=0; i< result.size();i++){
			Tweet tem= result.get(i);
			System.out.println("tem.text"+tem.getText());
			text.add(tem.getText());
			
			
		}
			
		return text;
		
	}
	
	@RequestMapping(value="{hashTag}", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> getTweets(@PathVariable final String hashTag ){
		
		List<Tweet> result = twitter.searchOperations().search(hashTag, 50).getTweets();
		List <String> text= new  ArrayList<String>();;
		for (int i=0; i< result.size();i++){
			Tweet tem= result.get(i);
			System.out.println("tem.text"+tem.getText());
			text.add(tem.getText());
			
			
		}
			
		return text;
		
		//return twitter.searchOperations().search(hashTag, 20).getTweets();
	}
	
	@RequestMapping(produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getMyTweets(){
		return twitter.timelineOperations().getUserTimeline("youtingdada");
		
	}

}


	
	

