package com.myweb.controller;

import java.util.regex.Pattern;

/**
 * Created by BHWL on 2017-04-12.
 */
public class TEST {

    public static void main(String[] args){
       System.out.println( Pattern.matches("^\\d{3}-\\d{7,8}|\\d{4}-\\d{7,8}$|\\d{11,12}","0931-8449977"));
    }

}
