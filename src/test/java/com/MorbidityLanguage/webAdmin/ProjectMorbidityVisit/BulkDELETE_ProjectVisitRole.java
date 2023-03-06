package com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkDELETE_ProjectVisitRole {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void bulkDELETE_ProjectVisitRole() {
		
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_id\": 45\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_id\": 46\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_id\": 47\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.delete(SuperAdminEndPoints.BulkDELETE_ProjectVisitRole);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}


}
