package com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectPersonAttributeTypeBulkPost {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void projectPersonAttributeTypeBulkPost() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"person_attribute_type_id\": 64,\r\n"
				+ "    \"project_id\": 162,\r\n"
				+ "    \"person_attribute_type_question_id\": 32,\r\n"
				+ "    \"sequence\": 2,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T11:54:07.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"person_attribute_type_id\": 90,\r\n"
				+ "    \"project_id\": 162,\r\n"
				+ "    \"person_attribute_type_question_id\": 57,\r\n"
				+ "    \"sequence\": 2,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T11:54:07.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"person_attribute_type_id\": 71,\r\n"
				+ "    \"project_id\": 162,\r\n"
				+ "    \"person_attribute_type_question_id\": 39,\r\n"
				+ "    \"sequence\": 2,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T11:54:07.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"person_attribute_type_id\": 83,\r\n"
				+ "    \"project_id\": 162,\r\n"
				+ "    \"person_attribute_type_question_id\": 50,\r\n"
				+ "    \"sequence\": 2,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T11:54:07.000Z\"\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ProjectPersonAttributeTypeBulkPost);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}
