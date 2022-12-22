package elements;

public class LoginElements {

    static private String usernameTxt = "id_username";

    static private String passwordTxt = "id_password";

    static private String loginBtn = "//input[@type=\'submit\']";

    public String getUsernameTxt() {
        return usernameTxt;
    }

    public String getPasswordTxt() {
        return passwordTxt;
    }

    public String getLoginBtn() {
        return loginBtn;
    }
}
