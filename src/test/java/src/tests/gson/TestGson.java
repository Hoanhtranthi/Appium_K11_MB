package src.tests.gson;

import com.google.gson.Gson;
import src.test_data.models.LoginCreds;
import src.test_data.utils.DataObjectBuilder;

public class TestGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = "{\n" +
                "  \"username\": \"Teo\",\n" +
                "  \"password\": \"12345678\"\n" +
                "}";
        // From json to Object
        String fileLocation = "/src/test/java/src/tests/gson/login.json";
        LoginCreds[] loginCreds = DataObjectBuilder.buildDataObject(fileLocation, LoginCreds[].class);
        // From Object to json
        for (LoginCreds loginCred : loginCreds) {
            System.out.println(loginCreds);

        }


    }
}
