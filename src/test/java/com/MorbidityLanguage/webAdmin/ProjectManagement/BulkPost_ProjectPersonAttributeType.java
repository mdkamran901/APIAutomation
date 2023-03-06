package com.MorbidityLanguage.webAdmin.ProjectManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkPost_ProjectPersonAttributeType {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void BulkPost_projectPersonAttributeType() {
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"person_attribute_type_id\": 91"+randomNumber+",\r\n"
				+ "    \"project_id\": 152,\r\n"
				+ "    \"person_attribute_type_question_id\": 49,\r\n"
				+ "    \"sequence\": 2,\r\n"
				+ "    \"created_by\": 103,\r\n"
				+ "    \"created_on\": \"2022-08-20T11:32:27.000Z\"\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.BulkPost_ProjectPersonAttributeType);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}


}
