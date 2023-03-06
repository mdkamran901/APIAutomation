package com.ExecutionEngine;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MorbidityLanguage.webAdmin.MorbidityManagement.GET_ProjectReferralQuestion;
import com.MorbidityLanguage.webAdmin.ProjectAdmin.GET_MenuwithroleProjectAdmin;
import com.MorbidityLanguage.webAdmin.ProjectAdmin.GET_ProjectByUserByRoleName;
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
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_ResoubceByName;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.ProjectManagement.GET_UserByRole;
import com.MorbidityLanguage.webAdmin.ProjectAdminRole.UserManagement.AllMethodUserCreation;
import com.MorbidityLanguage.webAdmin.ProjectManagement.AllMethodProjectList;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExecutionEngineProjectAdminRole {
	
	
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
	public void LogInwithProjectAdminRoleAPIs() {
		extentTest = extent.startTest("My LogInwithProjectAdminRoleAPIs Test Script", " For LogInwithProjectAdminRoleAPIs METHOD APIs ");
		extentTest.log(LogStatus.INFO, " LogInwithProjectAdminRoleAPIs Test Script Started");

		GET_ProjectByUserByRoleName.get_ProjectByUserByRoleName();
		extentTest.log(LogStatus.PASS, "Verify that Fetch Method get_ProjectByUserByRoleName");
		
		GET_MenuwithroleProjectAdmin.GET_MenuWithroleProjectAdmin();
		extentTest.log(LogStatus.PASS, "Verify that Fetch Method GET_MenuwithroleProjectAdmin");
}
	@Test(priority = 2)
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
	@Test(priority = 3)
	public void ProjectManagementAPIs() {
		extentTest = extent.startTest("My ProjectManagementAPIs Test Script", " For ProjectManagementAPIs METHOD APIs ");
		extentTest.log(LogStatus.INFO, " ProjectManagementAPIs Test Script Started");
		
		AllMethodProjectList.POST_ProjectList();
		AllMethodProjectList.GET_ProjectList();
		AllMethodProjectList.UPDATE_ProjectList();
		//AllMethodProject.DELETE_ProjectList();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_ProjectList, GET_ProjectList, UPDATE_ProjectList, "
				+ "DELETE_ProjectList");
		
		GET_ProjectPersonAttributeType.getProjectPersonAttributeType();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectPersonAttributeType");
		
		GET_ProjectUser.getProjectUser();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectUser");
		
		GET_UserByRole.getUserByRole();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getUserByRole");
		
		GET_ProjectResource.getProjectResource();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectPerson");
		
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
	@Test(priority = 4)
	public void UserManagement() {
		extentTest = extent.startTest("My UserManagement Test Script", " For UserManagement METHOD APIs ");
		extentTest.log(LogStatus.INFO, " UserManagement Test Script Started");
		
		AllMethodUserCreation.POST_AddUser();
		AllMethodUserCreation.GET_UserList();
		AllMethodUserCreation.UPDATE_User();
		//AllMethodUserCreation.DELETE_User();
		//AllMethodUserCreation.statusActive_User();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_AddUser, GET_UserList"
				+ "UPDATE_User, DELETE_User, statusActive_User");
		
	}
}