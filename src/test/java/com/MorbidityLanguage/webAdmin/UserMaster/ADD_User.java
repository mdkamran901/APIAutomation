package com.MorbidityLanguage.webAdmin.UserMaster;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ADD_User {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test(invocationCount = 25)
	public static void post_AddUser() {
		
		Random rand = new Random();          // Generate random integers in range 0 to 999        
		int rand_int1 = rand.nextInt(1000);
		rand_int1 = rand.nextInt(1000);
		
		String jsonBody ="{\r\n"
				+ "  \"email\": {\r\n"
				+ "    \"value\": \"mdkamran67@gmail.com\"\r\n"
				+ "  },\r\n"
				+ "  \"dateRegistered\": {\r\n"
				+ "    \"value\": \"2022-07-28T12:32:02.662Z\"\r\n"
				+ "  },\r\n"
				+ "  \"phoneNumber\": {\r\n"
				+ "    \"value\": \"9334291284\"\r\n"
				+ "  },\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"block\": \"delhi\"\r\n"
				+ "  },\r\n"
				+ "  \"roles\": [\r\n"
				+ "    \"ASHA\",\r\n"
				+ "    \"\",\r\n"
				+ "    \"\"\r\n"
				+ "  ],\r\n"
				+ "  \"firstName\": \"QA"+rand_int1+"\",\r\n"
				+ "  \"lastName\": \"kamran"+rand_int1+"\",\r\n"
				+ "  \"id\": null,\r\n"
				+ "  \"username\": \"Asha"+rand_int1+"\",\r\n"
				+ "  \"registrationNumber\": \"123\",\r\n"
				+ "  \"screeningRegion\": null,\r\n"
				+ "  \"puskesmasDoctor\": null\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ALLMethod_Users);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}
}
