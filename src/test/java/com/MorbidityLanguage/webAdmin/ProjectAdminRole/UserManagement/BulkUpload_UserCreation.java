package com.MorbidityLanguage.webAdmin.ProjectAdminRole.UserManagement;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.ProjectAdminEndPoints;
import com.TokenAuthentication.GenerateTokenProjectAdmin;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BulkUpload_UserCreation {
	
	static GenerateTokenProjectAdmin tg = new GenerateTokenProjectAdmin();
	static String accessToken = tg.getAccessToken();
	
	@Test
	public static void post_UserBulkUpload() {
		String jsonBody ="[\r\n"
				+ "  {\r\n"
				+ "    \"email\": {\r\n"
				+ "      \"value\": \"kamram@gmail.com\"\r\n"
				+ "    },\r\n"
				+ "    \"dateRegistered\": {\r\n"
				+ "      \"value\": \"2022-07-28T14:18:58.427Z\"\r\n"
				+ "    },\r\n"
				+ "    \"phoneNumber\": {\r\n"
				+ "      \"value\": \"3.24634E+11\"\r\n"
				+ "    },\r\n"
				+ "    \"location\": {\r\n"
				+ "      \"block\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"roles\": [\r\n"
				+ "      \"asha\"\r\n"
				+ "    ],\r\n"
				+ "    \"registrationNumber\": \"\",\r\n"
				+ "    \"username\": \"kamran\",\r\n"
				+ "    \"firstName\": \"kamram\",\r\n"
				+ "    \"lastName\": \"alam\",\r\n"
				+ "    \"screeningRegion\": \"\",\r\n"
				+ "    \"puskesmasDoctor\": \"\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"email\": {\r\n"
				+ "      \"value\": \"alam@gmail.com\"\r\n"
				+ "    },\r\n"
				+ "    \"dateRegistered\": {\r\n"
				+ "      \"value\": \"2022-07-28T14:18:58.427Z\"\r\n"
				+ "    },\r\n"
				+ "    \"phoneNumber\": {\r\n"
				+ "      \"value\": \"34566666667\"\r\n"
				+ "    },\r\n"
				+ "    \"location\": {\r\n"
				+ "      \"block\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"roles\": [\r\n"
				+ "      \"doctor\"\r\n"
				+ "    ],\r\n"
				+ "    \"registrationNumber\": \"\",\r\n"
				+ "    \"username\": \"alamdg\",\r\n"
				+ "    \"firstName\": \"sskfoi\",\r\n"
				+ "    \"lastName\": \"singh\",\r\n"
				+ "    \"screeningRegion\": \"\",\r\n"
				+ "    \"puskesmasDoctor\": \"\"\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(ProjectAdminEndPoints.BulkUploadUserCreation);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		
		
	}

}
