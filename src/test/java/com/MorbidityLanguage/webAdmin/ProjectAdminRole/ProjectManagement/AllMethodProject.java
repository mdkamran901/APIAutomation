package com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodProject {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_ProjectList() {
		
		String jsonBody ="{\r\n"
				+ "  \"project_name\": \"Project Test\",\r\n"
				+ "  \"project_theme\": \"Project Test\",\r\n"
				+ "  \"project_level1\": 2,\r\n"
				+ "  \"project_level2\": \"3,5\",\r\n"
				+ "  \"project_level3\": \"14,15\",\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_on\": \"2022-08-01T11:32:19.000Z\",\r\n"
				+ "  \"is_deleted\": false,\r\n"
				+ "  \"project_language\": \"2\",\r\n"
				+ "  \"navigation_rendering_id\": 1,\r\n"
				+ "  \"question_rendering_id\": 1,\r\n"
				+ "  \"referral_card\": 1,\r\n"
				+ "  \"integration_level\": 0,\r\n"
				+ "  \"uniquet_type_id\": 1,\r\n"
				+ "  \"registration_unique_id\": 32,\r\n"
				+ "  \"third_party_integration_detail_id\": 2,\r\n"
				+ "  \"project_logo\": \"testing123\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.AllMethodProject);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_ProjectList() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("userid", "103")
				.queryParam("rolename", "SuperAdmin")
						.log().all()
						.get(SuperAdminEndPoints.AllMethodProject);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("project_id"), true 
				/*Actual Value*/, "Response body contains project_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_ProjectList() {
			
			String jsonBody ="{\r\n"
					+ "  \"project_id\": 152,\r\n"
					+ "  \"project_name\": \"Blood Testing\",\r\n"
					+ "  \"project_theme\": \"abcd\",\r\n"
					+ "  \"project_level1\": 2,\r\n"
					+ "  \"project_level2\": \"5\",\r\n"
					+ "  \"project_level3\": \"18\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-07-18T13:59:40.000Z\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-07-18T13:50:46\",\r\n"
					+ "  \"project_language\": \"2\",\r\n"
					+ "  \"navigation_rendering_id\": 2,\r\n"
					+ "  \"question_rendering_id\": 2,\r\n"
					+ "  \"referral_card\": 2,\r\n"
					+ "  \"integration_level\": 2,\r\n"
					+ "  \"uniquet_type_id\": 1,\r\n"
					+ "  \"registration_unique_id\": 34,\r\n"
					+ "  \"third_party_integration_detail_id\": 2\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.AllMethodProject);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mst_project table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_ProjectList() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("project_id", "67")
					        .log().all()
							.delete(SuperAdminEndPoints.DeleteProject);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}

}
