package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

/**
 * Created by anna on 6/10/16.
 */
public class SignUpPageTest  {

    SignUpPage sup = new SignUpPage(driver);
    static WebDriver driver = new FirefoxDriver();




    @BeforeClass
    public void setUp() throws Exception {
        sup.readProperties("./src/main/resources/DataSource.properties");
        System.out.println("Starting Firefox driver.....");
        sup.before();
    }

    @AfterClass
    public void tearDown() throws Exception {
        sup.after();
    }



    @Test //(enabled = false)
    public void test_01_verifyTitle ()   {
        assertTrue(sup.verifyTitlePage( sup.title_SignUp_expected), "Test_01 FAILED: Unexpected Title ");
    }

    @Test //(enabled = false)
    public void test_02_verify_link_facebook () {
        Assert.assertEquals(sup.verify_imageLINK("id_img_facebook"), sup.title_facebook_expected);
    }

    @Test //(enabled = false)
    public void test_03_verify_link_twitter () {
        Assert.assertEquals(sup.verify_imageLINK("id_img_twitter"), sup.title_twitter_expected);
    }

    @Test //(enabled = false)
    public void test_04_verify_link_flickr () {
        Assert.assertEquals(sup.verify_imageLINK("id_img_flickr"), sup.title_flickr_expected);
    }

    @Test //(enabled = false)
    public void test_05_verify_link_youtube () {
        Assert.assertEquals(sup.verify_imageLINK("id_img_youtube"), sup.title_youtube_expected);
    }

    @Test //(enabled = false)
    public void test_06_verify_errorHandling_FirstName_empty(){
        Assert.assertEquals(sup.getFirstName_emptyField(), sup.error_fname_empty_expected);
    }

    @Test//            s (enabled = false)
    public void test_07_verify_errorHandling_LastName_empty(){
        Assert.assertEquals(sup.getLastName_emptyField(), sup.error_lname_empty_expected);
    }

    @Test //(enabled = false)
    public void test_08_verify_errorHandling_Email_empty(){
        Assert.assertEquals(sup.getEmailAddress_emptyField(), sup.error_email_empty_expected);
    }

    @Test //(enabled = false)
    public void test_09_verify_errorHandling_Phone_empty(){
        Assert.assertEquals(sup.getPhoneNumber_emptyField(), sup.error_phone_empty_expected);
    }

    @Test //(enabled = false)
    public void test_10_verify_errorHandling_invalidInput(){
        Assert.assertEquals(sup.getFirstName_invalidImput("ANNA^&!"), sup.error_firstName_invalidImput_expected);
    }

    @Test //(enabled = false)
    public void test_11_verify_errorHandling_invalidInput(){
        Assert.assertEquals(sup.getLastName_invalidImput("2345678890"), sup.error_lastName_invalidImput_expected);
    }

    @Test //(enabled = false)
    public void test_12_verify_errorHandling_invalidInput(){
        Assert.assertEquals(sup.getEmail_invalidImput("2345678890"), sup.error_email_invalidImput_expected);
    }

    @Test //(enabled = false)
    public void test_13_verify_errorHandling_invalidInput(){
        Assert.assertEquals(sup.getPhone_invalidImput("23456788a90"), sup.error_phone_invalidImput_expected);
    }

}