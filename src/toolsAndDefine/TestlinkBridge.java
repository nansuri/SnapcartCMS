package toolsAndDefine;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TestlinkBridge {

	public static String DEV_KEY = "bb340a3e1f178109c74437fbfaae6daf"; //Your API Key
	public static String SERVER_URL = ("http://localhost/testlinkmoka/lib/api/xmlrpc/v1/xmlrpc.php"); //your testlink server url
	public static String PROJECT_NAME = "Cashback"; 
	public static String PLAN_NAME = "Testing";
	public static String BUILD_NAME = "Demo";
	public static String result = "";
	
	public void testCaseUpdater(String TC, int resultTC) throws TestLinkAPIException {
		if(resultTC==1) {
			result = TestLinkAPIResults.TEST_PASSED;
		} else {
			result = TestLinkAPIResults.TEST_FAILED;
		}
		updateTestLinkResult(TC, null, result);
	}
	
	private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException{
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY, SERVER_URL);
		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, exception, result);
	}

}
	