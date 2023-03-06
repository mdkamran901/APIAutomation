package com.MorbidityLanguage.webAdmin.ProjectManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkPost_ProjectUser {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void BulkPost_projectUser() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"username\": \"AshaTest23\",\r\n"
				+ "    \"project_id\": 152,\r\n"
				+ "    \"user_id\": 385,\r\n"
				+ "    \"project_user_created_by\": 103,\r\n"
				+ "    \"project_user_created_on\": \"2022-08-20T11:50:05.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"username\": \"doctortest23\",\r\n"
				+ "    \"project_id\": 152,\r\n"
				+ "    \"user_id\": 284,\r\n"
				+ "    \"project_user_created_by\": 103,\r\n"
				+ "    \"project_user_created_on\": \"2022-08-20T11:50:05.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"username\": \"Md.Kamran\",\r\n"
				+ "    \"project_id\": 152,\r\n"
				+ "    \"user_id\": 103,\r\n"
				+ "    \"project_user_created_by\": 103,\r\n"
				+ "    \"project_user_created_on\": \"2022-08-20T11:50:05.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"username\": \"Asha\",\r\n"
				+ "    \"project_id\": 152,\r\n"
				+ "    \"user_id\": 390,\r\n"
				+ "    \"project_user_created_by\": 103,\r\n"
				+ "    \"project_user_created_on\": \"2022-08-20T11:50:05.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"username\": \"kamran\",\r\n"
				+ "    \"project_id\": 152,\r\n"
				+ "    \"user_id\": 376,\r\n"
				+ "    \"project_user_created_by\": 103,\r\n"
				+ "    \"project_user_created_on\": \"2022-08-20T11:50:05.000Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"username\": \"mdkamran\",\r\n"
				+ "    \"project_id\": 152,\r\n"
				+ "    \"user_id\": 375,\r\n"
				+ "    \"project_user_created_by\": 103,\r\n"
				+ "    \"project_user_created_on\": \"2022-08-20T11:50:05.000Z\"\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.BulkPost_ProjectUser);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}
}
