package sonar;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapNullPointerTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("1", 1);
        map.put("2", 2);

        Integer integer = map.get("3");
//        System.out.println(integer);

        String name = "";
        System.out.println(isValidCatalogName(name));
        name = null;
        System.out.println(isValidCatalogName(name));
        name = "demo";
        System.out.println(isValidCatalogName(name));
        name = "dddddddddddddddddd  ddddddddddddddddddddddddddddddddd";
        System.out.println(isValidCatalogName(name));
    }

    private static boolean isValidCatalogName(String name) {
        return name != null && !name.isEmpty() && name.length() > 30;
    }
}
