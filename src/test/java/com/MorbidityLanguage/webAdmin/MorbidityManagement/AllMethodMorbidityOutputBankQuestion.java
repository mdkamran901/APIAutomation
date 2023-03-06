package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodMorbidityOutputBankQuestion {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void post_MethodMorbidityOutPut() {
		
		String jsonBody ="{\r\n"
				+ "  \"morbidity_output_bank_id\": 24,\r\n"
				+ "  \"morbidity_output_bank_section_id\": 41,\r\n"
				+ "  \"morbidity_output_bank_question_no\": \"123\",\r\n"
				+ "  \"morbidity_output_bank_question\": \"Kamran testing\",\r\n"
				+ "  \"morbidity_output_bank_question_instructions\": \"kamranTesting\",\r\n"
				+ "  \"morbidity_output_bank_question_type_id\": \"9\",\r\n"
				+ "  \"sequence\": 1,\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"morbidity_bank_question_created_by\": 103,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"morbidity_bank_question_created_on\": \"2022-07-25T07:25:09.000Z\",\r\n"
				+ "  \"morbidity_bank_question_is_mandatory\": 1,\r\n"
				+ "  \"morbidity_bank_question_flag\": 0,\r\n"
				+ "  \"morbidity_bank_question_mask_validation\": null,\r\n"
				+ "  \"ruleset_variable_id\": 2,\r\n"
				+ "  \"defaultvalue\": 1,\r\n"
				+ "  \"orientation\": 2,\r\n"
				+ "  \"readonlyvalue\": 1,\r\n"
				+ "  \"export_key_name\": \"Testing\",\r\n"
				+ "  \"question_group_type\": \"1\",\r\n"
				+ "  \"question_hint\": \"Blood Testing\"\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.allMethodMorbidityOutputBankQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void get_MethodMorbidityOutPut() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("morbidity_output_bank_question_id", "24")
				.queryParam("morbidityoutputsectioneId", "41")
						.log().all()
						.get(SuperAdminEndPoints.allMethodMorbidityOutputBankQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("morbidity_output_bank_question_id"), true 
				/*Actual Value*/, "Response body contains morbidity_output_bank_question_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void update_MethodMorbidityOutPuty() {
			
			String jsonBody ="{\r\n"
					+ "  \"morbidity_output_bank_question_id\": 72,\r\n"
					+ "  \"morbidity_output_bank_id\": 24,\r\n"
					+ "  \"morbidity_output_bank_section_id\": 41,\r\n"
					+ "  \"morbidity_output_bank_question_no\": \"123\",\r\n"
					+ "  \"morbidity_output_bank_question\": \"Kamran testing\",\r\n"
					+ "  \"morbidity_output_bank_question_instructions\": \"kamranTesting\",\r\n"
					+ "  \"morbidity_output_bank_question_type_id\": \"9\",\r\n"
					+ "  \"sequence\": 1,\r\n"
					+ "  \"morbidity_bank_question_flag\": 0,\r\n"
					+ "  \"morbidity_bank_question_is_mandatory\": \"1\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-07-25T17:25:10\",\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-07-25T07:29:57.000Z\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"ruleset_variable_id\": 2,\r\n"
					+ "  \"defaultvalue\": 1,\r\n"
					+ "  \"orientation\": 2,\r\n"
					+ "  \"readonlyvalue\": 1,\r\n"
					+ "  \"export_key_name\": \"Testing\",\r\n"
					+ "  \"question_group_type\": 1,\r\n"
					+ "  \"question_hint\": \"Blood Testing\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.allMethodMorbidityOutputBankQuestion);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_morbidity_output_bank_question table successfully");
	}
//@Test(priority=4)
	public static void delete_MethodMorbidityOutPut() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.allMethodMorbidityOutputBankQuestion);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}

}
