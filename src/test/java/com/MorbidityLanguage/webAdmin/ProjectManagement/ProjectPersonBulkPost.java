package com.MorbidityLanguage.webAdmin.ProjectManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectPersonBulkPost {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void bulkPost_ProjectMorbidityOutputQuestion() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T13:56:51.000Z\",\r\n"
				+ "    \"person_id\": 758,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"sequence\": 2\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T13:56:51.000Z\",\r\n"
				+ "    \"person_id\": 757,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"sequence\": 2\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T13:56:51.000Z\",\r\n"
				+ "    \"person_id\": 695,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"sequence\": 2\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T13:56:51.000Z\",\r\n"
				+ "    \"person_id\": 693,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"sequence\": 2\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T13:56:51.000Z\",\r\n"
				+ "    \"person_id\": 692,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"sequence\": 2\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T13:56:51.000Z\",\r\n"
				+ "    \"person_id\": 681,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"sequence\": 2\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-01T13:56:51.000Z\",\r\n"
				+ "    \"person_id\": 467,\r\n"
				+ "    \"project_id\": 145,\r\n"
				+ "    \"sequence\": 2\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ProjectPersonBulkPost);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}
