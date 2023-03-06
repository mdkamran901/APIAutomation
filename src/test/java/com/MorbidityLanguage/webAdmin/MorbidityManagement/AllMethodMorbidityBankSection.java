package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodMorbidityBankSection {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
@Test(priority=1)
	public static void postMorbidityBankPage() {
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
		
		String jsonBody ="{\r\n"
				+ "  \"morbidity_bank_id\": 94,\r\n"
				+ "  \"morbidity_bank_page_no\": \"1\",\r\n"
				+ "  \"morbidity_bank_page\": \"Testing"+randomNumber+"\",\r\n"
				+ "  \"morbidity_bank_page_is_active\": true,\r\n"
				+ "  \"morbidity_bank_page_sequence\": \"1"+randomNumber+"\",\r\n"
				+ "  \"morbidity_bank_page_is_deleted\": false,\r\n"
				+ "  \"morbidity_bank_page_created_by\": 103,\r\n"
				+ "  \"morbidity_bank_page_created_on\": \"2022-08-20T10:32:00.000Z\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.postMorbidityBankPage);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void getMorbidityBankPageByMorbidityBankId() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.pathParam("morbidity_bank_page_id", "184")
						.log().all()
						.get(SuperAdminEndPoints.MorbidityBankPageByMorbidityBankId);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("morbidity_bank_page_id"), true 
				/*Actual Value*/, "Response body contains morbidity_bank_page_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void updateMorbidityBankPage() {
			
			String jsonBody ="{\r\n"
					+ "  \"morbidity_bank_id\": 94,\r\n"
					+ "  \"morbidity_bank_page_no\": \"1\",\r\n"
					+ "  \"morbidity_bank_page\": \"kamran section\",\r\n"
					+ "  \"morbidity_bank_page_is_active\": true,\r\n"
					+ "  \"morbidity_bank_page_sequence\": 1,\r\n"
					+ "  \"morbidity_bank_page_is_deleted\": false,\r\n"
					+ "  \"morbidity_bank_page_created_by\": 117,\r\n"
					+ "  \"morbidity_bank_page_created_on\": \"2022-08-11T12:37:02\",\r\n"
					+ "  \"morbidity_bank_page_id\": 185,\r\n"
					+ "  \"morbidity_bank_page_updated_by\": 103,\r\n"
					+ "  \"morbidity_bank_page_updated_on\": \"2022-08-20T10:26:14.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.postMorbidityBankPage);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
	}
	//@Test(priority=4)
	public static void deleteMorbidityBankPageByMorbidityBank() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_page_id", "184")
					        .log().all()
							.delete(SuperAdminEndPoints.MorbidityBankPageByMorbidityBankId);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
	}

}
