package com.damodar.facebookIntegration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import facebook4j.BatchRequest;
import facebook4j.BatchRequests;
import facebook4j.BatchResponse;
import facebook4j.Checkin;
import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.GeoLocation;
import facebook4j.Group;
import facebook4j.Like;
import facebook4j.Media;
import facebook4j.Place;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.VideoUpdate;
import facebook4j.api.VideoMethods;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.http.RequestMethod;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;
import facebook4j.json.DataObjectFactory;


public class FbIntegration {

	public static void main(String[] args) throws FacebookException, IOException, JSONException {
		Configuration configuration = createConfigurationBuilder();
		Facebook facebook = createFacebook(configuration);

		postStatusMessage(facebook);
		getUsers(facebook);
		//getLocationBasedShops(facebook);
		//getVideos(facebook); 
		//getPhotoLikes(facebook);
		//getEvents(facebook);
		//getGroups(facebook);
		//getContacts(facebook);
		
		
		//publishLink(facebook);
		//publishPhoto(facebook);
		//publishVideo(facebook);
		
		
		 /*printGeneralInfo(facebook); 
		 String searchPost = "ValueLabs";
		 writePostsToFile(facebook, searchPost);*/
		
		
		
		
		
	}
		
	/**
	 * This method is used to make the configuration builder and Set application id,
	 * secret key and access token and then finally Create configuration builder
	 * object
	 * 
	 * @return
	 */
	private static Configuration createConfigurationBuilder() {

		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true);
		configurationBuilder.setOAuthAppId("218234148739903"); 
		configurationBuilder.setOAuthAppSecret("19e775438e2c5231d68e6c24aef0d043");
		configurationBuilder.setOAuthAccessToken(
				"EAADGe5jp2z8BANXUs1zhK9y4MV0W5Kn71ur80fdgykcHgTcHAkWnoUKZC0mVoEE7VzXemVPComZAN84sON3i9kv5giqsY1Up81IjzduTLlzsnu5LChNhmZCO40cHtfOsZAHeOAY3aFKwmvXsUZCAqrc9BMGpOhqQfdZCkhi4BnNw61FU0ubsqc4iXrkiJJGiZChGnC5tm3N6wZDZD");
		
		configurationBuilder.setOAuthPermissions(
				"email, user_hometown, user_religion_politics,publish_actions,read_custom_friendlists, publish_pages,user_likes, user_status,user_about_me, user_location,user_tagged_places,user_birthday,user_photos,user_videos,user_education_history,user_posts,user_website,user_friends,user_relationship_details,user_work_history,user_games_activity,user_relationships, read_stream, manage_pages");
		configurationBuilder.setUseSSL(true);
		configurationBuilder.setJSONStoreEnabled(true);

