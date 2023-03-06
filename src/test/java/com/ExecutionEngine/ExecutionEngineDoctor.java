package com.ExecutionEngine;

	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.DoctorAPIs.GetDoctorPatientSearchByDoctorIdPgeNo;
	import com.DoctorAPIs.GetDownloadMasterDetailsByProjectId;
	import com.DoctorAPIs.GetDownloadProjectMorbidityDetailsByProjectIdByUserId;
	import com.DoctorAPIs.GetDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id;
	import com.DoctorAPIs.GetDynamicProjectMorbidityOutputEvaluation;
	import com.DoctorAPIs.GetPatientEnrollmentPatientDataByNameByAddress;
	import com.DoctorAPIs.GetPersonAttributeTypeQuestionPatientSearchByprojectId;
	import com.DoctorAPIs.GetProjectByUserId;
	import com.DoctorAPIs.GetUserById;
	import com.DoctorAPIs.PostDoctorVisitScreeningReviewInputFinal;
	import com.DoctorAPIs.PostSaveWithThirsparty;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class ExecutionEngineDoctor  {
		

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

		@Test(dataProvider="credetials")
		public void DoctorUserLogin(String Username, String Password) {
			extentTest = extent.startTest("My DoctorLogIn Test Script APIs", " For DoctorLogIn METHOD APIs ");
			extentTest.log(LogStatus.INFO, " DoctorUserLogin Method Test Script Started");
					
			// extentTest.log(LogStatus.PASS, "Verify that Fetch Method loginuserashsrole");
			GetProjectByUserId.getprojectByuserId(); 
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getprojectByuserId");
			
			
			GetUserById.getUserById();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getUserById");
			

			//GetDownloadProjectMorbidityDetailsByProjectIdByUserId.getDownloadProjectMorbidityDetailsByProjectIdByUserId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadProjectMorbidityDetailsByProjectIdByUserId");

			//GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
			extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadMasterDetailsByProjectId");

		}
		
		  @Test(priority = 2)
		  public void DoctorUserPatientList(){ 
		  extentTest = extent.startTest("My DoctorUserPatientList Test Script APIs"," For DoctorLogIn METHOD APIs "); 
		  extentTest.log(LogStatus.INFO," DoctorUserPatientList Method Test Script Started");
		  
		  //GetProjectByUserId.getprojectByuserId(); 
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getprojectByuserId");
		  
		  GetUserById.getUserById(); 
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getUserById");
		  
		  GetDownloadProjectMorbidityDetailsByProjectIdByUserId.getDownloadProjectMorbidityDetailsByProjectIdByUserId();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDownloadProjectMorbidityDetailsByProjectIdByUserId");
		  
		  GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDownloadMasterDetailsByProjectId");
		  
		  GetDoctorPatientSearchByDoctorIdPgeNo.getDoctorPatientSearchByDoctorIdPgeNo();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDoctorPatientSearchByDoctorIdPgeNo"); }
		  
		  @Test(priority = 3)
		  public void DoctorUserScreeningt() { 
			  extentTest =extent.startTest("My DoctorUserScreeningt Test Script APIs"," For DoctorLogIn METHOD APIs ");
			  extentTest.log(LogStatus.INFO," DoctorUserScreeningt Method Test Script Started");
		  
		  //GetProjectByUserId.getprojectByuserId(); 
			  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getprojectByuserId");
		  
		  GetUserById.getUserById(); extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getUserById");
		  
		  GetDownloadProjectMorbidityDetailsByProjectIdByUserId. getDownloadProjectMorbidityDetailsByProjectIdByUserId();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDownloadProjectMorbidityDetailsByProjectIdByUserId");
		  
		  GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
		  extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getDownloadMasterDetailsByProjectId");
		  
		  PostDoctorVisitScreeningReviewInputFinal.postDoctorVisitScreeningReviewInputFinal();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method postDoctorVisitScreeningReviewInputFinal");
		  
		  PostSaveWithThirsparty.postsaveWithThirdParty();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method postsaveWithThirdParty");
		  
		  GetDynamicProjectMorbidityOutputEvaluation. getDynamicProjectMorbidityOutputEvaluation(); 
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDynamicProjectMorbidityOutputEvaluation");
		  
		  GetDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id.getDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id");
		  
		  }
		  
		  @Test(priority = 4)
		  public void DoctorUserPatientSearch() { 
			  extentTest =extent.startTest("My DoctorUserPatientSearch Test Script APIs"," For DoctorLogIn METHOD APIs ");
			  extentTest.log(LogStatus.INFO, " DoctorUserPatientSearch Method Test Script Started");
		  
		 // GetProjectByUserId.getprojectByuserId(); 
			  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getprojectByuserId");
		  
		  GetUserById.getUserById(); extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getUserById");
		  
		  GetDownloadProjectMorbidityDetailsByProjectIdByUserId.
		  getDownloadProjectMorbidityDetailsByProjectIdByUserId();
		  extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getDownloadProjectMorbidityDetailsByProjectIdByUserId"
		  );
		  
		  GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
		  extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getDownloadMasterDetailsByProjectId");
		  
		  GetPersonAttributeTypeQuestionPatientSearchByprojectId.getPersonAttributeTypeQuestionPatientSearchByprojectId();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getPersonAttributeTypeQuestionPatientSearchByprojectId");
		  
		  GetDownloadProjectMorbidityDetailsByProjectIdByUserId.getDownloadProjectMorbidityDetailsByProjectIdByUserId();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDownloadProjectMorbidityDetailsByProjectIdByUserId");
		  
		  GetPatientEnrollmentPatientDataByNameByAddress.getPatientEnrollmentPatientDataByNameByAddress();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getPatientEnrollmentPatientDataByNameByAddress"); 
		  }
		  @Test(priority = 5) 
		  public void DoctorFollowUp() {
			  extentTest =extent.startTest("My DoctorFollowUp Test Script APIs", " For DoctorLogIn METHOD APIs "); 
			  extentTest.log(LogStatus.INFO," DoctorFollowUp Method Test Script Started");
		  
		 // GetProjectByUserId.getprojectByuserId(); 
			extentTest.log(LogStatus.PASS,"Verify the Fetch Method getprojectByuserId");
		  
		  GetUserById.getUserById();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getUserById");
		  
		  GetDownloadProjectMorbidityDetailsByProjectIdByUserId.
		  getDownloadProjectMorbidityDetailsByProjectIdByUserId();
		  extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getDownloadProjectMorbidityDetailsByProjectIdByUserId"
		  );
		  
		  GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
		  extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getDownloadMasterDetailsByProjectId");
		  
		  PostDoctorVisitScreeningReviewInputFinal.postDoctorVisitScreeningReviewInputFinal(); 
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method postDoctorVisitScreeningReviewInputFinal");
		  
		  PostSaveWithThirsparty.postsaveWithThirdParty();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method postsaveWithThirdParty");
		  
		  GetDynamicProjectMorbidityOutputEvaluation.getDynamicProjectMorbidityOutputEvaluation(); 
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDynamicProjectMorbidityOutputEvaluation");
		  
		  GetDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id.getDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDynamicProjectMorbidityByprojectMorbidityEvaluationListpatient_id"); 
		  }
		  
		  @Test(priority = 6) 
		  public void DoctorUserOutput() { 
			  extentTest = extent.startTest("My DoctorUserOutput Test Script APIs"," For DoctorLogIn METHOD APIs ");
			  extentTest.log(LogStatus.INFO," DoctorUserOutput Method Test Script Started");
		  
		  //GetProjectByUserId.getprojectByuserId(); 
			  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getprojectByuserId");
		  
		  GetUserById.getUserById(); extentTest.log(LogStatus.PASS,
		  "Verify the Fetch Method getUserById");
		  
		  GetDownloadProjectMorbidityDetailsByProjectIdByUserId.
		  getDownloadProjectMorbidityDetailsByProjectIdByUserId();
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method getDownloadProjectMorbidityDetailsByProjectIdByUserId");
		  
		  GetDownloadMasterDetailsByProjectId.getDownloadMasterDetailsByProjectId();
		  extentTest.log(LogStatus.PASS, "Verify the Fetch Method getDownloadMasterDetailsByProjectId");
		  
		  PostDoctorVisitScreeningReviewInputFinal.postDoctorVisitScreeningReviewInputFinal(); 
		  extentTest.log(LogStatus.PASS,"Verify the Fetch Method postDoctorVisitScreeningReviewInputFinal");
		  
		}
		 
	}
