package element;

public class LoginPage {
	
	// Login Page Element
	public static String FIELD_USERNAME = "//*[@id=\"username\"]";
	public static String FIELD_PASSWORD = "//*[@id=\"password\"]";
	public static String DROPDOWN_ROLE = "//*[@id=\"type\"]";
	public static String BUTTON_LOGIN = "/html/body/div[2]/form/div[4]/button";
	public static String BUTTON_FORGET_PASSWORD = "//*[@id=\"forget-password\"]";
	public static String NOTIF_FAIL_LOGIN = "/html/body/div[2]/form/div[1]";
	
	// Forget Password Page
	public static String FIELD_FP_EMAIL = "//*[@id=\"reset_password_email\"]";
	public static String BUTTON_FP_SUBMIT = "/html/body/div[2]/form/div[2]/button";
}
