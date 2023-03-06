package com.MorbidityLanguage.webAdmin.UserBulkUpload;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EndPoints.SuperAdminEndPoints;
import com.TokenAuthentication.TokenGenerateWeb;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POST_UserBulkUpload {
	
	static TokenGenerateWeb tg = new TokenGenerateWeb();
	static String accessToken = tg.getAccessToken();

	@Test(invocationCount = 1)
	public static void post_UserBulkUpload() throws IOException {
		
		Random rand = new Random();          // Generate random integers in range 0 to 999        
		int rand_int1 = rand.nextInt(1000);
		rand_int1 = rand.nextInt(1000);
		
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
				+ "    \"username\": \"AshaTest"+rand_int1+"\",\r\n"
				+ "    \"firstName\": \"Md"+rand_int1+"\",\r\n"
				+ "    \"lastName\": \"kamran"+rand_int1+"\",\r\n"
				+ "    \"screeningRegion\": \"\",\r\n"
				+ "    \"puskesmasDoctor\": \"\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"email\": {\r\n"
				+ "      \"value\": \"kamran@gmail.com\"\r\n"
				+ "    },\r\n"
				+ "    \"dateRegistered\": {\r\n"
				+ "      \"value\": \"2022-07-28T14:18:58.427Z\"\r\n"
				+ "    },\r\n"
				+ "    \"phoneNumber\": {\r\n"
				+ "      \"value\": \"9315076225\"\r\n"
				+ "    },\r\n"
				+ "    \"location\": {\r\n"
				+ "      \"block\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"roles\": [\r\n"
				+ "      \"ASHA\"\r\n"
				+ "    ],\r\n"
				+ "    \"registrationNumber\": \"\",\r\n"
				+ "    \"username\": \"Asha."+rand_int1+"\",\r\n"
				+ "    \"firstName\": \"QA1"+rand_int1+"\",\r\n"
				+ "    \"lastName\": \"Test1"+rand_int1+"\",\r\n"
				+ "    \"screeningRegion\": \"\",\r\n"
				+ "    \"puskesmasDoctor\": \"\"\r\n"
				+ "  }\r\n"
				+ "]";
		Response response =

				given().header("Authorization", "Bearer " + accessToken).contentType(ContentType.JSON)
				.body(jsonBody)
				        .log().all()
						.post(SuperAdminEndPoints.POST_UserBulkUpload);

		response.prettyPrint();
		System.out.println("status code is \n" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.getBody().path("statusCode"), "I0001");
		//Assert.assertEquals(response.getBody().path("statusValue"), "Record saved successfully");
		//Assert.assertEquals(response.getBody().path("description"), "Record is inserted in mw_project_visit_role_output_referral_question table successfully");
		//System.out.println(response.getBody().asString());
		
		//print in the file 
		PrintStream ps = new PrintStream(new File ("C:\\Users\\mdkam\\Desktop\\TestData1"));
		System.setOut(ps);
		ps.print(response.getBody().asString());
	}
}
