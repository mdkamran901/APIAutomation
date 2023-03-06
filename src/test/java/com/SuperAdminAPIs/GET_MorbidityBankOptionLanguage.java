package com.SuperAdminAPIs;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.GenerateTokenWebUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GET_MorbidityBankOptionLanguage {
	
	static GenerateTokenWebUser tg = new GenerateTokenWebUser();
	static String accessToken = tg.getAccessToken();
	
	@Test
	public static void GET_morbidityBankQuestionLanguageId() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("morbidity_bank_id", "94")
				.queryParam("language_id", "10")
						.log().all()
						.get(SuperAdminEndPoints.GET_MorbidityBankOptionLanguage);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("question_option_id"), true 
				/*Actual Value*/, "Response body contains question_option_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
