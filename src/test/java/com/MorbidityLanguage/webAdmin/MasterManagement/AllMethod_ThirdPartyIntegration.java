package com.MorbidityLanguage.webAdmin.MasterManagement;

import static io.restassured.RestAssured.given;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethod_ThirdPartyIntegration {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_ThirdPartyIntegration() {
		
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
		
		String jsonBody ="{\r\n"
				+ "  \"name\": \"IntegrationTest"+randomNumber+"\",\r\n"
				+ "  \"url\": \"https://api-id-dev-in-shv3.georgeinstitute.org\",\r\n"
				+ "  \"username\": \"Md.Kamran\",\r\n"
				+ "  \"password\": \"Kamran123\",\r\n"
				+ "  \"keycode\": \"R00"+randomNumber+"\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-22T11:54:28.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ThirdPartyIntegration);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");	
		
	}
	@Test(priority=2)
	public static void GET_ThirdPartyIntegration() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				
				//.queryParam("project_id", "152")
						.log().all()
						.get(SuperAdminEndPoints.ThirdPartyIntegration);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("third_party_integration_detail_id"), true 
				/*Actual Value*/, "Response body contains third_party_integration_detail_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_ThirdPartyIntegration() {
			
			String jsonBody ="{\r\n"
					+ "  \"third_party_integration_detail_id\": 3,\r\n"
					+ "  \"name\": \"IntegrationTest\",\r\n"
					+ "  \"url\": \"https://api-id-dev-in-shv3.georgeinstitute.org\",\r\n"
					+ "  \"username\": \"Md Kamran\",\r\n"
					+ "  \"password\": \"test123\",\r\n"
					+ "  \"keycode\": \"R005\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-22T11:54:28\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-22T11:58:37.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.ThirdPartyIntegration);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_third_party_integration_detail table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_ThirdPartyIntegration() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("project_id", "67")
					        .log().all()
							.delete(SuperAdminEndPoints.ThirdPartyIntegration);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}



}
