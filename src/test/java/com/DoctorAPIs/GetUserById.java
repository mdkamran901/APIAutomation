package com.DoctorAPIs;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ConstantData.DoctorConstantData;
import com.EndPoints.DoctorEndPoints;
import com.TokenAuthentication.GenerateTokenDoctorUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserById {
	
	static GenerateTokenDoctorUser tg = new GenerateTokenDoctorUser();
	static String accessToken = tg.getAccessToken();
	
	@Test
	public static void getUserById() {
		DoctorConstantData cd = new DoctorConstantData();
		Response response =

				given().header("Authorization", "Bearer" + accessToken).contentType(ContentType.JSON)
						.pathParam("uuid", cd.getUserid())
						.log().all()
						.get(DoctorEndPoints.userById);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("display"), true 
				/*Actual Value*/, "Response body contains display");
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}

}
