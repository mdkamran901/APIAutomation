package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodMorbidityBankQuestion {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void postMorbidityBankQuestion() {
		
		
		String jsonBody = "{\r\n"
				+ "  \"morbidity_bank_question_type_id\": 10,\r\n"
				+ "  \"morbidity_bank_id\": 94,\r\n"
				+ "  \"morbidity_bank_page_id\": 200,\r\n"
				+ "  \"morbidity_bank_question_no\": \"2\",\r\n"
				+ "  \"morbidity_bank_question\": \"is your blood positive\",\r\n"
				+ "  \"morbidity_bank_question_instructions\": \"test\",\r\n"
				+ "  \"morbidity_bank_question_is_active\": true,\r\n"
				+ "  \"morbidity_bank_question_sequence\": 1,\r\n"
				+ "  \"morbidity_bank_question_created_by\": 103,\r\n"
				+ "  \"morbidity_bank_question_created_on\": \"2022-08-20T11:03:21.000Z\",\r\n"
				+ "  \"morbidity_bank_question_is_mandatory\": 1,\r\n"
				+ "  \"morbidity_bank_question_flag\": 0,\r\n"
				+ "  \"morbidity_bank_question_mask_validation\": 13,\r\n"
				+ "  \"morbidity_bank_question_is_child\": 0,\r\n"
				+ "  \"morbidity_bank_question_is_deleted\": 0,\r\n"
				+ "  \"ruleset_variable_id\": 127,\r\n"
				+ "  \"defaultvalue\": 1,\r\n"
				+ "  \"orientation\": 1,\r\n"
				+ "  \"readonlyvalue\": 1,\r\n"
				+ "  \"hiddenvalue\": 1,\r\n"
				+ "  \"export_key_name\": \"12\",\r\n"
				+ "  \"question_group_type\": \"1\",\r\n"
				+ "  \"question_hint\": \"KamranTesting\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.MorbidityBankQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void getMorbidityBankQuestion() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("morbidity_bank_id", "94")
						.log().all()
						.get(SuperAdminEndPoints.MorbidityBankQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("morbidity_bank_question_id"), true 
				/*Actual Value*/, "Response body contains morbidity_bank_question_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void updateMorbidityBankQuestion() {
			
			String jsonBody = "{\"morbidity_bank_question_id\":605,\"morbidity_bank_question_type_id\":1,\"morbidity_bank_id\":93,\"morbidity_bank_page_id\":178,\"morbidity_bank_question_no\":\"123\",\"morbidity_bank_question\":\"My test is Negative\",\"morbidity_bank_question_instructions\":\"Testing\",\"morbidity_bank_question_sequence\":1,\"morbidity_bank_question_created_by\":103,\"morbidity_bank_question_created_on\":\"2022-07-16T08:35:43\",\"morbidity_bank_question_is_mandatory\":1,\"morbidity_bank_question_flag\":0,\"morbidity_bank_question_mask_validation\":3,\"morbidity_bank_question_is_child\":0,\"morbidity_bank_question_is_deleted\":false,\"morbidity_bank_question_updated_by\":103,\"morbidity_bank_question_updated_on\":\"2022-07-16T08:47:47.000Z\",\"morbidity_bank_question_is_active\":true,\"ruleset_variable_id\":9,\"defaultvalue\":2,\"orientation\":2,\"readonlyvalue\":1,\"hiddenvalue\":1,\"export_key_name\":\"123\",\"question_group_type\":1,\"question_hint\":\"Kamran\"}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.MorbidityBankQuestion);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_morbidity_bank_question table successfully");
	}
	//@Test(priority=4)
	public static void deleteMorbidityBankQuestion() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "93")
					        .log().all()
							.delete(SuperAdminEndPoints.MorbidityBankQuestion);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}


}
