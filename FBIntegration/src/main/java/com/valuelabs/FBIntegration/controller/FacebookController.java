package com.valuelabs.FBIntegration.controller;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.FriendList;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.api.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valuelabs.FBIntegration.service.FacebookService;

@RestController
public class FacebookController {
	
	
	@Autowired
	FacebookService facebookService;
	
	@GetMapping("/")
	public String createFacebookAuthorization() {
		return facebookService.createFacebookAuthorizationURL();
	}
	
	@GetMapping("/facebook")
	public void createFacebookAccessToken(@RequestParam("code") String code) {
		facebookService.createFacebookAccessToken(code);
	}

	@GetMapping("/getName")
	public String getNameResponse() {
		return facebookService.getName();
	}

	@GetMapping("/getFeeds")
	public ResponseEntity<PagedList<Post>> getFeedResponse() {
		return new ResponseEntity<PagedList<Post>>(facebookService.getFeeds(), HttpStatus.OK);
	}

	@GetMapping("/getGroups")
	public ResponseEntity<PagedList<Reference>> getGroups(@RequestParam String group) {
		return new ResponseEntity<PagedList<Reference>>(facebookService.getGroups(group), HttpStatus.OK);
	}
	
	@GetMapping("/getEvents")
	public ResponseEntity<PagedList<Reference>> getEvents(@RequestParam String event) {
		return new ResponseEntity<PagedList<Reference>>(facebookService.getEvents(event), HttpStatus.OK);
	}
	
	@GetMapping("/getFacebookFriendIds")
	public ResponseEntity<List<String>> getFacebookFriendIds() {
		return new ResponseEntity<List<String>>(facebookService.getFacebookFriendIds(), HttpStatus.OK);
	}
	
	@GetMapping("/getFriendProfiles")
	public ResponseEntity<List<User>> getFriendProfiles() {
		return new ResponseEntity<List<User>>(facebookService.getFriendProfiles(), HttpStatus.OK);
	}
	
	@GetMapping("/getFriendLists")
	public ResponseEntity<List<FriendList>> getFriendLists() {
		return new ResponseEntity<List<FriendList>>(facebookService.getFriendLists(), HttpStatus.OK);
	}
	
	@GetMapping("/getFriendListForSpecificUser")
	public ResponseEntity<List<Reference>> getFriendListForSpecificUser(@PathVariable("specificUser") String specificUser) {
		return new ResponseEntity<List<Reference>>(facebookService.getFriendListForSpecificUser(specificUser), HttpStatus.OK);
	}
	
	@PostMapping("/postStatus")
	public void postStatusMessage(@RequestBody String message) {
		facebookService.postStatusMessage(message);
	}

	@PostMapping("/postData")
	public void postData() {
		facebookService.publishLink();
	}

	@PostMapping("/postPhoto")
	public void postPhoto() {
		facebookService.postPhoto();
	}
	
	@PostMapping("/postMessage")
	public void postMessage(@RequestBody String message) {
		facebookService.postMessage(message);
	}
	
	
}