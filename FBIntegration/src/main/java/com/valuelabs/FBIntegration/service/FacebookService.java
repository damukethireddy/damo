package com.valuelabs.FBIntegration.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FriendList;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.PostData;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;


@Service
public class FacebookService {
	Logger logger = LoggerFactory.getLogger(FacebookService.class);
	@Value("${spring.social.facebook.appId}")
	String facebookAppId;

	@Value("${spring.social.facebook.appSecret}")
	String facebookSecret;

	@Value("${spring.social.facebook.callback}")
	String callbackUrl;

	@Value("${spring.social.facebook.scope}")
	String scope;

	String accessToken;
	
	public String createFacebookAuthorizationURL() {
		FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
		OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri(callbackUrl);
		params.setScope(scope);

		String url = oauthOperations.buildAuthorizeUrl(params);
		logger.info("createFacebookAuthorizationURL <---------------->" + url);
		return url;
	}

	public void createFacebookAccessToken(String code) {
		logger.info("Code ---->" + code);
		FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
		AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code, callbackUrl, null);
		accessToken = accessGrant.getAccessToken();
		logger.info("AccessToken ---->" + accessToken);
	}

	public String getName() {
		Facebook facebook = new FacebookTemplate(accessToken);
		String[] fields = { "id", "name", "email" };
		return facebook.fetchObject("me", String.class, fields);
	}

	public PagedList<Post> getFeeds() {
		Facebook facebook = new FacebookTemplate(accessToken);
		PagedList<Post> feeds = facebook.feedOperations().getFeed();
		return feeds;
	}

	public void postStatusMessage(String message) {
		Facebook facebook = new FacebookTemplate(accessToken);
		facebook.feedOperations().updateStatus(message);
	}

	public void postMessage(String message) {
		Facebook facebook = new FacebookTemplate(accessToken);
		facebook.feedOperations().post("me", message);
		
	}
	
	public void publishLink() {
		Facebook facebook = new FacebookTemplate(accessToken);
		facebook.feedOperations().post(new PostData("me").message("Spring Social!!!").link(
				"http://www.springsource.org/spring-social", null, "Spring Social", "The Spring Social Project",
				"Spring Social is an extension to Spring to enable applications to connect with service providers."));
	}

	public List<String> getFacebookFriendIds() {
		Facebook facebook = new FacebookTemplate(accessToken);
		List<String> friendIds = facebook.friendOperations().getFriendIds();
		return friendIds;
	}

	public List<User> getFriendProfiles() {
		Facebook facebook = new FacebookTemplate(accessToken);
		List<User> friends = facebook.friendOperations().getFriendProfiles();
		return friends;
	}

	public List<FriendList> getFriendLists() {
		Facebook facebook = new FacebookTemplate(accessToken);
		List<FriendList> friends = facebook.friendOperations().getFriendLists();
		return friends;
	}

	public List<Reference> getFriendListForSpecificUser(String specificUser) {
		Facebook facebook = new FacebookTemplate(accessToken);
		List<Reference> friends = facebook.friendOperations().getFriends(specificUser);
		return friends;
	}

	public PagedList<Reference> getGroups(String group) {
		Facebook facebook = new FacebookTemplate(accessToken);
		PagedList<Reference> groups = facebook.userOperations().search(group);
		// facebook.userOperations().PROFILE_FIELDS
		return groups;
	}

	public PagedList<Reference> getEvents(String eventName) {
		Facebook facebook = new FacebookTemplate(accessToken);
		PagedList<Reference> events = facebook.userOperations().search(eventName);
		return events;
	}
	
	public void postPhoto() {
		Facebook facebook = new FacebookTemplate(accessToken);
		facebook.feedOperations().post(new PostData("me").message("Photo!!!").link(
				"http://www.springsource.org/spring-social", "", "Spring Social", "The Spring Social Project",
				"Spring Social is an extension to Spring to enable applications to connect with service providers."));

		/*FacebookLink link = new FacebookLink("http://www.springsource.org/spring-social", "Spring Social",
				"The Spring Social Project",
				"Spring Social is an extension to Spring to enable applications to connect with service providers.",
				"C:/Users/Public/Videos/Sample Videos/Wildlife.wmv");

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.set("link", link.getLink());
		map.set("name", link.getName());
		map.set("caption", link.getCaption());
		map.set("description", link.getDescription());
		map.set("message", "Photo...");
		// Intentionally not adding null checks to the above to preserve backwards
		// compatibility
		if (link.getPicture() != null) {
			map.set("picture", link.getPicture());
		}
		facebook.publish(objectId, "feed", map);*/

	}
	
	
	
	/*public Catalog catalog() {	
	return new Catalog(Collections.singletonList(
			new ServiceDefinition(
					"mongodb-service-broker",
					"mongodb",
					"A simple MongoDB service broker implementation",
					true,
					false,
					Collections.singletonList(
							new Plan("mongo-plan",
									"default",
									"This is a default mongo plan.  All services are created equally.",
									getPlanMetadata())),
					Arrays.asList("mongodb", "document"),
					getServiceDefinitionMetadata(),
					null,
					null)));
}

 Used by Pivotal CF console 

private Map<String, Object> getServiceDefinitionMetadata() {
	Map<String, Object> sdMetadata = new HashMap<>();
	sdMetadata.put("displayName", "MongoDB");
	sdMetadata.put("imageUrl", "http://info.mongodb.com/rs/mongodb/images/MongoDB_Logo_Full.png");
	sdMetadata.put("longDescription", "MongoDB Service");
	sdMetadata.put("providerDisplayName", "Pivotal");
	sdMetadata.put("documentationUrl", "https://github.com/spring-cloud-samples/cloudfoundry-mongodb-service-broker");
	sdMetadata.put("supportUrl", "https://github.com/spring-cloud-samples/cloudfoundry-mongodb-service-broker");
	return sdMetadata;
}

private Map<String,Object> getPlanMetadata() {
	Map<String,Object> planMetadata = new HashMap<>();
	planMetadata.put("costs", getCosts());
	planMetadata.put("bullets", getBullets());
	return planMetadata;
}

private List<Map<String,Object>> getCosts() {
	Map<String,Object> costsMap = new HashMap<>();
	
	Map<String,Object> amount = new HashMap<>();
	amount.put("usd", 0.0);

	costsMap.put("amount", amount);
	costsMap.put("unit", "MONTHLY");
	
	return Collections.singletonList(costsMap);
}

private List<String> getBullets() {
	return Arrays.asList("Shared MongoDB server", 
			"100 MB Storage (not enforced)", 
			"40 concurrent connections (not enforced)");
}*/
}