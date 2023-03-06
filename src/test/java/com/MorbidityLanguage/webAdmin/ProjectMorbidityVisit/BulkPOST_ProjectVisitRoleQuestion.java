package com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkPOST_ProjectVisitRoleQuestion {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void bulkPOST_ProjectVisitRoleQuestion() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_id\": 30,\r\n"
				+ "    \"project_id\": 132,\r\n"
				+ "    \"project_morbidity_id\": 64,\r\n"
				+ "    \"project_morbidity_section_id\": 121,\r\n"
				+ "    \"project_morbidity_question_id\": 617,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-27T13:21:25.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_id\": 30,\r\n"
				+ "    \"project_id\": 132,\r\n"
				+ "    \"project_morbidity_id\": 64,\r\n"
				+ "    \"project_morbidity_section_id\": 121,\r\n"
				+ "    \"project_morbidity_question_id\": 615,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-27T13:21:25.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_id\": 30,\r\n"
				+ "    \"project_id\": 132,\r\n"
				+ "    \"project_morbidity_id\": 64,\r\n"
				+ "    \"project_morbidity_section_id\": 121,\r\n"
				+ "    \"project_morbidity_question_id\": 616,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-27T13:21:25.000Z\"\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.BulkPOST_ProjectVisitRole);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}


}
