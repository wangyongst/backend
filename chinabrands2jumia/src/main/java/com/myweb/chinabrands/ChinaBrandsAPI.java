package com.myweb.chinabrands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ChinaBrandsAPI {
    private static final String ScApiHost = "https://api.chinabrands.cn/v2/user/login";
    private static final String CHAR_UTF_8 = "UTF-8";

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<String, String>();
        ChinaBrandsUser user = new ChinaBrandsUser();
        user.setClient_id("fd781dd3b08e15849b013cd2be6d6f60");
        user.setEmail("1661317838@QQ.COM");
        user.setPassword("1661317838@QQ.COM");
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        params.put("data", json);
        final String apiKey = "1420942169";
        final String out = getTokenResponse(params, apiKey);
        System.out.println(out);
    }

    public static String getTokenResponse(Map<String, String> params, String apiKey) {
        String queryString = "";
        String Output = "";
        HttpsURLConnection connection = null;
        URL url = null;
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
        final String signature = md5(params.get("data") + apiKey);
        queryString = toQueryString(sortedParams);
        queryString = queryString.concat("&signature=".concat(signature));
        final String request = ScApiHost.concat("?".concat(queryString));
        System.out.println(request);
        try {
            url = new URL(request);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", CHAR_UTF_8);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Length", "" + Integer.toString(0));
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes("");
            wr.flush();
            wr.close();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                Output += line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Output;
    }

    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * build querystring out of params map
     *
     * @param data map of params
     * @return string
     * @throws UnsupportedEncodingException
     */
    private static String toQueryString(Map<String, String> data) {
        String queryString = "";
        try {
            StringBuffer params = new StringBuffer();
            for (Map.Entry<String, String> pair : data.entrySet()) {
                params.append(URLEncoder.encode((String) pair.getKey(), CHAR_UTF_8) + "=");
                params.append(URLEncoder.encode((String) pair.getValue(), CHAR_UTF_8) + "&");
            }
            if (params.length() > 0) {
                params.deleteCharAt(params.length() - 1);
            }
            queryString = params.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return queryString;
    }
}


data=%7B%22email%22%3A%221661317838%40QQ.COM%22%2C%22password%22%3A%221661317838%40QQ.COM%22%2C%22client_id%22%3A%22fd781dd3b08e15849b013cd2be6d6f60%22%7D
data=%7B%22email%22%3A%221661317838%40QQ.COM%22%2C%22password%22%3A%221661317838%40QQ.COM%22%2C%22client_id%22%3A%22fd781dd3b08e15849b013cd2be6d6f60%22%7D