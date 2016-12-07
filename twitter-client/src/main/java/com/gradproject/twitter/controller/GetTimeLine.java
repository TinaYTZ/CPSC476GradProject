package com.gradproject.twitter.controller;



import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;



@RestController
@RequestMapping(GetTimeLine.Twitter_Base_URI)
public class GetTimeLine {
	
	public static final String Twitter_Base_URI="/timeline";
	@Autowired 
	private Twitter twitter;
	@RequestMapping(value="{action}", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView getTimeLine(@PathVariable final String username ){
		System.out.println("userName"+username);
		ModelAndView model = new ModelAndView("hello");
		try{List<Tweet> result =twitter.timelineOperations().getUserTimeline(username);
			List <String> text= new  ArrayList<String>();
			for (int i=0; i< result.size();i++){
				Tweet tem= result.get(i);
				System.out.println("tem.text"+tem.getText());
				text.add(tem.getText());
			}
			model.addObject("tweets", text);
		}catch(Exception e){ 
			    List<String> text = Arrays.asList("Sorry! Not authorized");
				model.addObject("tweets", text);
			    	return  model;
			}
		TwitterProfile profile = twitter.userOperations().getUserProfile(username);
		System.out.println("profile:"+profile);
		String uId=profile.getScreenName();
		String url=profile.getProfileImageUrl();
		int frindCount=profile.getFollowersCount();
		System.out.println("profile:"+uId+"url"+url+"friend"+frindCount);
		return model;
	}	

	
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView getTimeLin(HttpServletRequest request, 
	        @RequestParam(value="username", required=false) String username){
		System.out.println("userName"+username);
		ModelAndView model = new ModelAndView("hello");
		try{List<Tweet> result =twitter.timelineOperations().getUserTimeline(username);
			List <String> text= new  ArrayList<String>();
			for (int i=0; i< result.size();i++){
				Tweet tem= result.get(i);
				System.out.println("tem.text"+tem.getText());
				text.add(tem.getText());
			}
			model.addObject("tweets", text);
		}catch(Exception e){ 
			    List<String> text = Arrays.asList("Sorry! Not authorized");
				model.addObject("tweets", text);
			    	return  model;
			}
		TwitterProfile profile = twitter.userOperations().getUserProfile(username);
		System.out.println("profile:"+profile);
		String uId=profile.getScreenName();
		String url=profile.getProfileImageUrl();
		int frindCount=profile.getFollowersCount();
		System.out.println("profile:"+uId+"url"+url+"friend"+frindCount);
		return model;
	}	

}
