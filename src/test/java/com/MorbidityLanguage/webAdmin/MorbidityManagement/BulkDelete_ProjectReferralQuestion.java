package com.MorbidityLanguage.webAdmin.MorbidityManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkDelete_ProjectReferralQuestion {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test
	public static void bulkDelete_ProjectReferralQuestion() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 181\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 182\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 183\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 184\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 185\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 186\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 187\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 188\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"project_visit_role_output_referral_question_id\": 189\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.delete(SuperAdminEndPoints.ProjectReferralQuestionBulkDelete);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}
