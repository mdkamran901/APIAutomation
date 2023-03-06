package com.MorbidityLanguage.webAdmin.ProjectManagement;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GET_UserByRole {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=2)
	public static void getUserByRole() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("username", "Md.Kamran")
				.queryParam("roles", "SuperAdmin")
						.log().all()
						.get(SuperAdminEndPoints.getUserByNameRoles);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("display"), true 
				/*Actual Value*/, "Response body contains display");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
