package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkPost_ProjectReferralQuestion {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void ProjectReferralQuestionBulkPost() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 516,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 516,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 518,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 518,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 519,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 519,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 520,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 520,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 521,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 521,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 522,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 522,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 523,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 523,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 524,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 524,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_id\": 147,\r\n"
				+ "    \"project_question_type_id\": 525,\r\n"
				+ "    \"project_morbidity_id\": 61,\r\n"
				+ "    \"project_morbidity_section_id\": 111,\r\n"
				+ "    \"project_morbidity_question_id\": 525,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-25T08:56:24.000Z\",\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ProjectReferralQuestionBulkPost);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}
