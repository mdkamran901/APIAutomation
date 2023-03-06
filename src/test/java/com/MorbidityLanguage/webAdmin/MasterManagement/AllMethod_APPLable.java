package com.MorbidityLanguage.webAdmin.MasterManagement;

import static io.restassured.RestAssured.given;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethod_APPLable {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test(priority=1)
	public static void POST_APPLable() {
		
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
	    
		String jsonBody ="{\r\n"
				+ "  \"app_label_text\": \"TestLabel"+randomNumber+"\",\r\n"
				+ "  \"app_label_code\": \"123"+randomNumber+"\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-22T07:07:23.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.AddAppLabel);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
	}

	@Test(priority=2)
	public static void GET_AppLabel() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.log().all()
						.get(SuperAdminEndPoints.AddAppLabel);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("app_label_id"), true 
				/*Actual Value*/, "Response body contains app_label_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
	}
	@Test(priority=3)
	public static void UPDATE_AppLabel() {
			
			String jsonBody ="{\r\n"
					+ "  \"app_label_id\": 177,\r\n"
					+ "  \"app_label_text\": \"Testing123\",\r\n"
					+ "  \"app_label_code\": \"123\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-22T06:40:25\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-22T07:13:21.000Z\",\r\n"
					+ "  \"is_dynamic\": true\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.AddAppLabel);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_app_label table successfully");
	}
//@Test(priority=4)
	public static void DELETE_AppLabel() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.AddAppLabel);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}


}
