package com.myweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myweb.chinabrands.ChinaBrandsAPI;
import com.myweb.chinabrands.Result;
import com.myweb.chinabrands.Token;
import com.myweb.excel.ObjectExcelRead;
import com.myweb.jumia.APIKey;
import com.myweb.jumia.ErrorResponse;
import com.myweb.jumia.Head;
import com.myweb.jumia.JumiaAPI;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Start {

    private String token;
    private int expires;

    public Start() {
        ChinaBrandsAPI chinaBrandsAPI = new ChinaBrandsAPI();
        if (token == null || expires == 0) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                String tokenString = chinaBrandsAPI.getToken("3461402854@qq.com", "3461402854@qq.com", "1490033636", "2a91efd6bde801a515bf95bc20cea17f");
                Result tokenResult = mapper.readValue(tokenString, Result.class);
                if (tokenResult.getStatus() == 1) {
                    Token tokens = mapper.readValue(mapper.writeValueAsString(tokenResult.getMsg()), Token.class);
                    token = tokens.getToken();
                    expires = Integer.parseInt(tokens.getExpires());
                    System.out.println("ChinaBrands API 授权成功！！！！");
                } else {
                    System.out.println("ChinaBrands API 授权失败！！！！");
                }
            } catch (Exception e) {
                System.out.println("ChinaBrands API 授权失败！！！！");
            }
        }
    }

    public static void main(String[] args) {
        Start start = new Start();

        ChinaBrandsAPI chinaBrandsAPI = new ChinaBrandsAPI();
        try {
            File apiFile = new File("C:\\C2J\\SKU\\apiKey.xlsx");
            List<APIKey> apikeys = ObjectExcelRead.readAPIKeyByFileForXlsx(apiFile,0);
            if(apikeys.size() == 0){
                System.out.println("C:\\C2J\\SKU\\apiKey.xlsx文件读取APIKEY数据失败！");
                return;
            }else {
                System.out.println("C:\\C2J\\SKU\\apiKey.xlsx文件读取APIKEY数据成功！");
            }
            File skuFile = new File("C:\\C2J\\SKU\\sku.xlsx");
            List<Table> list = ObjectExcelRead.readExcelByFileForXlsx(skuFile, 1, 0, 0);
            System.out.println("C:\\C2J\\SKU\\sku.xlsx文件读取SKU数据成功！");

            Map<String,String> map = new HashMap<String,String>();
            for (int i = 0; i <list.size() ; i++) {
                Table table = list.get(i);
                table = chinaBrandsAPI.getStockTableYB(start.getToken(), table);
                System.out.println("SKU为"+table.getSku()+"的商品读取CN1库存数据成功！");
                table = chinaBrandsAPI.getStockTableFXQHBSWH(start.getToken(), table);
                System.out.println("SKU为"+table.getSku()+"的商品读取CN2库存数据成功！");
                table = chinaBrandsAPI.getIndexTable(start.getToken(), table);
                System.out.println("SKU为"+table.getSku()+"的商品读取重量及价格数据成功！");
                map.put(table.getSku(),table.getGoods_number());
                if(map.size() > 44 || i == list.size()-1) {
                    File file = new File("C:\\C2J\\OUT\\out.xlsx");
                    ObjectExcelRead.writer(file,list,"导出数据");
                    System.out.println("C:\\C2J\\OUT\\out.xlsx文件导出新获取到最后"+map.size()+"条的商品数据成功！");
                    for(APIKey apiKey:apikeys) {
                        ErrorResponse errorResponse = JumiaAPI.update(map, apiKey);
                        if (errorResponse.getErrorResponse() != null) {
                            System.out.println("导出的最后" + map.size() + "条的商品在"+apiKey.getUserId()+"账号中更新失败，失败原因:");
                            System.out.println("ErrorCode"+errorResponse.getErrorResponse().getHead().getErrorCode()+"     ErrorMessage"+errorResponse.getErrorResponse().getHead().getErrorMessage());
                            return;
                        } else {
                            System.out.println("导出的最后" + map.size() + "条的商品在"+apiKey.getUserId()+"账号中更新库存成功！");
                        }
                        Thread.sleep(60000);
                    }
                    map.clear();
                }
                Thread.sleep(500);
                if (start.getExpires() < System.currentTimeMillis() / 1000 + 1800) {
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        String tokenString = chinaBrandsAPI.getToken("3461402854@qq.com", "3461402854@qq.com", "1490033636", "2a91efd6bde801a515bf95bc20cea17f");
                        Result tokenResult = mapper.readValue(tokenString, Result.class);
                        if (tokenResult.getStatus() == 1) {
                            Token tokens = mapper.readValue(mapper.writeValueAsString(tokenResult.getMsg()), Token.class);
                            start.setToken(tokens.getToken());
                            start.setExpires(Integer.parseInt(tokens.getExpires()));
                            System.out.println("ChinaBrands API 授权成功！！！！");
                        } else {
                            System.out.println("ChinaBrands API 授权失败！！！！");
                        }
                    } catch (Exception e) {
                        System.out.println("ChinaBrands API 授权失败！！！！");
                    }
                }
            }
            System.out.println("程序运行结束，已经完成SKU文件中的全部数据导出及JUMIA网站全部账号更新！");
            System.out.println("你现在可以关闭程序窗口了！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("程序发生异常，无法继续运行，将自动停止！");
            return;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }
}
