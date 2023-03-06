package com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkPOST_ProjectVisitRole {
	

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void bulkPOST_ProjectVisitRole() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"visit_role_id\": 25,\r\n"
				+ "    \"project_id\": 143,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-27T12:29:57.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"visit_role_id\": 22,\r\n"
				+ "    \"project_id\": 143,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-27T12:29:57.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"visit_role_id\": 24,\r\n"
				+ "    \"project_id\": 143,\r\n"
				+ "    \"is_active\": true,\r\n"
				+ "    \"is_deleted\": false,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-07-27T12:29:57.000Z\"\r\n"
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
