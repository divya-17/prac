package LLD.loggerFramework;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

       String test = "{'project_id': '1692729105','stage': 'trial'}";

       String outStr = test.replaceAll("\"","\\\\\"");

        System.out.println(outStr);
    }
}
