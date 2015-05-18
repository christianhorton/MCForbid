package com.mcforbid.core;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.json.*;
import org.json.simple.JSONObject;

public class APIUrlConstructor {


	private final String API_URL = "http://airmc.co/mcforbid/api.php";
	private final String DEFAULT_ENCODING_FOR_URL = "UTF-8";
	
    private Map<String, String> map;

    public APIUrlConstructor() {
    	 map = new LinkedHashMap<String, String>();
    }


    public String getParameter(String param) {
        return map.get(param);
    }

    public void setParameter(String param, Object value) {
        map.put(param, value.toString());
    }

    public void unsetParameter(String param) {
        map.remove(param);
    }

    public String getUrl() {
        StringBuilder sb = new StringBuilder(API_URL);

        List<String> listOfParams = new ArrayList<String>();
        for (String param : map.keySet()) {
            listOfParams.add(param + "=" + encodeString(map.get(param)));
        }

        if (!listOfParams.isEmpty()) {
            String query = StringUtils.join(listOfParams, "&");
            sb.append("?");
            sb.append(query);
        }

        return sb.toString();
    }

    public String encodeString(String name) throws NullPointerException {
        String tmp = null;

        if (name == null)
            return null;

        try {
            tmp = java.net.URLEncoder.encode(name, DEFAULT_ENCODING_FOR_URL);
        } catch (Exception e) {}

        if (tmp == null)
            throw new NullPointerException();

        return tmp;
    }
    
    public JSONObject getData() {
    	return null;
    }
}
