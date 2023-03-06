package com.MorbidityLanguage.webAdmin.ProjectManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectResourceBulkPost {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void projectResourceBulkPost() {
		
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"resource_id\": 11,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"resource_name\": \"project\",\r\n"
				+ "    \"resource_type_id\": 6,\r\n"
				+ "    \"resource_link\": null,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T14:12:01.000Z\",\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"resource_id\": 8,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"resource_name\": \"Smoking\",\r\n"
				+ "    \"resource_type_id\": 2,\r\n"
				+ "    \"resource_link\": \"assets/video/smoking.3gp\",\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T14:12:01.000Z\",\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"resource_id\": 16,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"resource_name\": \"jpgg\",\r\n"
				+ "    \"resource_type_id\": 6,\r\n"
				+ "    \"resource_link\": null,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T14:12:01.000Z\",\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"resource_id\": 15,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"resource_name\": \"zip\",\r\n"
				+ "    \"resource_type_id\": 6,\r\n"
				+ "    \"resource_link\": null,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T14:12:01.000Z\",\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ProjectResourceBulkPost);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}


}
