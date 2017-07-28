package com.myweb.shuangseqiu;

import java.sql.*;
import java.util.*;

/**
 * Created by BHWL on 2017-06-01.
 */
public class Zhongjiang {

    public static Connection connection = null;

    private static Connection createConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&useOldAliasMetadataBehavior=true&zeroDateTimeBehavior=convertToNull&useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static Connection getConn() {
        if (connection == null) {
            connection = createConn();
            return connection;
        } else {
            return connection;
        }
    }

    private static int getBlue(String table) {
        Connection conn = getConn();
        String sql = "select b,count(1) times from " + table + " group by b order by times limit 1";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int getRedMore(String table, int count, int number) {
        Connection conn = getConn();
        String sql = "select r" + count + ",count(1) times from " + table + " group by r" + count + " having r" + count + " = " + number + " order by times desc; ";
        //System.out.println(sql);
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                return rs.getInt(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int insert(Numbers numbers) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into haochi (r1,r2,r3,r4,r5,r6,b) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, numbers.getR1());
            pstmt.setInt(2, numbers.getR2());
            pstmt.setInt(3, numbers.getR3());
            pstmt.setInt(4, numbers.getR4());
            pstmt.setInt(5, numbers.getR5());
            pstmt.setInt(6, numbers.getR6());
            pstmt.setInt(7, numbers.getBlue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    private static int getRed(String table, int number) {
        Integer count = 0;
        for (int i = 1; i <= 6; i++) {
            count = count + getRedMore(table, i, number);
        }
        return count;
    }

    private static int makeBlue() {
        return (new Random().nextInt(16) + 1);
    }

    private static int makeRed(int[] chi) {
        return chi[new Random().nextInt(chi.length)];
    }

    private static int[] makeChi(int[] chi, int out) {
        for (int i = 1; i <= chi.length; i++) {
            if (chi[i - 1] == out) {
                chi[i - 1] = chi[chi.length - 1];
            }
        }
        return Arrays.copyOf(chi, chi.length - 1);
    }

    private static Numbers makeNumbers() {
        Numbers num = new Numbers();
        num.setBlue(makeBlue());
        List<Integer> reds = new ArrayList<Integer>();
        int[] chi = new int[33];
        for (int i = 1; i <= 33; i++) {
            chi[i - 1] = i;
        }
        int r1 = makeRed(chi);
        reds.add(r1);
        chi = makeChi(chi, r1);
        int r2 = makeRed(chi);
        reds.add(r2);
        chi = makeChi(chi, r2);
        int r3 = makeRed(chi);
        reds.add(r3);
        chi = makeChi(chi, r3);
        int r4 = makeRed(chi);
        reds.add(r4);
        chi = makeChi(chi, r4);
        int r5 = makeRed(chi);
        reds.add(r5);
        chi = makeChi(chi, r5);
        int r6 = makeRed(chi);
        reds.add(r6);
        Collections.sort(reds);
        num.setR1(reds.get(0));
        num.setR2(reds.get(1));
        num.setR3(reds.get(2));
        num.setR4(reds.get(3));
        num.setR5(reds.get(4));
        num.setR6(reds.get(5));                                                                                                                                                                                        
        return num;
    }


    public static Numbers getLessNumber(String table) {
        Numbers num = new Numbers();
        num.setBlue(getBlue(table));
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 1; i <= 33; i++) {
            map.put(i, getRed(table, i));
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        num.setR1(list.get(0).getKey());
        num.setR2(list.get(1).getKey());
        num.setR3(list.get(2).getKey());
        num.setR4(list.get(3).getKey());
        num.setR5(list.get(4).getKey());
        num.setR6(list.get(5).getKey());

        for(Map.Entry<Integer,Integer> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }

        return num;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 0; i++) {
            Numbers num = makeNumbers();
            insert(num);
        }
       Numbers num  =  getLessNumber("zhongjiang");
        System.out.println(num.getR1());
        System.out.println(num.getR2());
        System.out.println(num.getR3());
        System.out.println(num.getR4());
        System.out.println(num.getR5());
        System.out.println(num.getR6());
        System.out.println("Blue is " + num.getBlue());
    }
}
