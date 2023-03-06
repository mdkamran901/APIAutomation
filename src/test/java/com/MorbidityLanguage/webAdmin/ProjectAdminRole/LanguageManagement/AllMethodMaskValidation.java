package com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodMaskValidation {
	
	static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_MaskValidation() {
		
		String jsonBody ="{\r\n"
				+ "  \"mask_validation\": \"Kamran Testing\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-06T11:27:52.000Z\",\r\n"
				+ "  \"is_deleted\": false,\r\n"
				+ "  \"is_dynamic\": true,\r\n"
				+ "  \"regex\": \"0\",\r\n"
				+ "  \"validation_key\": \"SPDCD\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(ProjectAdminEndPoints.AllMethodMaskValidation);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_MaskValidation() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("mask_validation", "kamran testing")
				//.queryParam("language_id", "0")
						.log().all()
						.get(ProjectAdminEndPoints.AllMethodMaskValidation);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("mask_validation_id"), true 
				/*Actual Value*/, "Response body contains mask_validation_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_MaskValidation() {
			
			String jsonBody ="{\r\n"
					+ "  \"mask_validation_id\": 28,\r\n"
					+ "  \"mask_validation\": \"Kamran Testing\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-06T11:27:52\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-06T11:34:21.000Z\",\r\n"
					+ "  \"is_dynamic\": true\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(ProjectAdminEndPoints.AllMethodMaskValidation);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_mask_validation table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_MaskValidation() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("location_level", "67")
					        .log().all()
							.delete(ProjectAdminEndPoints.AllMethodMaskValidation);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}


}
