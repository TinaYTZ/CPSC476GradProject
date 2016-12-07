package com.gradproject.twitter.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping(GetProfile.Twitter_Base_URI)
public class GetProfile {
	
	public static final String Twitter_Base_URI="/profile";
	@Autowired 
	private Twitter twitter;
	
	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView getTimeLin(HttpServletRequest request, 
	        @RequestParam(value="username", required=false) String username){
		
		System.out.println("PROFILE:userName"+username);
		String err="";
		String userName = null;
		String url = null;
		int friends = 0;
		int follower = 0;
		ModelAndView model = new ModelAndView("hello");
		try{
		TwitterProfile profile = twitter.userOperations().getUserProfile(username);
			System.out.println("profile:"+profile);
			System.out.println("userid"+profile.getScreenName());
			userName=profile.getScreenName();
			url=profile.getProfileImageUrl();
			friends=profile.getFriendsCount();
			follower=profile.getFollowersCount();	
		}catch(Exception e){ 
			   err="Sorry! Not authorized";
			   System.out.println("err"+e);
			}
		model.addObject("usernamae",     "ScreenID:         "+  userName);
		model.addObject("image", url);
		model.addObject("frindCount",    "frinds Count:     "+friends);
		model.addObject("followerCount", "follower Count:   "+follower);
		model.addObject("error",err);
	
		return model;
		
	}	

}
