package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodMorbidityBank {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void post_MorbidityBank() {
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
	    
		String jsonBody ="{\r\n"
				+ "	\"morbidity_bank_id\": 0,\r\n"
				+ "	\"morbidity_bank_name\": \"Blood Bank Test"+randomNumber+"\",\r\n"
				+ "	\"disclaimer\": \"Testing123\",\r\n"
				+ "	\"is_active\": true,\r\n"
				+ "	\"created_by\": 103,\r\n"
				+ "	\"created_on\": \"2022-07-15T08:58:17\",\r\n"
				+ "	\"updated_by\": null,\r\n"
				+ "	\"updated_on\": null,\r\n"
				+ "	\"is_deleted\": false,\r\n"
				+ "	\"concept_class_id\": 0,\r\n"
				+ "	\"ruleset_id\": null\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.postMorbidityBank);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void get_MorbidityBankByMorbidityBank() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.pathParam("morbidity_bank_id", "94")
						.log().all()
						.get(SuperAdminEndPoints.geMorbidityBankByMorbidityBankId);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("morbidity_bank_id"), true 
				/*Actual Value*/, "Response body contains morbidity_bank_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void update_MorbidityBankByMorbidityBank() {
			
			String jsonBody ="{\r\n"
					+ "  \"morbidity_bank_id\": 93,\r\n"
					+ "  \"morbidity_bank_name\": \"kamran Blood bank\",\r\n"
					+ "  \"disclaimer\": \"Msg123\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-07-15T10:12:07\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-07-15T13:34:35.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.postMorbidityBank);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in MorbidityBank table successfully");
	}
	//@Test(priority=4)
	public static void delete_MorbidityBankByMorbidityBank() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.geMorbidityBankByMorbidityBankId);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}
}
