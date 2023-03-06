package com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkPost_ProjectMorbidityOutputQuestion {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void bulkPost_ProjectMorbidityOutputQuestion() {
		String jsonBody ="{\r\n"
				+ "  \"mw_project_morbidity_output_question\": [\r\n"
				+ "    {\r\n"
				+ "      \"project_morbidity_output_id\": 33,\r\n"
				+ "      \"project_morbidity_output_section_id\": 49,\r\n"
				+ "      \"morbidity_output_bank_id\": 17,\r\n"
				+ "      \"morbidity_output_section_id\": 27,\r\n"
				+ "      \"morbidity_output_bank_question_id\": 63,\r\n"
				+ "      \"project_morbidity_output_question_no\": \"1.a\",\r\n"
				+ "      \"project_morbidity_output_question\": \"fever\",\r\n"
				+ "      \"project_morbidity_output_question_type_id\": 14,\r\n"
				+ "      \"ruleset_variable_id\": null,\r\n"
				+ "      \"sequence\": 1,\r\n"
				+ "      \"is_active\": true,\r\n"
				+ "      \"created_by\": 103,\r\n"
				+ "      \"created_on\": \"2022-04-27T15:15:56\",\r\n"
				+ "      \"updated_by\": null,\r\n"
				+ "      \"updated_on\": null,\r\n"
				+ "      \"is_deleted\": false\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.BulkPost_ProjectMorbidityOutputQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}

