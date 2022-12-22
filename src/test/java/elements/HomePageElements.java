package elements;

public class HomePageElements {

    static private String newPostNavbar = "//*[@id=\"navbarNavAltMarkup\"]/div/a[4]";

    static private String postsNavbar = "//*[@id=\"navbarNavAltMarkup\"]/div/a[3]";

    static private String logOutNavbar = "//*[@id=\"navbarNavAltMarkup\"]/div/a[5]";

    public String getNewPostNavbar() {
        return newPostNavbar;
    }

    public String getPostsNavbar() {
        return postsNavbar;
    }

    public String getLogOutNavbar() {
        return logOutNavbar;
    }
}
