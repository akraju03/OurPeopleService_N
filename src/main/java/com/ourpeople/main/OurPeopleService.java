package com.ourpeople.main;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.ourpeople.health.TemplateHealthCheck;
import com.ourpeople.main.OurPeopleConfiguration;
import com.ourpeople.resources.HelloWorldResource;
import com.ourpeople.resources.LoginResource;

public class OurPeopleService extends Service<OurPeopleConfiguration> {
	public static void main(String[] args) throws Exception {
		new OurPeopleService().run(args);
	}

	private OurPeopleService() {
		super("hello-world");
	}

	@Override
	protected void initialize(OurPeopleConfiguration configuration,
				  Environment environment) {
		final String template = configuration.getTemplate();
		final String defaultName = configuration.getDefaultName();
		environment.addResource(new HelloWorldResource(template, defaultName));
		environment.addResource(new LoginResource());
		environment.addHealthCheck(new TemplateHealthCheck(template));
	}
}
