package com.TokenAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.ConstantData.WebConstantData;
import com.EndPoints.Asha_Endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenGenerateWeb {
	static String AccessToken;
	
	@Test
	public String getAccessToken() {
		WebConstantData cd = new WebConstantData();
		
		RestAssured.baseURI = cd.getBaseURL();

		Response response =

				given().auth().preemptive().basic(cd.getUsername(), cd.getPassword())
				.log().all()
				.post(Asha_Endpoints.token);

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());
		String accessToken = response.getBody().path("accessToken");
		System.out.println("Access token is" + accessToken);
		//String dbUserId =response.getBody().path("dbUserId");
		//System.out.println("DbUserId is" + dbUserId);
		return accessToken;
		 
	
}
}
