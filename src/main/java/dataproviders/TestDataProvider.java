package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.concurrent.ThreadLocalRandom;

public class TestDataProvider {

    String username = "test_user_842679";   //existing user
    String password = username;

    @DataProvider(name = "loginData")
    public Object[][] getLoginUserdata() {
        return new Object[][]{
                {username, password}
        };
    }

    @DataProvider(name = "registerData")
    public Object[][] getRegisterUserdata() {
        String uname = "test_user_" + ThreadLocalRandom.current().nextInt(2345, 2345678);
        return new Object[][]{
                {uname, uname}
        };
    }
}
