package com.AshaAPIs;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.EndPoints.Asha_Endpoints;
import com.TokenAuthentication.GenerateTokenAshaUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetDynamicProjectMorbidityOutputEvaluation {

	static GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void getdynamicProjectMorbidityOutputEvaluation() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).log().all()
						.get(Asha_Endpoints.getDynamicProjectMorbidityOutputEvaluation);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		// System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("projectMorbidityOutputEvaluationList"), true
		/* Actual Value */, "Response body contains projectMorbidityOutputEvaluationList");

		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
