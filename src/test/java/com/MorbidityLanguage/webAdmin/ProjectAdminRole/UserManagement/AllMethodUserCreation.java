package com.MorbidityLanguage.webAdmin.ProjectAdminRole.UserManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodUserCreation {
	
	static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_AddUser() {
		
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
				+ "    \"ProjectAdmin\",\r\n"
				+ "    \"ProjectManager\",\r\n"
				+ "    \"SuperAdmin\"\r\n"
				+ "  ],\r\n"
				+ "  \"firstName\": \"md\",\r\n"
				+ "  \"lastName\": \"kamran\",\r\n"
				+ "  \"id\": null,\r\n"
				+ "  \"username\": \"mdkamran\",\r\n"
				+ "  \"registrationNumber\": \"123\",\r\n"
				+ "  \"screeningRegion\": null,\r\n"
				+ "  \"puskesmasDoctor\": null\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(ProjectAdminEndPoints.ALLMethod_Users);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
@Test(priority=2)
	public static void GET_UserList() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.log().all()
						.get(ProjectAdminEndPoints.ALLMethod_Users);

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
@Test(priority=3)
	public static void UPDATE_User() {
			
			String jsonBody ="{\r\n"
					+ "  \"email\": {\r\n"
					+ "    \"value\": \"mdkamran67@gmail.com\"\r\n"
					+ "  },\r\n"
					+ "  \"dateRegistered\": {\r\n"
					+ "    \"value\": \"2022-07-28T12:33:26.377Z\"\r\n"
					+ "  },\r\n"
					+ "  \"phoneNumber\": {\r\n"
					+ "    \"value\": \"9334291284\"\r\n"
					+ "  },\r\n"
					+ "  \"location\": {\r\n"
					+ "    \"block\": \"delhi\"\r\n"
					+ "  },\r\n"
					+ "  \"roles\": [\r\n"
					+ "    \"ProjectAdmin\",\r\n"
					+ "    \"ProjectManager\",\r\n"
					+ "    \"SuperAdmin\"\r\n"
					+ "  ],\r\n"
					+ "  \"username\": \"mdkamran\",\r\n"
					+ "  \"display\": \"md kamran\",\r\n"
					+ "  \"personid\": \"529e7cf2-4567-4bfd-a2a8-4ba9a8171912\",\r\n"
					+ "  \"nameid\": \"9a1e6225-2fa7-4cd4-be66-e9c036011ee3\",\r\n"
					+ "  \"status\": \"Active\",\r\n"
					+ "  \"trainingModules\": [],\r\n"
					+ "  \"registrationNumber\": \"123\",\r\n"
					+ "  \"firstName\": \"md\",\r\n"
					+ "  \"lastName\": \"kamran\",\r\n"
					+ "  \"id\": \"12f4a4ee-1ce3-41c8-a1e2-7d571018a2f1\",\r\n"
					+ "  \"screeningRegion\": null,\r\n"
					+ "  \"puskesmasDoctor\": null\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(ProjectAdminEndPoints.ALLMethod_Users);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 202);
			String bodyAsString = response.getBody().asString();
			Assert.assertEquals(bodyAsString.contains("display"), true 
					/*Actual Value*/, "Response body contains display");
			
	}
//@Test(priority=4)
	public static void DELETE_User() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("id", "24c1fc58-33b0-4c4d-9ed6-602fe1281365")
					        .log().all()
							.delete(ProjectAdminEndPoints.DeleteUser);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			//Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			
	}
	//@Test(priority=5)
	public static void statusActive_User() {
		
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				//.pathParam("id", "24c1fc58-33b0-4c4d-9ed6-602fe1281365")
				        .log().all()
						.delete(ProjectAdminEndPoints.StatusActiveUser);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
	}

}
