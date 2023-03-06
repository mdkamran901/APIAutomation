package com.ExecutionEngine;

	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;


	import com.AshaAPIs.GetDownloadMasterDetailsByProjectId;
	import com.AshaAPIs.GetDownloadProjectMorbidityDetails;
	import com.AshaAPIs.GetDownloadpatientdataByCreater;
	import com.AshaAPIs.GetDynamicProjectMorbidityOutputEvaluation;
	import com.AshaAPIs.GetPatientEnrollmentByData;
	import com.AshaAPIs.GetPatientEnrollmentPatientDataByNameAddress;
	import com.AshaAPIs.GetPersonAttributeTypeQuestionPatientSearch;
	import com.AshaAPIs.GetProjectByuserId;
	import com.AshaAPIs.GetUserById;
	import com.AshaAPIs.PostPatientEnrollmentPatientData;
	import com.AshaAPIs.PostProjectMorbidityOutputEvaluation;
	import com.AshaAPIs.PostSaveWithThirdParty;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class ExecutionEngineAshaRole {

		public ExtentReports extent;
		public ExtentTest extentTest;

		@BeforeTest
		public void setExtent() {
			extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
			extent.addSystemInfo("Host Name", "kamran");
			extent.addSystemInfo("User Name", "Md kamran");
			extent.addSystemInfo("Environment", "Dev Server");
		}

		@AfterTest

		public void endReport() throws Exception {
			extent.flush(); // extent.close(); // driver.quit();

		}

		@Test(priority=1)
		public void AshaLogIn() {
			extentTest = extent.startTest("My AshaLogIn Test Script APIs", " For AshaLogIne METHOD APIs ");
			extentTest.log(LogStatus.INFO, " AshaLogIn API Test Script Started");

			// LoginUser.loginuserashsrole();
			// extentTest.log(LogStatus.PASS, "Verify that Fetch Method loginuserashsrole");

			GetProjectByuserId.getprojectByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getprojectByuserId");

			GetUserById.getByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getByuserId");

			GetDownloadProjectMorbidityDetails.getdownloadProjectMorbidityDetails();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdownloadProjectMorbidityDetails");

			GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadMasterDetailsByProjectId");

			GetPatientEnrollmentByData.getPatientEnrollmentByData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPatientEnrollmentByData");
			/*
			 * 
			 * PostPatientEnrollmentPatientData.postPatientEnrollmentPatientData();
			 * extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method postPatientEnrollmentPatientData");
			 * 
			 * PostSaveWithThirdParty.postsaveWithThirdParty();
			 * extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method postsaveWithThirdParty");
			 * 
			 * PostProjectMorbidityOutputEvaluation.
			 * postDynamicProjectMorbidityOutputEvaluation(); extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method postDynamicProjectMorbidityOutputEvaluation");
			 * 
			 * PersonAttributeTypeQuestionPatientSearch.getdownloadProjectMorbidityDetails()
			 * ; extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getdownloadProjectMorbidityDetails");
			 * 
			 * GetPatientEnrollmentPatientDataByNameAddress.
			 * getPatientEnrollmentPatientDataByName(); extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getPatientEnrollmentPatientDataByName");
			 * 
			 * GetDownloadpatientdataByCreater.getDownloadpatientdataByCreater();
			 * extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getDownloadpatientdataByCreater");
			 * 
			 * GetDynamicProjectMorbidityOutputEvaluation.
			 * getdynamicProjectMorbidityOutputEvaluation(); extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getdynamicProjectMorbidityOutputEvaluation");
			 */

		}
		@Test(priority=2)
		public void AshaPatientSearch() {
			extentTest = extent.startTest("My AshaPatientSearch Test Script APIs", " For AshaPatientSearch METHOD APIs ");
			extentTest.log(LogStatus.INFO, " AshaPatientSearch API Test Script Started");

			// LoginUser.loginuserashsrole();
			// extentTest.log(LogStatus.PASS, "Verify that Fetch Method loginuserashsrole");

			GetProjectByuserId.getprojectByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getprojectByuserId");

			GetUserById.getByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getByuserId");

			GetDownloadProjectMorbidityDetails.getdownloadProjectMorbidityDetails();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdownloadProjectMorbidityDetails");

			GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadMasterDetailsByProjectId");

			GetPatientEnrollmentByData.getPatientEnrollmentByData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPatientEnrollmentByData");

			/*
			 * PostPatientEnrollmentPatientData.postPatientEnrollmentPatientData();
			 * extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method postPatientEnrollmentPatientData");
			 * 
			 * PostSaveWithThirdParty.postsaveWithThirdParty();
			 * extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method postsaveWithThirdParty");
			 * 
			 * PostProjectMorbidityOutputEvaluation.
			 * postDynamicProjectMorbidityOutputEvaluation(); extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method postDynamicProjectMorbidityOutputEvaluation");
			 */
		//	GetPersonAttributeTypeQuestionPatientSearch.getpersonAttributeTypeQuestionPatientSearch();
			//extentTest.log(LogStatus.PASS, "Verify the Fetch Method getpersonAttributeTypeQuestionPatientSearch");

			GetPatientEnrollmentPatientDataByNameAddress.getPatientEnrollmentPatientDataByName();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPatientEnrollmentPatientDataByName");

			GetDownloadpatientdataByCreater.getDownloadpatientdataByCreater();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadpatientdataByCreater");

			//GetDynamicProjectMorbidityOutputEvaluation.getdynamicProjectMorbidityOutputEvaluation();
			//extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdynamicProjectMorbidityOutputEvaluation");
		}
		@Test(priority=3)
		public void AshaPatientregistration() {
			extentTest = extent.startTest("My AshaPatientregistration Test Script APIs", " For AshaPatientregistration METHOD APIs ");
			extentTest.log(LogStatus.INFO, "AshaPatientregistration API Test Script Started");

			// LoginUser.loginuserashsrole();
			// extentTest.log(LogStatus.PASS, "Verify that Fetch Method loginuserashsrole");

			GetProjectByuserId.getprojectByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getprojectByuserId");

			GetUserById.getByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getByuserId");

			GetDownloadProjectMorbidityDetails.getdownloadProjectMorbidityDetails();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdownloadProjectMorbidityDetails");

			GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadMasterDetailsByProjectId");

			GetPatientEnrollmentByData.getPatientEnrollmentByData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPatientEnrollmentByData");

			PostPatientEnrollmentPatientData.postPatientEnrollmentPatientData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postPatientEnrollmentPatientData");

			PostSaveWithThirdParty.postsaveWithThirdParty();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postsaveWithThirdParty");

			/*
			 * PostProjectMorbidityOutputEvaluation.
			 * postDynamicProjectMorbidityOutputEvaluation(); extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method postDynamicProjectMorbidityOutputEvaluation");
			 * 
			 * PersonAttributeTypeQuestionPatientSearch.getdownloadProjectMorbidityDetails()
			 * ; extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getdownloadProjectMorbidityDetails");
			 * 
			 * GetPatientEnrollmentPatientDataByNameAddress.
			 * getPatientEnrollmentPatientDataByName(); extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getPatientEnrollmentPatientDataByName");
			 * 
			 * GetDownloadpatientdataByCreater.getDownloadpatientdataByCreater();
			 * extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getDownloadpatientdataByCreater");
			 * 
			 * GetDynamicProjectMorbidityOutputEvaluation.
			 * getdynamicProjectMorbidityOutputEvaluation(); extentTest.log(LogStatus.PASS,
			 * "Verify the Fetch Method getdynamicProjectMorbidityOutputEvaluation");
			 */
		}
		@Test(priority=4)
		public void AshaPatientScreening() {
			extentTest = extent.startTest("My AshaPatientScreening Test Script APIs", " For AshaPatientScreening METHOD APIs ");
			extentTest.log(LogStatus.INFO, "AshaPatientScreening API Test Script Started");

			// LoginUser.loginuserashsrole();
			// extentTest.log(LogStatus.PASS, "Verify that Fetch Method loginuserashsrole");

			GetProjectByuserId.getprojectByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getprojectByuserId");

			GetUserById.getByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getByuserId");

			GetDownloadProjectMorbidityDetails.getdownloadProjectMorbidityDetails();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdownloadProjectMorbidityDetails");

			GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadMasterDetailsByProjectId");

			GetPatientEnrollmentByData.getPatientEnrollmentByData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPatientEnrollmentByData");

			PostPatientEnrollmentPatientData.postPatientEnrollmentPatientData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postPatientEnrollmentPatientData");

			PostSaveWithThirdParty.postsaveWithThirdParty();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postsaveWithThirdParty");

			PostProjectMorbidityOutputEvaluation.postDynamicProjectMorbidityOutputEvaluation();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postDynamicProjectMorbidityOutputEvaluation");
			
			//GetPersonAttributeTypeQuestionPatientSearch.getpersonAttributeTypeQuestionPatientSearch();
			//extentTest.log(LogStatus.PASS, "Verify the Fetch Method getpersonAttributeTypeQuestionPatientSearch");
			

			GetDownloadProjectMorbidityDetails.getdownloadProjectMorbidityDetails();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdownloadProjectMorbidityDetails");

			//GetPatientEnrollmentPatientDataByNameAddress.getPatientEnrollmentPatientDataByName();
			//extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPatientEnrollmentPatientDataByName");

			//GetDownloadpatientdataByCreater.getDownloadpatientdataByCreater();
			//extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadpatientdataByCreater");

			GetDynamicProjectMorbidityOutputEvaluation.getdynamicProjectMorbidityOutputEvaluation();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdynamicProjectMorbidityOutputEvaluation");
		}
		@Test(priority=5)
		public void AshaPatientfollowup() {
			extentTest = extent.startTest("My AshaPatientfollowup Test Script APIs", " For AshaPatientfollowupL METHOD APIs ");
			extentTest.log(LogStatus.INFO, "AshaPatientfollowup API Test Script Started");

			// LoginUser.loginuserashsrole();
			// extentTest.log(LogStatus.PASS, "Verify that Fetch Method loginuserashsrole");

			GetProjectByuserId.getprojectByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getprojectByuserId");

			GetUserById.getByuserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getByuserId");

			GetDownloadProjectMorbidityDetails.getdownloadProjectMorbidityDetails();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdownloadProjectMorbidityDetails");

			GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadMasterDetailsByProjectId");

			GetPatientEnrollmentByData.getPatientEnrollmentByData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPatientEnrollmentByData");

			PostPatientEnrollmentPatientData.postPatientEnrollmentPatientData();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postPatientEnrollmentPatientData");

			PostSaveWithThirdParty.postsaveWithThirdParty();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postsaveWithThirdParty");

			PostProjectMorbidityOutputEvaluation.postDynamicProjectMorbidityOutputEvaluation();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method postDynamicProjectMorbidityOutputEvaluation");
			
			//GetPersonAttributeTypeQuestionPatientSearch.getpersonAttributeTypeQuestionPatientSearch();
			//extentTest.log(LogStatus.PASS, "Verify the Fetch Method getpersonAttributeTypeQuestionPatientSearch");

			GetDynamicProjectMorbidityOutputEvaluation.getdynamicProjectMorbidityOutputEvaluation();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdynamicProjectMorbidityOutputEvaluation");
			
			GetPersonAttributeTypeQuestionPatientSearch.getpersonAttributeTypeQuestionPatientSearch();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getpersonAttributeTypeQuestionPatientSearch");

			GetDynamicProjectMorbidityOutputEvaluation.getdynamicProjectMorbidityOutputEvaluation();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getdynamicProjectMorbidityOutputEvaluation");
		}

	}

