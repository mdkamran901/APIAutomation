package com.MorbidityLanguage.webAdmin.RoleMaster;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ALLMethodRoles {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_Roles() {
		
		String jsonBody ="{\"name\":\"Project Admin\",\"description\":\"Project Admin\",\"privileges\":[],\"inheritedRoles\":[{\"name\":\"ProjectAdmin\"}],\"uuid\":\"7dd38d69-2632-4169-ad0f-e562c8b16a00\"}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.AllMethod_Roles);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		Assert.assertEquals(response.getBody().path("description"), "Project Admin");
		
		
	}
	@Test(priority=2)
	public static void GET_Roles() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.log().all()
						.get(SuperAdminEndPoints.AllMethod_Roles);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("results"), true 
				/*Actual Value*/, "Response body contains results");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_Roles() {
			
			String jsonBody ="{\"name\":\"Testing\",\"description\":\"Testing1234\",\"privileges\":[],\"inheritedRoles\":[{\"name\":\"SuperAdmin\"}],\"uuid\":\"d4c44b67-afb3-441d-8bf1-109c4660861e\"}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.AllMethod_Roles);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			String bodyAsString = response.getBody().asString();
			Assert.assertEquals(bodyAsString.contains("privileges"), true 
					/*Actual Value*/, "Response body contains privileges");
			
			
	}
//	@Test(priority=4)
	public static void DELETE_Roles() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.queryParam("Isdelete", "true")
					        .log().all()
							.delete(SuperAdminEndPoints.Delete_Roles);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			
	}

}
