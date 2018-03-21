package com.myweb.chinabrands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class ChinaBrandsAPI {
    private String url = "https://api.chinabrands.cn/";
    private String charset = "gb18030";
    private HttpClientUtil httpClientUtil = null;

    public ChinaBrandsAPI() {
        httpClientUtil = new HttpClientUtil();
    }

    public Result getToken() throws IOException {
        String httpOrgCreateTest = url + "v2/user/login";
        Map<String, String> createMap = new HashMap<String, String>();
        User user = new User();
        user.setClient_id("1490033636");
        user.setEmail("3461402854@qq.com");
        user.setPassword("3461402854@qq.com");
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //System.out.println(json);

        final String apiKey = "2a91efd6bde801a515bf95bc20cea17f";

        final String signature = md5(json + apiKey);

        createMap.put("data", json);
        createMap.put("signature", signature);
        // System.out.println(signature);
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, createMap, charset);
        //System.out.println("result:"+httpOrgCreateTestRtn);
        Result result = mapper.readValue(httpOrgCreateTestRtn, Result.class);
        //System.out.println(result.getStatus());
        return result;
    }

    public static void main(String[] args) {
        ChinaBrandsAPI main = new ChinaBrandsAPI();
        try {
            main.getToken();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}