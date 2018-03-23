package com.myweb.chinabrands;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myweb.Table;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChinaBrandsAPI {
    private String url = "https://api.chinabrands.cn/";
    private String charset = "gb18030";
    private HttpClientUtil httpClientUtil = null;

    public ChinaBrandsAPI() {
        httpClientUtil = new HttpClientUtil();
    }

    //将命令打印到1.log上 java -jar weichi-1.0.0.jar > 1.log

    public String getIndex(String token, String sku) throws IOException {
        String httpOrgCreateTest = url + "v2/product/index";
        Map<String, String> createMap = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(sku);
        createMap.put("goods_sn", json);
        createMap.put("token", token);
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, createMap, charset);
        return httpOrgCreateTestRtn;
    }

    public String getStock(String token, String sku, String warehouse) throws IOException {
        String httpOrgCreateTest = url + "v2/product/stock";
        Map<String, String> createMap = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(sku);
        createMap.put("goods_sn", json);
        createMap.put("token", token);
        createMap.put("warehouse", warehouse);
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, createMap, charset);
        return httpOrgCreateTestRtn;
    }


    public String getToken(String email, String password, String clientId, String apiKey) throws IOException {
        String httpOrgCreateTest = url + "v2/user/login";
        Map<String, String> createMap = new HashMap<String, String>();
        User user = new User();
        user.setClient_id(clientId);
        user.setEmail(email);
        user.setPassword(password);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        final String signature = md5(json + apiKey);
        createMap.put("data", json);
        createMap.put("signature", signature);
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, createMap, charset);
        return httpOrgCreateTestRtn;
    }

    public Table getStockTableYB(String token, Table table) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String stockString = this.getStock(token, table.getSku(), "YB");
        System.out.println(stockString);
        Result stockResult = mapper.readValue(stockString, Result.class);
        if (stockResult.getStatus() == 1) {
            StockMsg stockMsg = mapper.readValue(mapper.writeValueAsString(stockResult.getMsg()), StockMsg.class);
            for (Stock stock : stockMsg.getPage_result()) {
                if (stock.getStatus() == 1) {
                    table.setGoods_number(stock.getGoods_number());
                } else if (stock.getStatus() == 0) {
                    table.setMsg1("CN1:"+stock.getMsg().toString());
                }
            }
        } else if (stockResult.getStatus() == 0) {
            table.setMsg1("CN1:"+stockResult.getMsg().toString());
        }
        return table;
    }

    public Table getStockTableFXQHBSWH(String token, Table table) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String stockString = this.getStock(token, table.getSku(), "FXQHBSWH");
        System.out.println(stockString);
        Result stockResult = mapper.readValue(stockString, Result.class);
        if (stockResult.getStatus() == 1) {
            StockMsg stockMsg = mapper.readValue(mapper.writeValueAsString(stockResult.getMsg()), StockMsg.class);
            for (Stock stock : stockMsg.getPage_result()) {
                if (stock.getStatus() == 1) {
                    table.setGoods_number(Integer.parseInt(table.getGoods_number())+Integer.parseInt(stock.getGoods_number())+"");
                }
            }
        }
        return table;
    }

    public Table getIndexTable(String token, Table table) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String indexString = this.getIndex(token, table.getSku());
        System.out.println(indexString);
        Result indexResult = mapper.readValue(indexString, Result.class);
        if (indexResult.getStatus() == 1) {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, IndexMsg.class);
            List<IndexMsg> indexMsgList = mapper.readValue(mapper.writeValueAsString(indexResult.getMsg()), javaType);
            for (IndexMsg indexMsg : indexMsgList) {
                if (indexMsg.getSku().equals(table.getSku())) {
                    if (indexMsg.getStatus() == 1) {
                        table.setShip_weight(indexMsg.getShip_weight());
                        table.setVolume_weight(indexMsg.getVolume_weight());
                        WareHouse yb = indexMsg.getWarehouse_list();
                        if (yb.getYB() != null) {
                            Index index = yb.getYB();
                            table.setPrice(index.getPrice());
                        } else {
                            table.setMsg2("SKU not found in YB warehouse");
                        }
                    } else if (indexMsg.getStatus() == 0) {
                        table.setMsg2(indexMsg.getMsg().toString());
                    }
                }
            }
        } else if (indexResult.getStatus() == 0) {
            table.setMsg2(indexResult.getMsg().toString());
        }
        return table;
    }


    public static void main(String[] args) {
        ChinaBrandsAPI main = new ChinaBrandsAPI();
        try {
            ObjectMapper mapper = new ObjectMapper();
            String tokenString = main.getToken("3461402854@qq.com", "3461402854@qq.com", "1490033636", "2a91efd6bde801a515bf95bc20cea17f");
            Result tokenResult = mapper.readValue(tokenString, Result.class);
            Token token = new Token();
            if (tokenResult.getStatus() == 1) {
                token = mapper.readValue(mapper.writeValueAsString(tokenResult.getMsg()), Token.class);
            }
            String stockString = main.getStock(token.getToken(), "204529808", "YB");
            Result stockResult = mapper.readValue(stockString, Result.class);
            if (stockResult.getStatus() == 1) {
                StockMsg stockMsg = mapper.readValue(mapper.writeValueAsString(stockResult.getMsg()), StockMsg.class);
                for (Stock stock : stockMsg.getPage_result()) {
                    if (stock.getStatus() == 1) {
                        System.out.println(stock.getGoods_sn() + "   stock  " + stock.getGoods_number());
                    } else if (stock.getStatus() == 0) {
                        System.out.println(stock.getGoods_sn() + "       " + stock.getMsg());
                    }
                }
            } else if (stockResult.getStatus() == 0) {
                System.out.println("182350906    " + stockResult.getMsg());
            }

            String indexString = main.getIndex(token.getToken(), "204529808");
            Result indexResult = mapper.readValue(indexString, Result.class);
            System.out.println(indexString);
            if (indexResult.getStatus() == 1) {
                JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, IndexMsg.class);
                List<IndexMsg> indexMsgList = mapper.readValue(mapper.writeValueAsString(indexResult.getMsg()), javaType);
                for (IndexMsg indexMsg : indexMsgList) {
                    if (indexMsg.getSku().equals("182350906")) {
                        if (indexMsg.getStatus() == 1) {
                            System.out.println(indexMsg.getSku() + "  ship_weight     " + indexMsg.getShip_weight());
                            System.out.println(indexMsg.getSku() + "  volume_weight     " + indexMsg.getVolume_weight());
                            WareHouse yb = indexMsg.getWarehouse_list();
                            if (yb.getYB() != null) {
                                Index index = yb.getYB();
                                System.out.println(indexMsg.getSku() + "  price     " + index.getPrice());
                            } else {

                            }
                        } else if (indexMsg.getStatus() == 0) {
                            System.out.println(indexMsg.getSku() + "       " + indexMsg.getMsg());
                        }
                    }
                }
            } else if (indexResult.getStatus() == 0) {
                System.out.println("182350906    " + stockResult.getMsg());
            }
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