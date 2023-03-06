package com.ExecutionEngine;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MorbidityLanguage.webAdmin.Dashboard.GET_MenuwithroleSuperAdmin;
import com.MorbidityLanguage.webAdmin.Dashboard.GET_ProjectByRoleName;
import com.MorbidityLanguage.webAdmin.Dashboard.GET_ProjectDashboardByProjectId;
import com.MorbidityLanguage.webAdmin.Dashboard.GET_ProjectGraphByUserIdByProjectId;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.AllMethodMorbidityBank;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.AllMethodMorbidityBankQuestion;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.AllMethodMorbidityBankQuestionOption;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.AllMethodMorbidityBankSection;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.GET_ProjectReferralQuestion;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.GetMorbidityBankQuestionLogic;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.POST_MultipleMorbidityBankQuestionLogic;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement.AllMethodAddLanguageMaster;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement.AllMethodBlockLocationMaster;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement.AllMethodCountryLocationMaster;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement.AllMethodDistrictLocationMaster;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.LanguageManagement.AllMethodStateLocationMaster;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.AllMethodProjectTheme;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_Persion;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_ProjectPersonAttributeType;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_ProjectResource;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_ProjectUser;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_QuestionType;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_ResoubceByName;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_UserByRole;
import com.MorbidityLanguage.webAdmin.ProjectManagement.AllMethodProjectList;
import com.MorbidityLanguage.webAdmin.ProjectManagement.BulkPost_ProjectUser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExecutionEngineSuperAdminnRole {

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

	@Test(priority = 1)
	public void LogInSuperAdminDashBoardAPis() {
		extentTest = extent.startTest("My WebAdmin Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " webAdminDashBoard API Test Script Started");

		// LoginUser.loginuserashsrole();
		// extentTest.log(LogStatus.PASS, "Verify that Fetch Method loginuserashsrole");

		// DashBoard
		GET_MenuwithroleSuperAdmin.GET_MenuWithroleSuperAdmin();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method GET_MenuWithroleSuperAdmin");
		
		GET_ProjectByRoleName.GET_projectByRoleName();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method GET_projectByRoleName");
		
		GET_ProjectDashboardByProjectId.getprojectDashboardByProjectId();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getprojectDashboardByProjectId");
		
		GET_ProjectGraphByUserIdByProjectId.getProjectGraphByUserIdByProjectId();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectGraphByUserIdByProjectId");

	}
	public void LanguageManagementAPIs() {
		extentTest = extent.startTest("My LanguageManagementAPIs Test Script", " For LanguageManagementAPIs METHOD APIs ");
		extentTest.log(LogStatus.INFO, " LanguageManagementAPIs Test Script Started");
		
		AllMethodCountryLocationMaster.POST_CountryLocationMaster();
		AllMethodCountryLocationMaster.GET_CountryLocationMaster();
		AllMethodCountryLocationMaster.UPDATE_CountryLocationMaster();
		//AllMethodCountryLocationMaster.DELETE_CountryLocationMaster();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_CountryLocationMaster, GET_CountryLocationMaster"
				+ "UPDATE_CountryLocationMaster, DELETE_CountryLocationMaster"); 
		
		AllMethodStateLocationMaster.POST_StateLocationMaster();
		AllMethodStateLocationMaster.GET_StateLocationMaster();
		AllMethodStateLocationMaster.UPDATE_StateLocationMaster();
		//AllMethodStateLocationMaster.DELETE_StateLocationMaster();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_StateLocationMaster, GET_StateLocationMaster"
				+ "UPDATE_StateLocationMaster, DELETE_StateLocationMaster"); 
		
		AllMethodDistrictLocationMaster.POST_DistrictLocationMaster();
		AllMethodDistrictLocationMaster.GET_DistrictLocationMaster();
		AllMethodDistrictLocationMaster.UPDATE_DistrictLocationMaster();
		//AllMethodDistrictLocationMaster.DELETE_DistrictLocationMaster();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_DistrictLocationMaster, GET_DistrictLocationMaster"
				+ "UPDATE_DistrictLocationMaster, DELETE_DistrictLocationMaster");
		
		AllMethodBlockLocationMaster.POST_BlockLocationMaster();
		AllMethodBlockLocationMaster.GET_BlockLocationMaster();
		AllMethodBlockLocationMaster.UPDATE_BlockLocationMaster();
		//AllMethodBlockLocationMaster.DELETE_BlockLocationMaster();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_BlockLocationMaster, GET_BlockLocationMaster"
				+ "UPDATE_BlockLocationMaster, DELETE_BlockLocationMaster");
		
		AllMethodAddLanguageMaster.POST_AddLanguageMaster();
		AllMethodAddLanguageMaster.GET_AddLanguageMaster();
		AllMethodAddLanguageMaster.UPDATE_AddLanguageMaster();
		//AllMethodAddLanguageMaster.DELETE_AddLanguageMaster();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_AddLanguageMaster, GET_AddLanguageMaster"
				+ "UPDATE_AddLanguageMaster, DELETE_AddLanguageMaster");
		
	}

	//@Test(priority = 3)
	public void MorbidityAPI() {
		extentTest.log(LogStatus.INFO, " MorbidityAPI API Test Script Started");

		AllMethodMorbidityBank.post_MorbidityBank();
		AllMethodMorbidityBank.get_MorbidityBankByMorbidityBank();
		AllMethodMorbidityBank.update_MorbidityBankByMorbidityBank();
		//AllMethodMorbidityBank.deleteMorbidityBankByMorbidityBank();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_MorbidityBank,"
				+ "get_MorbidityBankByMorbidityBank, update_MorbidityBankByMorbidityBank, deleteMorbidityBankByMorbidityBank");
		
		AllMethodMorbidityBankSection.postMorbidityBankPage();
		AllMethodMorbidityBankSection.getMorbidityBankPageByMorbidityBankId();
		AllMethodMorbidityBankSection.updateMorbidityBankPage();
		//AllMethodMorbidityBankPage.deleteMorbidityBankPageByMorbidityBank();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method postMorbidityBankPage, getMorbidityBankPageByMorbidityBankId"
				+ "updateMorbidityBankPage, deleteMorbidityBankPageByMorbidityBank");
		
		AllMethodMorbidityBankQuestionOption.postMorbidityBankQuestionOption();
		AllMethodMorbidityBankQuestionOption.getMorbidityQuestionOption();
		AllMethodMorbidityBankQuestionOption.updateMorbidityQuestionOption();
		// GetAllMethodMorbidityQuestionOption.deleteMorbidityQuestionOption();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method postMorbidityQuestionOption, getMorbidityQuestionOption"
				+ "updateMorbidityQuestionOption, deleteMorbidityQuestionOption");

		AllMethodMorbidityBankQuestion.postMorbidityBankQuestion();
		AllMethodMorbidityBankQuestion.getMorbidityBankQuestion();
		AllMethodMorbidityBankQuestion.updateMorbidityBankQuestion();
		// AllMethodMorbidityBankQuestion.deleteMorbidityBankQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method postMorbidityBankQuestion, getMorbidityBankQuestion"
				+ "updateMorbidityBankQuestion, deleteMorbidityBankQuestion");
		
		GET_QuestionType.getQuestionType();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getQuestionType");
		
		GetMorbidityBankQuestionLogic.getMorbidityBankQuestionLogic();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getMorbidityBankQuestionLogic");
		
		POST_MultipleMorbidityBankQuestionLogic.POSTMultiple_MorbidityBankQuestionLogic();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POSTMultiple_MorbidityBankQuestionLogic");
	}
	//@Test(priority = )
	public void ProjectManagementAPIs() {
		extentTest.log(LogStatus.INFO, " ProjectManagement API Test Script Started");
		
		AllMethodProjectList.POST_ProjectList();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_ProjectList");
		AllMethodProjectList.GET_ProjectList();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method GET_ProjectList");
		AllMethodProjectList.UPDATE_ProjectList();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method UPDATE_ProjectList");
		AllMethodProjectList.DELETE_ProjectList();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method DELETE_ProjectList");
		
		GET_ProjectPersonAttributeType.getProjectPersonAttributeType();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectPersonAttributeType");
		
		BulkPost_ProjectUser.BulkPost_projectUser();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method BulkPost_projectUser");
		
		GET_ProjectUser.getProjectUser();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectUser");
		
		GET_UserByRole.getUserByRole();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getUserByRole");
		
		GET_Persion.getPersion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getPersion");
		
		AllMethodProjectTheme.postProjectTheme();
		AllMethodProjectTheme.getProjectTheme();
		AllMethodProjectTheme.updateProjectTheme();
		//AllMethodProjectTheme.deleteProjectTheme();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method postProjectTheme, getProjectTheme"
				+ "updateProjectTheme, deleteProjectTheme");
		
		GET_ProjectResource.getProjectResource();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectResource");
		
		GET_ResoubceByName.getResoubceByName();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getResoubceByName");
		
		GET_ProjectReferralQuestion.get_ProjectReferralQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectReferralQuestion");
	}
	
}

