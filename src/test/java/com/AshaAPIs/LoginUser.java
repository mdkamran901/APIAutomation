package com.AshaAPIs;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.EndPoints.Asha_Endpoints;
import com.TokenAuthentication.GenerateTokenAshaUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginUser {

	static GenerateTokenAshaUser tg = new GenerateTokenAshaUser();
	static String accessToken = tg.getAccessToken();

	@Test()
	public static void loginuserashsrole() {
		String jsonBody = "{\r\n"
				+ "        \"display\": \"QA Asha\",\r\n"
				+ "        \"userId\": 52,\r\n"
				+ "        \"id\": \"6d792a8b-6434-434f-ac03-5d1491dafdb4\",\r\n"
				+ "        \"email\": {\r\n"
				+ "            \"uuid\": \"a9f01b98-72dd-48d7-88e3-98082d272b33\",\r\n"
				+ "            \"value\": \"sasa@sasa.sasa\"\r\n"
				+ "        },\r\n"
				+ "        \"dateRegistered\": {\r\n"
				+ "            \"uuid\": \"d4fc017a-8c09-440d-9185-49d442a037c7\",\r\n"
				+ "            \"value\": \"2021-08-09T09:07:23.816Z\"\r\n"
				+ "        },\r\n"
				+ "        \"certifications\": [],\r\n"
				+ "        \"location\": {},\r\n"
				+ "        \"nameId\": \"9e8f2d4d-da84-48ef-bad3-42cceaa78d36\",\r\n"
				+ "        \"firstName\": \"QA\",\r\n"
				+ "        \"lastName\": \"Asha\",\r\n"
				+ "        \"personId\": \"f35ed5b9-aae9-4624-b7e4-c2fbe933d6f3\",\r\n"
				+ "        \"username\": \"QA.Asha\",\r\n"
				+ "        \"status\": \"Active\",\r\n"
				+ "        \"roles\": [\r\n"
				+ "            \"ASHA\",\r\n"
				+ "            \"Project Manager\"\r\n"
				+ "        ]\r\n"
				+ "    }";

		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON).body(jsonBody)
						.log().all().post(Asha_Endpoints.users);

		response.prettyPrint();
		System.out.println("status code is" + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getBody().path("statusCode"), "U0001");
		Assert.assertEquals(response.getBody().path("statusValue"), "Operation Successfully");

	}
}
