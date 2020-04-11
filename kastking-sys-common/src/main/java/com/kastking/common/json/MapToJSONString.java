package com.kastking.common.json;

import java.util.Map;

/***
 * Map转JSON字符串
 */
public class MapToJSONString {
    public static String toJSONString(Map<String,String[]> map){
        JSONObject jsonObject = new JSONObject();
        try{
            for (Map.Entry<String,String[]> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(),entry.getValue()[0]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
