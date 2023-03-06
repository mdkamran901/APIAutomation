package com.ExecutionEngine;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.MorbidityLanguage.webAdmin.MorbidityLanguage.Get_Language;
import com.MorbidityLanguage.webAdmin.MorbidityLanguage.Get_MorbidityBankLanguage;
import com.MorbidityLanguage.webAdmin.MorbidityLanguage.Get_MorbidityBankQuestionLanguage;
import com.MorbidityLanguage.webAdmin.MorbidityLanguage.Get_MorbidityBankSectionLanguage;
import com.MorbidityLanguage.webAdmin.MorbidityLanguage.Get_MorbidityQuestionOption;
import com.MorbidityLanguage.webAdmin.MorbidityLanguage.Get_MorbidityQuestionOptionLanguage;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.AllMethodMorbidityOutPutBank;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.AllMethodMorbidityOutputBankQuestion;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.AllMethodMorbidityOutputBankSection;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.BulkDelete_ProjectReferralQuestion;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.BulkPost_ProjectReferralQuestion;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.GET_ProjectMorbidityOutputQuestion;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.GET_ProjectMorbidityQuestion;
import com.MorbidityLanguage.webAdmin.MorbidityManagement.GET_ProjectReferralQuestion;
import com.MorbidityLanguage.webAdmin.PrivillageMaster.GET_Privilege;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.AllMethodProjectMorbidity;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.AllMethodProjectMorbidityPage;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.AllMethodProjectMorbidityQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.GetMorbidityBankQuestionByBankId;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.GetMorbidityQuestionOption;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.GetProjectMorbidityQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.GetProjectMorbidityQuestionLogic;
import com.MorbidityLanguage.webAdmin.ProjectMorbidity.GetQuestionType;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.AllMethodProjectMorbidityOutput;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.AllMethodProjectMorbidityOutputQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.AllMethodProjectMorbidityOutputSection;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.BulkDelete_ProjectMorbidityOutputQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.BulkDelete_ProjectVisitRoleOutputQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.BulkPost_ProjectMorbidityOutputQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.BulkPost_ProjectVisitRoleOutputQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.GET_MorbidityOutputBankQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityOutPut.GET_ProjectVisitRoleOutputQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit.AllMethod_VisitMaster;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit.AllMethod_VisitRole;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit.BulkDELETE_ProjectVisitRole;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit.BulkDELETE_ProjectVisitRoleQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit.BulkPOST_ProjectVisitRole;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit.BulkPOST_ProjectVisitRoleQuestion;
import com.MorbidityLanguage.webAdmin.ProjectMorbidityVisit.GET_ProjectVisitRoleQuestion;
import com.MorbidityLanguage.webAdmin.RoleMaster.ALLMethodRoles;
import com.MorbidityLanguage.webAdmin.Ruleset.ALLMethod_Ruleset;
import com.MorbidityLanguage.webAdmin.Ruleset.ALLMethod_RulesetVariable;
import com.MorbidityLanguage.webAdmin.Ruleset.ALLMethod_RulesetVariableDatatype;
import com.MorbidityLanguage.webAdmin.Ruleset.BulkDELETE_RulesetMapping;
import com.MorbidityLanguage.webAdmin.Ruleset.BulkPOST_RulesetMapping;
import com.MorbidityLanguage.webAdmin.Ruleset.GET_RulesetMapping;
import com.MorbidityLanguage.webAdmin.UserBulkUpload.POST_UserBulkUpload;
import com.MorbidityLanguage.webAdmin.UserMaster.ALLMethodUserList;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExecutionEngineSuperAdminRole2 {
	
	
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

	//@Test(priority = 1)
	public void MorbidityLanguageAPIs() {
		
		extentTest = extent.startTest("My MorbidityLanguageAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " MorbidityLanguageAPIs Test Script Started");
		
		Get_Language.get_Language();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_Language");
		
		Get_MorbidityBankLanguage.get_MorbidityBankLanguage();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_MorbidityBankLanguage");
		
		Get_MorbidityBankQuestionLanguage.get_MorbidityBankQuestionLanguage();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_MorbidityBankQuestionLanguage");
		
		Get_MorbidityBankSectionLanguage.get_MorbidityBankSectionLanguage();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_MorbidityBankSectionLanguage");
		
		Get_MorbidityQuestionOption.get_MorbidityQuestionOption();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_MorbidityQuestionOption");
		
		Get_MorbidityQuestionOptionLanguage.get_MorbidityQuestionOptionLanguage();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_MorbidityQuestionOptionLanguage");
		
	}
	@Test(priority = 2)
	public void ProjectMorbidityAPIs() {
		extentTest = extent.startTest("My ProjectMorbidityAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " ProjectMorbidityAPIs Test Script Started");
		
		AllMethodProjectMorbidity.postProjectMorbidity();
		AllMethodProjectMorbidity.getProjectMorbidity();
		AllMethodProjectMorbidity.updateProjectMorbidity();
		//AllMethodProjectMorbidity.deleteProjectMorbidity();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method postProjectMorbidity ,getProjectMorbidity, updateProjectMorbidity"
				+ "deleteProjectMorbidity ");
		
		AllMethodProjectMorbidityPage.post_ProjectMorbidityPage();
		AllMethodProjectMorbidityPage.get_MProjectMorbidityPage();
		AllMethodProjectMorbidityPage.update_ProjectMorbidityPage();
		//AllMethodProjectMorbidityPage.delete_ProjectMorbidityPage();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_ProjectMorbidityPage ,get_MProjectMorbidityPage, update_ProjectMorbidityPage"
				+ "delete_ProjectMorbidityPage ");
		
		AllMethodProjectMorbidityQuestion.post_ProjectMorbidityQuestio();
		AllMethodProjectMorbidityQuestion.get_ProjectMorbidityQuestio();
		AllMethodProjectMorbidityQuestion.update_ProjectMorbidityQuestio();
		//AllMethodProjectMorbidityQuestion.delete_ProjectMorbidityQuestio();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_ProjectMorbidityQuestio , "
				+ "get_ProjectMorbidityQuestio ,update_ProjectMorbidityQuestio , delete_ProjectMorbidityQuestio");
		
		GetMorbidityBankQuestionByBankId.getMorbidityBankQuestionByBankId();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getMorbidityBankQuestionByBankId");
		
		GetMorbidityQuestionOption.getMorbidityQuestionOption();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getMorbidityQuestionOption");
		
		GetProjectMorbidityQuestion.getProjectMorbidityQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectMorbidityQuestion");
		
		GetProjectMorbidityQuestionLogic.getProjectMorbidityQuestionLogic();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getProjectMorbidityQuestionLogic");
		
		GetQuestionType.getQuestionType();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method getQuestionType");
}
	//@Test(priority = 3)
	public void MorbidityOutputAPIs() {
		extentTest = extent.startTest("My MorbidityOutputAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " MorbidityOutputAPIs Test Script Started");
		
		AllMethodMorbidityOutPutBank.post_MethodMorbidityOutPut();
		AllMethodMorbidityOutPutBank.get_MethodMorbidityOutPut();
		AllMethodMorbidityOutPutBank.update_MethodMorbidityOutPut();
		//AllMethodMorbidityOutPutBank.delete_MethodMorbidityOutPut();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_MethodMorbidityOutPut, get_MethodMorbidityOutPut, update_MethodMorbidityOutPut, delete_MethodMorbidityOutPut");
		
		AllMethodMorbidityOutputBankSection.post_MethodMorbidityOutPut();
		AllMethodMorbidityOutputBankSection.get_MethodMorbidityOutPut();
		AllMethodMorbidityOutputBankSection.update_MethodMorbidityOutPuty();
		//AllMethodMorbidityOutputBankSection.delete_MethodMorbidityOutPut();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_MethodMorbidityOutPut, get_MethodMorbidityOutPut, update_MethodMorbidityOutPuty, delete_MethodMorbidityOutPut");
		
		AllMethodMorbidityOutputBankQuestion.post_MethodMorbidityOutPut();
		AllMethodMorbidityOutputBankQuestion.get_MethodMorbidityOutPut();
		AllMethodMorbidityOutputBankQuestion.update_MethodMorbidityOutPuty();
		//AllMethodMorbidityOutputBankQuestion.delete_MethodMorbidityOutPut();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_MethodMorbidityOutPut,get_MethodMorbidityOutPut, update_MethodMorbidityOutPuty,delete_MethodMorbidityOutPut ");
		
		GET_ProjectReferralQuestion.get_ProjectReferralQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectReferralQuestion");
		
		GET_ProjectMorbidityQuestion.get_ProjectMorbidityQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectMorbidityQuestion");
		
		BulkPost_ProjectReferralQuestion.ProjectReferralQuestionBulkPost();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method ProjectReferralQuestionBulkPost");
		BulkDelete_ProjectReferralQuestion.bulkDelete_ProjectReferralQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkDelete_ProjectReferralQuestion");
		
		GET_ProjectMorbidityOutputQuestion.get_ProjectMorbidityOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectMorbidityOutputQuestion");
	}

	//@Test(priority = 4)
	public void ProjectMorbidityOutputAPIs() {
		extentTest = extent.startTest("My ProjectMorbidityOutputAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " ProjectMorbidityOutputAPIs Test Script Started");
		
		AllMethodProjectMorbidityOutput.post_MethodProjectMorbidityOutput();
		AllMethodProjectMorbidityOutput.get_MethodProjectMorbidityOutput();
		AllMethodProjectMorbidityOutput.update_MethodProjectMorbidityOutput();
		//AllMethodProjectMorbidityOutput.delete_MethodProjectMorbidityOutput();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_MethodProjectMorbidityOutput,get_MethodProjectMorbidityOutput, update_MethodProjectMorbidityOutput, delete_MethodProjectMorbidityOutput");
		
		AllMethodProjectMorbidityOutputSection.post_MethodProjectMorbidityOutputSection();
		AllMethodProjectMorbidityOutputSection.get_MethodProjectMorbidityOutputSection();
		AllMethodProjectMorbidityOutputSection.update_MethodProjectMorbidityOutputSection();
		//AllMethodProjectMorbidityOutputSection.delete_MethodProjectMorbidityOutputSection();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_MethodProjectMorbidityOutputSection, get_MethodProjectMorbidityOutputSection, update_MethodProjectMorbidityOutputSection, delete_MethodProjectMorbidityOutputSection");
		
		AllMethodProjectMorbidityOutputQuestion.post_MethodProjectMorbidityOutputQuestion();
		AllMethodProjectMorbidityOutputQuestion.get_MethodProjectMorbidityOutputQuestion();
		AllMethodProjectMorbidityOutputQuestion.update_MethodProjectMorbidityOutputQuestion();
		//AllMethodProjectMorbidityOutputQuestion.delete_MethodProjectMorbidityOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_MethodProjectMorbidityOutputQuestion, get_MethodProjectMorbidityOutputQuestion, update_MethodProjectMorbidityOutputQuestion, delete_MethodProjectMorbidityOutputQuestion");
		
		GET_ProjectMorbidityOutputQuestion.get_ProjectMorbidityOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectMorbidityOutputQuestion");
		GET_MorbidityOutputBankQuestion.get_MorbidityOutputBankQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_MorbidityOutputBankQuestion");
		
		BulkPost_ProjectMorbidityOutputQuestion.bulkPost_ProjectMorbidityOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkPost_ProjectMorbidityOutputQuestion");
		BulkDelete_ProjectMorbidityOutputQuestion.bulkDelete_ProjectMorbidityOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkDelete_ProjectMorbidityOutputQuestion");
		
		GET_ProjectVisitRoleOutputQuestion.get_ProjectVisitRoleOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectVisitRoleOutputQuestion");
		
		BulkPost_ProjectVisitRoleOutputQuestion.bulkPost_ProjectVisitRoleOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkPost_ProjectVisitRoleOutputQuestion");
		BulkDelete_ProjectVisitRoleOutputQuestion.bulkDelete_ProjectVisitRoleOutputQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkDelete_ProjectVisitRoleOutputQuestion");
	}
	//@Test(priority = 5)
	public void ProjectMorbidityVisitAPIs() {
		extentTest = extent.startTest("My ProjectMorbidityVisitAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " ProjectMorbidityVisitAPIs Test Script Started");
		
		AllMethod_VisitMaster.post_VisitMaster();
		AllMethod_VisitMaster.get_VisitMaster();
		AllMethod_VisitMaster.update_VisitMaster();
		//AllMethod_VisitMaster.delete_VisitMaster();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_VisitMaster, get_VisitMaster,update_VisitMaster ,delete_VisitMaster");
		
		AllMethod_VisitRole.post_VisitRole();
		AllMethod_VisitRole.get_VisitRole();
		AllMethod_VisitRole.update_VisitRole();
		//AllMethod_VisitRole.delete_VisitRole();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_VisitRole, get_VisitRole, update_VisitRole, delete_VisitRole");
		
		BulkPOST_ProjectVisitRole.bulkPOST_ProjectVisitRole();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkPOST_ProjectVisitRole");
		BulkDELETE_ProjectVisitRole.bulkDELETE_ProjectVisitRole();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkDELETE_ProjectVisitRole");
		
		GET_ProjectVisitRoleQuestion.get_ProjectVisitRoleQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectVisitRoleQuestion");
		GET_ProjectMorbidityQuestion.get_ProjectMorbidityQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_ProjectMorbidityQuestion");
		
		BulkPOST_ProjectVisitRoleQuestion.bulkPOST_ProjectVisitRoleQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkPOST_ProjectVisitRoleQuestion");
		BulkDELETE_ProjectVisitRoleQuestion.bulkDELETE_ProjectVisitRoleQuestion();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkDELETE_ProjectVisitRoleQuestion");
	}
	//@Test(priority = 6)
	public void RuleSetMasterAPIs() {
		extentTest = extent.startTest("My RuleSetMasterAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " RuleSetMasterAPIs Test Script Started");
		
		ALLMethod_Ruleset.post_Ruleset();
		ALLMethod_Ruleset.get_Ruleset();
		ALLMethod_Ruleset.update_Ruleset();
		//ALLMethod_Ruleset.delete_Ruleset();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_Ruleset,get_Ruleset, update_Ruleset,delete_Ruleset ");
		
		ALLMethod_RulesetVariable.post_RulesetVariable();
		ALLMethod_RulesetVariable.get_RulesetVariable();
		ALLMethod_RulesetVariable.update_RulesetVariable();
		//ALLMethod_RulesetVariable.delete_RulesetVariable();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_RulesetVariable,get_RulesetVariable, update_RulesetVariable, delete_RulesetVariable");
		
		ALLMethod_RulesetVariableDatatype.post_RulesetVariable();
		ALLMethod_RulesetVariableDatatype.get_RulesetVariable();
		ALLMethod_RulesetVariableDatatype.update_RulesetVariable();
		//ALLMethod_RulesetVariableDatatype.delete_RulesetVariable();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_RulesetVariable, get_RulesetVariable,update_RulesetVariable, delete_RulesetVariable ");
		
		GET_RulesetMapping.get_RulesetMapping();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_RulesetMapping");
		
		BulkPOST_RulesetMapping.bulkPOST_RulesetMapping();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkPOST_RulesetMapping");
		BulkDELETE_RulesetMapping.bulkDELETE_RulesetMapping();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method bulkDELETE_RulesetMapping");
		
	}
	//@Test(priority = 7)
	public void PrivillageMasterAPIs() {
		extentTest = extent.startTest("My PrivillageMasterAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " PrivillageMasterAPIs Test Script Started");
		
		GET_Privilege.get_Privilege();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method get_Privilege");
	}
	//@Test(priority = 8)
	public void RoleMasterrAPIs() {
		extentTest = extent.startTest("My RoleMasterrAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " RoleMasterrAPIs Test Script Started");
		
		ALLMethodRoles.POST_Roles();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_Roles");
		ALLMethodRoles.GET_Roles();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method GET_Roles");
		ALLMethodRoles.UPDATE_Roles();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method UPDATE_Roles");
		//ALLMethodRoles.DELETE_Roles();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method DELETE_Roles");
		
	}
	//@Test(priority = 9)
	public void UserMasterAPis() {
		extentTest = extent.startTest("My UserMasterAPis Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " UserMasterAPis Test Script Started");
		
		ALLMethodUserList.POST_AddUser();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method POST_AddUser");
		ALLMethodUserList.GET_UserList();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method GET_UserList");
		ALLMethodUserList.UPDATE_User();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method UPDATE_User");
		//ALLMethodUserList.DELETE_User();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method DELETE_User");
		//ALLMethodUserList.statusActive_User();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method statusActive_User");
		
	}
	//@Test(priority = 10)
	public void UserBulkUploadAPIs() throws IOException {
		extentTest = extent.startTest("My UserBulkUploadAPIs Test Script APIs", " For WebAdmin METHOD APIs ");
		extentTest.log(LogStatus.INFO, " UserBulkUploadAPIs Test Script Started");
		
		POST_UserBulkUpload.post_UserBulkUpload();
		extentTest.log(LogStatus.PASS, "Verify the Fetch Method post_UserBulkUpload");
	}
}