package com.ourpeople.models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.wordnik.swagger.annotations.ApiModel;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserDetails {
	
	 private static final long serialVersionUID = 8377351251450326973L;

	 	private String status;

	 	private String id;
	 	
	 	@Getter(AccessLevel.NONE)
	 	@Setter(AccessLevel.NONE)
	 	private String password;
	 	
	 	private String name;
		
	 	private String email;
	   
	 	private String phone;
	    
	 	private Integer is_verified;
	    
	 	private boolean community_id;
	    
	 	private String text;
}
