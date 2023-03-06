package com.MorbidityLanguage.webAdmin.MasterManagement;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllMethod_HealthFacilities {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test(priority=1)
	public static void POST_HealthFacilities () {
		String randomNumber = RandomStringUtils.randomNumeric(2);
	    System.out.println(randomNumber);
	    
		String jsonBody ="{\r\n"
				+ "  \"health_facility\": \"Testing.testing"+randomNumber+"\",\r\n"
				+ "  \"health_facility_type_id\": 11,\r\n"
				+ "  \"project_id\": 152,\r\n"
				+ "  \"location_level1_id\": 10,\r\n"
				+ "  \"location_level2_id\": 26,\r\n"
				+ "  \"location_level3_id\": 46,\r\n"
				+ "  \"location_level4_id\": 40,\r\n"
				+ "  \"health_facility_doctor_id\": \"328,314\",\r\n"
				+ "  \"health_facility_asha_id\": \"390,385,376,313\",\r\n"
				+ "  \"is_active\": true,\r\n"
				+ "  \"created_by\": 103,\r\n"
				+ "  \"created_on\": \"2022-08-22T07:21:00.000Z\",\r\n"
				+ "  \"is_deleted\": false\r\n"
				+ "}";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.HealthFacilities);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}
	@Test(priority=2)
	public static void GET_HealthFacilities() {
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
						.log().all()
						.get(SuperAdminEndPoints.HealthFacilities);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		//System.out.println(response.getBody().asString());
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("health_facility_id"), true 
				/*Actual Value*/, "Response body contains health_facility_id");
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.getHeaders());
	}
	@Test(priority=3)
	public static void UPDATE_HealthFacilities() {
			
			String jsonBody ="{\r\n"
					+ "  \"health_facility_id\": 26,\r\n"
					+ "  \"health_facility\": \"Testing.testing\",\r\n"
					+ "  \"health_facility_type_id\": 11,\r\n"
					+ "  \"project_id\": 152,\r\n"
					+ "  \"location_level1_id\": 10,\r\n"
					+ "  \"location_level2_id\": 26,\r\n"
					+ "  \"location_level3_id\": 46,\r\n"
					+ "  \"location_level4_id\": 40,\r\n"
					+ "  \"health_facility_doctor_id\": \"328,314\",\r\n"
					+ "  \"health_facility_asha_id\": \"390,385,376,313\",\r\n"
					+ "  \"is_active\": true,\r\n"
					+ "  \"created_by\": 103,\r\n"
					+ "  \"created_on\": \"2022-08-22T07:21:00\",\r\n"
					+ "  \"is_deleted\": false,\r\n"
					+ "  \"updated_by\": 103,\r\n"
					+ "  \"updated_on\": \"2022-08-22T07:32:25.000Z\",\r\n"
					+ "  \"is_dynamic\": true\r\n"
					+ "}";
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.body(jsonBody)
					        .log().all()
							.put(SuperAdminEndPoints.HealthFacilities);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
			Assert.assertEquals(response.getBody().path("description"),"Record is updated in mw_mst_health_facilities table successfully");
	}
//@Test(priority=4)
	public static void DELETE_HealthFacilities() {
			
			Response response =

					given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
					.pathParam("morbidity_bank_id", "97")
					        .log().all()
							.delete(SuperAdminEndPoints.HealthFacilities);

			response.prettyPrint();
			System.out.println("status code is \n" + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertEquals(response.getBody().path("statusCode"), "D0001");
			Assert.assertEquals(response.getBody().path("statusValue"), "Record deleted successfully");
			Assert.assertEquals(response.getBody().path("description"), "Record deleted successfully");
	}


}
