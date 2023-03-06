package com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkDelete_ProjectMorbidityOutputQuestion {
	
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void bulkDelete_ProjectMorbidityOutputQuestion() {
		String jsonBody ="{\r\n"
				+ "  \"mw_project_morbidity_output_question\": [\r\n"
				+ "    {\r\n"
				+ "      \"project_morbidity_output_question_id\": 159\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"project_morbidity_output_question_id\": 160\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.delete(SuperAdminEndPoints.BulkDelete_ProjectMorbidityOutputQuestion);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}
