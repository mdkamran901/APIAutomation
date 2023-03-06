package com.TokenAuthentication;

import org.testng.annotations.Test;

import com.ConstantData.AshaContantData;
import com.EndPoints.Asha_Endpoints;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GenerateTokenAshaUser {
	//AshaContantData cd = new AshaContantData();
	static String AccessToken;
	
	@Test
	public String getAccessToken() {
		AshaContantData cd = new AshaContantData();
		
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
	
	//@Test
	/*
	 * public int getUserId() { RestAssured.baseURI = cd.getBaserURL();
	 * 
	 * Response response =
	 * 
	 * given().auth().preemptive().basic(cd.getUsername(), cd.getPassword())
	 * .post(Asha_Endpoints.token);
	 * 
	 * //response.prettyPrint(); System.out.println("status code is"
	 * +response.statusCode()); int UserId = response.getBody().path("dbUserId");
	 * System.out.println("dbUserId" + UserId); return UserId; }
	 */
			
}