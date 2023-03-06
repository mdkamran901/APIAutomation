package com.AshaAPIs;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.Asha_Endpoints;
import com.TokenAuthentication.GenerateTokenAshaUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.UUID;
import java.util.Random;

public class PostPatientEnrollmentPatientData {

	static GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
	static String accessToken = tg.getAccessToken();

	@Test
	public static void postPatientEnrollmentPatientData() {
		
		UUID uuid1 = UUID.randomUUID();
		String uuidAsString1= uuid1.toString();
		System.out.println(uuidAsString1);
		
		Random rand = new Random();          // Generate random integers in range 0 to 999        
		int rand_int1 = rand.nextInt(1000);
		rand_int1 = rand.nextInt(1000);
		//randstr = rand_int1.toString();
		
		String jsonBody = "{\r\n"
				+ "    \"uuid\": \"uuidAsString1\",\r\n"
				+ "    \"firstName\": \"Asha"+rand_int1+"\",\r\n"
				+ "    \"lastName\": \"TEST"+rand_int1+"\",\r\n"
				+ "    \"gender\": \"F\",\r\n"
				+ "    \"person_id\": 1,\r\n"
				+ "    \"isEdited\": 1,\r\n"
				+ "    \"isUploaded\": 0,\r\n"
				+ "    \"personAttributes\": [\r\n"
				+ "        {\r\n"
				+ "            \"value\": \"96919229655\",\r\n"
				+ "            \"AttributeType\": \"303254c3-4d5f-4922-8991-df7e8738ab2f\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"value\": \"1234123412341234\",\r\n"
				+ "            \"AttributeType\": \"74a536db-5d3d-4ed1-8393-4cba11090867\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"address\": {\r\n"
				+ "        \"country\": \"10\",\r\n"
				+ "        \"state\": \"47\",\r\n"
				+ "        \"district\": \"49\",\r\n"
				+ "        \"block\": \"49\",\r\n"
				+ "        \"village\": \"vill\",\r\n"
				+ "        \"streetAddress\": null,\r\n"
				+ "        \"zipCode\": \"963258\"\r\n"
				+ "    },\r\n"
				+ "    \"birthDate\": \"1990-01-28\",\r\n"
				+ "    \"project_id\": 152\r\n"
				+ "}";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post(Asha_Endpoints.postPatientEnrollmentByData);

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "person_id");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");
		String bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("person_id"), true 
				/*Actual Value*/, "Response body contains person_id");

	}

}
