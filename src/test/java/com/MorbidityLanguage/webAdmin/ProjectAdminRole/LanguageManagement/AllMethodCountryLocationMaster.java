package com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethodCountryLocationMaster {
	
	static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
	static String accessToken = tg.getAccessToken();
	
	@Test(priority=1)
	public static void POST_CountryLocationMaster() {
		 String randomString = RandomStringUtils.randomAlphabetic(5);
		    System.out.println(randomString);
		
		Random rand = new Random();          // Generate random integers in range 0 to 999        
		int rand_int1 = rand.nextInt(1000);
		rand_int1 = rand.nextInt(1000);
		
		String jsonBody ="{\r\n"
				+ "  \"mst_location_level1\": \"Test"+rand_int1+"\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-04T06:20:56.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(ProjectAdminEndPoints.AllMethodCountryMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in MorbidityBank table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_CountryLocationMaster() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				//.queryParam("location_level", "India")
						.log().all()
						.get(ProjectAdminEndPoints.AllMethodCountryMaster);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("mst_location_level1_id"), true 
				/*Actual Value*/, "Response body contains mst_location_level1_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
		// extentTest.log(LogStatus.PASS, "Verify that get report_dashboard API");
	}
	@Test(priority=3)
	public static void UPDATE_CountryLocationMaster() {
		Random rand = new Random();          // Generate random integers in range 0 to 999        
		int rand_int1 = rand.nextInt(1000);
		rand_int1 = rand.nextInt(1000);
			
			String jsonBody ="{\r\n"
					+ "  \"mst_location_level1_id\": 27,\r\n"
					+ "  \"mst_location_level1\": \"Test"+rand_int1+"\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-04T06:20:56\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-16T09:04:12.000Z\"\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(ProjectAdminEndPoints.AllMethodCountryMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_location_level1 table successfully");
	}
	//@Test(priority=4)
	public static void DELETE_CountryLocationMaster() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("location_level", "28")
					        .log().all()
							.delete(ProjectAdminEndPoints.AllMethodCountryMaster);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}


}
