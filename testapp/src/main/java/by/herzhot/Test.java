package by.herzhot;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    public static <T extends String & Serializable & Runnable> void main(String[] args) {


        Map<String, String> m = new HashMap<String, String>() {{
            put("1", "2");
        }};

        Map<?, ?> objectMap = m;

//        objectMap.put("k", "v");

        System.out.println(objectMap.get("1"));

    }
}
