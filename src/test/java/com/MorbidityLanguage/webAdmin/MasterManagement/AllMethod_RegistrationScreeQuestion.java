package com.MorbidityLanguage.webAdmin.MasterManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethod_RegistrationScreeQuestion {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_RegistrationScreeQuestion() {
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
		
		String jsonBody ="{\r\n"
				+ "  \"person_attribute_type_id\": 0,\r\n"
				+ "  \"type_id\": 9,\r\n"
				+ "  \"question\": \"How was Test"+randomNumber+"\",\r\n"
				+ "  \"instructions\": \"Testing123\",\r\n"
				+ "  \"max_length\": \"123\",\r\n"
				+ "  \"regex\": \"123"+randomNumber+"\",\r\n"
				+ "  \"flag\": 0,\r\n"
				+ "  \"attribute_type_key\": \"123"+randomNumber+"\",\r\n"
				+ "  \"page_no\": 1,\r\n"
				+ "  \"sequence\": \"1\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-22T11:30:59.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.RegistrationScreeQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_RegistrationScreeQuestion() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				
				//.queryParam("project_id", "152")
						.log().all()
						.get(SuperAdminEndPoints.RegistrationScreeQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("question_id"), true 
				/*Actual Value*/, "Response body contains question_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_RegistrationScreeQuestione() {
			
			String jsonBody ="{\r\n"
					+ "  \"question_id\": 64,\r\n"
					+ "  \"person_attribute_type_id\": 105,\r\n"
					+ "  \"type_id\": 9,\r\n"
					+ "  \"question\": \"How was Test\",\r\n"
					+ "  \"instructions\": \"Testing123\",\r\n"
					+ "  \"max_length\": 123,\r\n"
					+ "  \"regex\": \"123\",\r\n"
					+ "  \"flag\": 0,\r\n"
					+ "  \"attribute_type_key\": \"123\",\r\n"
					+ "  \"page_no\": 1,\r\n"
					+ "  \"sequence\": 1,\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-22T11:35:09.000Z\",\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-22T11:30:59\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.RegistrationScreeQuestion);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_person_attribute_type_question table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_RegistrationScreeQuestione() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("project_id", "67")
					        .log().all()
							.delete(SuperAdminEndPoints.RegistrationScreeQuestion);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}




}