		return configurationBuilder.build();
	}

	/**
	 * This method is used to create a facebook object
	 * 
	 * @param configuration
	 * @return
	 * @throws FacebookException 
	 */
	private static Facebook createFacebook(Configuration configuration) throws FacebookException {
		FacebookFactory ff = new FacebookFactory(configuration);
		Facebook facebook = ff.getInstance();
		facebook.extendTokenExpiration(configuration.getOAuthAccessToken());
		return facebook;
	}
	

	private static void getContacts(Facebook facebook) throws FacebookException, JSONException {
		BatchRequests<BatchRequest> batch = new BatchRequests<BatchRequest>();
		batch.add(new BatchRequest(RequestMethod.GET, "me/friends"));
		List<BatchResponse> results = facebook.executeBatch(batch);
		System.out.println("results:" + results);
		BatchResponse result1 = results.get(0);

		String jsonString = result1.asString();
		JSONObject j = new JSONObject(jsonString);
		JSONArray array = (JSONArray) j.get("data");
		for (int i = 0; i < array.length(); i++) {
			User user = DataObjectFactory.createUser(array.getString(i));
			System.out.println("User: " + user.getName());
			System.out.println("Id: " + user.getId());
			
		}
	}

	private static void getCheckIns(Facebook facebook) throws FacebookException {
		ResponseList<Checkin> checkins = facebook.searchCheckins();
		for (Checkin checkin : checkins) {
			System.out.println(checkin.getMessage());
		}
	}

	private static void getGroups(Facebook facebook) throws FacebookException {
		ResponseList<Group> groups = facebook.searchGroups("Tollywood");
		for (Group group : groups) {
				System.out.println("\n---------------------------------");
				System.out.println(group.getName());
			
		}
	}

	private static void getEvents(Facebook facebook) throws FacebookException {
		ResponseList<Event> events = facebook.searchEvents("conference");
		for (Event event : events) {
			//System.out.println(event.getLocation());
			//if ("Hyderabad".equalsIgnoreCase(event.getLocation())) {
				System.out.println(event.getName() + " " + event.getDescription());
				System.out.println("\n---------------------------------\n");
				
			//}
		}
	}



	private static void getUsers(Facebook facebook) throws FacebookException {
		ResponseList<User> results = facebook.searchUsers("Gangadhar Reddy Kethireddy");
		for (User user : results) {
			System.out.println(user.getName());			
		}
	}

	/**
	 * @param facebook
	 * @throws FacebookException
	 * @throws MalformedURLException
	 */
	private static void publishLink(Facebook facebook) throws FacebookException, MalformedURLException {
	/*1.	PostUpdate post = new PostUpdate(new URL("http://facebook4j.org"))
                .picture(new URL("http://facebook4j.org/images/hero.png"))
                .name("Facebook4J - A Java library for the Facebook Graph API")
                .caption("facebook4j.org")
                .description("Facebook4J is a Java library for the Facebook Graph API.");
		facebook.postFeed(post);*/
		
		
		/*2. PostUpdate post = new PostUpdate(new URL("http://tutorials.jenkov.com/java-concurrency/index.html"))
                .name("Jakob Jenkov - Java Concurrency / Multithreading Tutorial")
                .description("Jakob Jenkov Tutorials.");
		facebook.postFeed(post);*/
		
		facebook.postLink(new URL("https://www.journaldev.com/2888/spring-tutorial-spring-core-tutorial"), "Spring Core Framework Tutorials");
	}

	/**
	 * @param facebook
	 * @throws FacebookException
	 */
	private static void publishPhoto(Facebook facebook) throws FacebookException {
		Media photo = new Media(new File("C:/Users/Public/Pictures/Sample Pictures/Penguins.jpg"));
		facebook.postPhoto(photo);
		System.out.println("Photo Posted!!!");
	}
	

	

	/**
	 * @param facebook
	 * @throws FacebookException
	 */
	private static void postStatusMessage(Facebook facebook) throws FacebookException {
		facebook.postStatusMessage("Hello Friends!!!");
	}

	/**
	 * This method is used to get posts for a particular search
	 * 
	 * @param Facebook
	 * @param searchPost
	 * @return
	 * @throws FacebookException
	 */
	private static String getFacebookPosts(Facebook Facebook, String searchPost) throws FacebookException {

		ResponseList<Post> results = Facebook.getPosts(searchPost);
		StringBuilder searchMessage = new StringBuilder();
		for (Post post : results) {
			if (post.getMessage() != null) {
				searchMessage.append(post.getMessage());
			}
		}

		return searchMessage.toString();
	}
	
	private static String getLocationBasedShops(Facebook facebook) throws FacebookException {
		System.out.println("Enter a place (ex: coffee, food, bar, medical)");
		Scanner reader = new Scanner(System.in);
		String location = reader.next();
		GeoLocation center = new GeoLocation(17.3753, 78.4744);
		int distance = 1000;
		ResponseList<Place> results = facebook.searchPlaces(location, center, distance);
		StringBuilder searchMessage = new StringBuilder();
		System.out.println("Name of the " + location + "\n");
		for (Place place : results) {
			if ("Hyderabad".equals(place.getLocation().getCity())) {
				searchMessage.append(place.getName())
				.append("\t\t\t\t\t")
				.append(place.getLocation().getStreet()!=null? place.getLocation().getStreet(): "")
				.append("\t\t")
				.append(place.getLocation().getZip())
							 .append("\n");
			}
		}
		System.out.println(searchMessage.toString());
		
		return searchMessage.toString();
	}

	private static void getVideos(Facebook facebook) throws FacebookException {
		String videoId = "2295845580441117";
		VideoMethods videoMethods = facebook.videos();
		StringBuilder sb = new StringBuilder();
		sb.append("Video Likes Count: ").append(videoMethods.getVideoLikes(videoId).size())
				.append("\nDescription of the Video: ").append(videoMethods.getVideo(videoId).getDescription());

		System.out.println(sb.toString());
	}


	private static void getPhotoLikes(Facebook facebook) throws FacebookException {

		Iterator<Like> i = facebook.photos().getPhotoLikes("2117847338240943").iterator();
		System.out.println(" Photo Likes \n");
		while (i.hasNext()) {
			Like like = i.next();
			System.out.println(like.getName());
		}

	}
	
	private static void publishVideo(Facebook facebook) throws FacebookException {
		Media videoSource = new Media(new File("C:/Users/Public/Videos/Sample Videos/Wildlife.wmv"));
		VideoUpdate videoUpdate = new VideoUpdate(videoSource);
		videoUpdate.description("Wildlife Animals");
		facebook.postVideo(videoUpdate);
		System.out.println("Video Posted!!!");
	}
	
	/**
	 * Write facebook posts to a file
	 * 
	 * @param facebook
	 * @throws FacebookException
	 * @throws IOException
	 */
	private static void writePostsToFile(Facebook facebook, String searchPost) throws FacebookException, IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			String fileName = getFileName(searchPost);
			String results = getFacebookPosts(facebook, searchPost);
			System.out.println(results);
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
				fw = new FileWriter(file.getAbsoluteFile());
				bw = new BufferedWriter(fw);
				bw.write(results);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
			}
			if (fw != null) {
				fw.close();
			}

		}
	}

	/**
	 * This method is used to print general information
	 * 
	 * @param facebook
	 * @throws FacebookException
	 */
	private static void printGeneralInfo(Facebook facebook) throws FacebookException {
		StringBuilder builder = new StringBuilder();
		builder.append("Id: ");
		builder.append(facebook.getId());
		builder.append("\nName: ");
		builder.append(facebook.getName());

		System.out.println(builder.toString());
	}

	/**
	 * @param searchPost
	 * @return
	 */
	private static String getFileName(String searchPost) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm");
		String fileName = "D:\\FacebookPosts\\File\\" + searchPost + "_" + simpleDateFormat.format(date) + ".txt";
		return fileName;
	}
	
	/*public static String stringToJson(String data) {
		JsonConfig cfg = new JsonConfig();
		try {
			JSONObject jsonObject = JSONObject.fromObject(data, cfg);
			System.out.println("JSON = " + jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "JSON Created";
	}*/
}
