package com.MorbidityLanguage.webAdmin.Ruleset;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkDELETE_RulesetMapping {

	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void bulkDELETE_RulesetMapping() {
		
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"ruleset_mapping_id\": 105\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"ruleset_mapping_id\": 106\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"ruleset_mapping_id\": 107\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.delete(SuperAdminEndPoints.BulkDELETE_RulesetMapping);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}
}
