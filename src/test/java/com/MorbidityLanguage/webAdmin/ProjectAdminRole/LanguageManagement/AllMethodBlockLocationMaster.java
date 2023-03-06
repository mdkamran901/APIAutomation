package com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement;

import static io.restassured.RestAssured.given;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodBlockLocationMaster {

		static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
		static String accessToken = tg.getAccessToken();
		
		
	@Test(priority=1)
		public static void POST_BlockLocationMaster() {
			String randomNumber = RandomStringUtils.randomNumeric(2);
		    System.out.println(randomNumber);
			
			String jsonBody ="{\r\n"
				+ "  \"mst_location_level1_id\": 10,\r\n"
				+ "  \"mst_location_level2_id\": 26,\r\n"
				+ "  \"mst_location_level3_id\": 46,\r\n"
				+ "  \"mst_location_level4\": \"jhajha Block"+randomNumber+"\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-06T10:59:17.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(ProjectAdminEndPoints.AllMethodBlockLocationMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_BlockLocationMaster() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.queryParam("location_level1Id", "10")
				.queryParam("location_level2Id", "26")
				.queryParam("location_level3Id", "46")
				.queryParam("location_level4", "jhajha Block")
						.log().all()
						.get(ProjectAdminEndPoints.AllMethodBlockLocationMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("mst_location_level4_id"), true 
				/*Actual Value*/, "Response body contains mst_location_level4_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_BlockLocationMaster() {
			
			String jsonBody ="{\r\n"
					+ "  \"mst_location_level4_id\": 40,\r\n"
					+ "  \"mst_location_level1_id\": 10,\r\n"
					+ "  \"mst_location_level2_id\": 26,\r\n"
					+ "  \"mst_location_level3_id\": 46,\r\n"
					+ "  \"mst_location_level1\": 2,\r\n"
					+ "  \"mst_location_level2\": 26,\r\n"
					+ "  \"mst_location_level3\": 46,\r\n"
					+ "  \"mst_location_level4\": \"jhajha Block\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-06T10:59:17\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-06T11:08:10.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(ProjectAdminEndPoints.AllMethodBlockLocationMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_location_level4 table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_BlockLocationMaster() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("location_level", "67")
					        .log().all()
							.delete(ProjectAdminEndPoints.AllMethodBlockLocationMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
		}


}
