package elements;

public class NewPostElements {

    static private String titleTxt = "id_title";

    static private String SubtitleTxt = "id_subtitle";

    static private String BodyTxt = "id_body";

    static private String createBtn = "//input[@type=\'submit\']";

    static private String pageTitle = "/html/body/div/h1";

    public String getTitleTxt() {
        return titleTxt;
    }

    public String getSubtitleTxt() {
        return SubtitleTxt;
    }

    public String getBodyTxt() {
        return BodyTxt;
    }

    public String getCreateBtn() {
        return createBtn;
    }

    public String getPageTitle() {
        return pageTitle;
    }
}
