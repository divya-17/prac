import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Test {

    public static void main(String[] args) throws IOException {


        try {
            List<Integer> result = apiResponseParser(new ArrayList<>(Arrays.asList("address.city", "EQUALS", "giant.Tech.biz")), 3);
            System.out.println(result);

        }
        catch (Exception e){
            System.out.println("Exception occured while running api response parser "+e);
        }

    }

    public static List<Integer> apiResponseParser(List<String> inputList, int size) throws Exception {

        if(size != 3 || inputList.size() != 3){
            throw new Exception("Excepting input size to be 3");
        }
        List<Integer> outputIdList = new ArrayList<>();

        String fieldName = inputList.get(0);
        OPERATOR inputOperator= OPERATOR.valueOf(inputList.get(1));
        String value = inputList.get(2);

        String url = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";

        String responseStr= getHttpResponse(url);

        JSONArray jsonArray = new JSONArray(responseStr);

        for(int i =0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            System.out.println(jsonObject);
        }
//                innerElem = outerElem.getAsJsonObject().get(innerFieldStr);
//            }
//            if(innerElem != null){
//                targetElem = innerElem;
//            }else {
//                targetElem = outerElem;
//            }
//
//            if(inputOperator==OPERATOR.EQUALS) {
//                if (value.equalsIgnoreCase(targetElem.getAsString())) {
//
//                    BigDecimal id = jsonObject.get("id").getAsBigDecimal();
//                    outputIdList.add(id.intValue());
//                }
//            }else if(inputOperator == OPERATOR.IN){
//
//                ArrayList<String> valueList = new ArrayList<>(Arrays.asList(value.split(",")));
//
//                for(String w: valueList){
//                    if(w.equalsIgnoreCase(targetElem.getAsString())){
//                        BigDecimal id = jsonObject.get("id").getAsBigDecimal();
//                        outputIdList.add(id.intValue());
//                    }
//                }
//
//            }
//
//        }

        if(outputIdList.isEmpty()){
            return new ArrayList(Arrays.asList(-1));
        }
        else{
            return outputIdList;
        }
    }

    private static String getHttpResponse(String url) {

        String responseString = null;

        try {

            HttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(new HttpGet(url));

            HttpEntity responseEntity = response.getEntity();

            responseString = EntityUtils.toString(responseEntity);

        }
        catch (Exception e){
            System.out.println("Exception occured while getting the response from the URL");
        }
        return responseString;

    }
}

enum OPERATOR{
    EQUALS,IN;
}


