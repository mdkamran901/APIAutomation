package com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodProjectTheme {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void postProjectTheme() {
		
		String jsonBody ="{\r\n"
				+ "  \"project_id\": 145,\r\n"
				+ "  \"primary_color_id\": 4,\r\n"
				+ "  \"secondry_color_id\": 4,\r\n"
				+ "  \"icon_color_id\": 4,\r\n"
				+ "  \"header_color_id\": 4,\r\n"
				+ "  \"button_color_id\": 4,\r\n"
				+ "  \"subheader_color_id\": 4,\r\n"
				+ "  \"page_navigation_active_color_id\": 4,\r\n"
				+ "  \"page_navigation_inactive_color_id\": 4,\r\n"
				+ "  \"side_navigation_color_id\": 4,\r\n"
				+ "  \"tertiary_color_id\": 9,\r\n"
				+ "  \"primary_color_two_id\": 9,\r\n"
				+ "  \"button_color_two_id\": 9,\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-01T14:07:38.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ProjectTheme);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void getProjectTheme() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("userid", "103")
				//.queryParam("project_id", "152")
				.queryParam("rolename", "SuperAdmin")
						.log().all()
						.get(SuperAdminEndPoints.ProjectTheme);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_theme_id"), true 
				/*Actual Value*/, "Response body contains project_theme_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void updateProjectTheme() {
			
			String jsonBody ="{\r\n"
					+ "  \"project_theme_id\": 15,\r\n"
					+ "  \"project_id\": 152,\r\n"
					+ "  \"primary_color_id\": 4,\r\n"
					+ "  \"secondry_color_id\": 16,\r\n"
					+ "  \"tertiary_color_id\": 4,\r\n"
					+ "  \"button_color_id\": 4,\r\n"
					+ "  \"side_navigation_color_id\": 4,\r\n"
					+ "  \"icon_color_id\": 4,\r\n"
					+ "  \"header_color_id\": 9,\r\n"
					+ "  \"subheader_color_id\": 4,\r\n"
					+ "  \"page_navigation_active_color_id\": 4,\r\n"
					+ "  \"page_navigation_inactive_color_id\": 4,\r\n"
					+ "  \"primary_color_two_id\": 4,\r\n"
					+ "  \"button_color_two_id\": 4,\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_on\": \"2022-07-19T07:53:01\",\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-07-19T08:22:19.000Z\",\r\n"
					+ "  \"is_dynamic\": true\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.ProjectTheme);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_project_theme table successfully");
	}
	//@Test(priority=4)
	public static void deleteProjectTheme() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("project_id", "67")
					        .log().all()
							.delete(SuperAdminEndPoints.ProjectTheme);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}



}
