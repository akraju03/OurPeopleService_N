package com.ourpeople.main;

import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class OurPeopleConfiguration extends Configuration {
	@NotEmpty
	@JsonProperty
	private String template;

	@NotEmpty
	@JsonProperty
	private String defaultName = "Stranger";

	public String getTemplate() {
		return template;
	}

	public String getDefaultName() {
		return defaultName;
	}
	
	@JsonProperty
	private String service;
	
	@JsonProperty
	private String host;
	
	@JsonProperty
	private String endpoint;
}
