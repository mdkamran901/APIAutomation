package com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement;

import static io.restassured.RestAssured.given;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodAddLanguageMaster {
	

	static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_AddLanguageMaster() {
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
		
		String jsonBody ="{\r\n"
				+ "  \"language\": \"Bangali"+randomNumber+"\",\r\n"
				+ "  \"language_code\": \"BG\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-06T11:37:04.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(ProjectAdminEndPoints.AllMethodLanguageMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_AddLanguageMaster() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				//.queryParam("mask_validation", "kamran testing")
				.queryParam("language", "Hindi")
						.log().all()
						.get(ProjectAdminEndPoints.AllMethodLanguageMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("language_id"), true 
				/*Actual Value*/, "Response body contains language_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_AddLanguageMaster() {
			
			String jsonBody ="{\r\n"
					+ "  \"language_id\": 13,\r\n"
					+ "  \"language\": \"Bangal\",\r\n"
					+ "  \"language_code\": \"BG\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-06T11:37:04\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-20T09:19:44.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(ProjectAdminEndPoints.AllMethodLanguageMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_language table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_AddLanguageMaster() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("location_level", "67")
					        .log().all()
							.delete(ProjectAdminEndPoints.AllMethodLanguageMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}


}
