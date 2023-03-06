package com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodDistrictLocationMaster {
	static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
	static String accessToken = tg.getAccessToken();
	
	
	@Test(priority=1)
	public static void POST_DistrictLocationMaster() {
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
		
		String jsonBody ="{\r\n"
				+ "  \"mst_location_level1_id\": 10,\r\n"
				+ "  \"mst_location_level2_id\": 26,\r\n"
				+ "  \"mst_location_level3\": \"Jhajha"+randomNumber+"\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-06T10:52:11.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(ProjectAdminEndPoints.AllMethodDistrictLocationMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_DistrictLocationMaster() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("location_level1Id", "10")
				.queryParam("language_id", "0")
				.queryParam("location_level2Id", "26")
						.log().all()
						.get(ProjectAdminEndPoints.AllMethodDistrictLocationMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("mst_location_level3_id"), true 
				/*Actual Value*/, "Response body contains mst_location_level3_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_DistrictLocationMaster() {
			
			String jsonBody ="{\r\n"
					+ "  \"mst_location_level1_id\": 10,\r\n"
					+ "  \"mst_location_level2_id\": 26,\r\n"
					+ "  \"mst_location_level3_id\": 46,\r\n"
					+ "  \"mst_location_level1\": 2,\r\n"
					+ "  \"mst_location_level2\": 43,\r\n"
					+ "  \"mst_location_level3\": \"Jhajha\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-06T10:52:11\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-06T10:54:10.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(ProjectAdminEndPoints.AllMethodDistrictLocationMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_location_level3 table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_DistrictLocationMaster() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("location_level", "67")
					        .log().all()
							.delete(ProjectAdminEndPoints.AllMethodDistrictLocationMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}


}
