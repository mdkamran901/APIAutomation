package com.MorbidityLanguage.webAdmin.MasterManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethod_ThirdPartyEndPoint {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_ThirdPartyEndPoint() {
		
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
		
		String jsonBody ="{\r\n"
				+ "  \"third_party_integration_detail_id\": 3,\r\n"
				+ "  \"endpoint_name\": \"KamranTest"+randomNumber+"\",\r\n"
				+ "  \"action\": \"Testing123\",\r\n"
				+ "  \"keycode\": \"1"+randomNumber+"\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-22T13:48:33.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.ThirdPartyEndPoint);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");	
		
	}
	@Test(priority=2)
	public static void GET_ThirdPartyEndPoint() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				
				//.queryParam("project_id", "152")
						.log().all()
						.get(SuperAdminEndPoints.ThirdPartyEndPoint);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("third_party_integration_end_point_id"), true 
				/*Actual Value*/, "Response body contains third_party_integration_end_point_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_ThirdPartyEndPoint() {
			
			String jsonBody ="{\r\n"
					+ "  \"third_party_integration_end_point_id\": 3,\r\n"
					+ "  \"third_party_integration_detail_id\": 3,\r\n"
					+ "  \"endpoint_name\": \"Testing123\",\r\n"
					+ "  \"action\": \"Testing123\",\r\n"
					+ "  \"keycode\": \"123\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-22T13:17:41\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-22T13:22:48.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.ThirdPartyEndPoint);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_third_party_integration_end_point table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_ThirdPartyEndPoint() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("project_id", "67")
					        .log().all()
							.delete(SuperAdminEndPoints.ThirdPartyEndPoint);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}




}
