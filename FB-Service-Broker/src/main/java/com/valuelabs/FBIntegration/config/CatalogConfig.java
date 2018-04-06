package com.valuelabs.FBIntegration.config;

import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;

import java.util.Arrays;
import java.util.HashMap;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {

	@Bean
	Catalog catalog() {
		return new Catalog(singletonList(new ServiceDefinition("facebook-broker", "facebook", "A facebook service broker", true,
				false, singletonList(new Plan("facebook", "free", "free plan", new HashMap<String, Object>() {
					{
						put("costs", singletonList(new HashMap<String, Object>() {
							{
								put("amount", singletonMap("usd", 0.0));
								put("unit", "MONTHLY");
							}
						}));
						put("bullets", "facebook");
					}
				}, true)), Arrays.asList("tag A", "tag B", "tag C"), new HashMap<String, Object>() {
					{
						put("displayName", "Facebook");
						put("longDescription", "Facebook Service");
						put("imageUrl",
								"https://www.cloudfoundry.org/wp-content/uploads/2015/10/CF_rabbit_Blacksmith_rgb_trans_back-269x300.png");
						put("providerDisplayName", "@Facebook");
					}
				}, null, null)));
	}

	@Bean
	RequestDumperFilter requestDumperFilter() {
		return new RequestDumperFilter();
	}

}