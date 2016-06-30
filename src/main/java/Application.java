import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.io.FileNotFoundException;
import java.io.FileReader;

@SuppressWarnings("unused")
public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        example1();

        /* Uncomment to test
        example2();
        example3();
        example4();
        */
    }

    private static JsonObject getJsonObject(String resourcePath) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        return parser.parse(getJsonFileReader(resourcePath)).getAsJsonObject();
    }

    private static JsonArray getJsonArray(String resourcePath) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        return parser.parse(getJsonFileReader(resourcePath)).getAsJsonArray();
    }

    private static FileReader getJsonFileReader(String resourcePath) throws FileNotFoundException {
        return new FileReader(Application.class.getResource(resourcePath).getFile());
    }

    private static void example1() throws FileNotFoundException {
        JsonObject jsonObject = getJsonObject("/data/example-1.json");

        System.out.println("Before");
        System.out.println(jsonObject.toString());

        System.out.println("");

        // Overriding existing properties
        jsonObject.addProperty("fieldA", "1");
        jsonObject.addProperty("fieldB", "2");
        jsonObject.addProperty("fieldC", "3");

        System.out.println("After");
        System.out.println(jsonObject.toString());
    }

    private static void example2() throws FileNotFoundException {
        JsonObject jsonObject = getJsonObject("/data/example-2.json");

        System.out.println("Before");
        System.out.println(jsonObject.toString());

        System.out.println("");

        jsonObject
                .getAsJsonObject("fieldA")
                .getAsJsonObject("fieldB").addProperty("fieldC", 3);

        System.out.println("After");
        System.out.println(jsonObject.toString());
    }

    private static void example3() throws FileNotFoundException {
        JsonObject jsonObject = getJsonObject("/data/example-3.json");

        System.out.println("Before");
        System.out.println(jsonObject.toString());

        System.out.println("");

        jsonObject.getAsJsonArray("fieldA").set(0, new JsonPrimitive(1));

        System.out.println("After");
        System.out.println(jsonObject.toString());
    }

    private static void example4() throws FileNotFoundException {
        JsonArray jsonArray = getJsonArray("/data/example-4.json");

        System.out.println("Before");
        System.out.println(jsonArray.toString());

        System.out.println("");

        jsonArray.get(0).getAsJsonObject().addProperty("fieldA", 1);
        jsonArray.get(1).getAsJsonObject().addProperty("fieldB", 2);

        System.out.println("After");
        System.out.println(jsonArray.toString());
    }
}
