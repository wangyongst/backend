package com.myweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myweb.chinabrands.ChinaBrandsAPI;
import com.myweb.chinabrands.Result;
import com.myweb.chinabrands.Token;
import com.myweb.excel.ObjectExcelRead;
import com.myweb.jumia.ErrorResponse;
import com.myweb.jumia.JumiaAPI;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
        if (start.getExpires() < System.currentTimeMillis() / 1000 - 1800) {
            start = new Start();
        }
        ChinaBrandsAPI chinaBrandsAPI = new ChinaBrandsAPI();
        try {
            File skuFile = new File("C:\\C2J\\SKU\\sku.xlsx");
            List<Table> list = ObjectExcelRead.readExcelByFileForXlsx(skuFile, 1, 0, 0);
            System.out.println("C:\\C2J\\SKU\\sku.xlsx文件读取数据成功！");
            for (Table table : list) {
                table = chinaBrandsAPI.getStockTable(start.getToken(), table);
                System.out.println("SKU为"+table.getSku()+"的商口读取库存数据成功！");
                table = chinaBrandsAPI.getIndexTable(start.getToken(), table);
                System.out.println("SKU为"+table.getSku()+"的商口读取重量及价格数据成功！");
                ErrorResponse response =  JumiaAPI.update(table.getSku(),table.getGoods_number());
                if(response.getHead() != null){
                    table.setJumia(response.getHead().getErrorMessage());
                    System.out.println("SKU为"+table.getSku()+"的商口更新库存失败！");
                }else {
                    table.setJumia("Updated");
                    System.out.println("SKU为" + table.getSku() + "的商口更新库存成功！");
                }
                Thread.sleep(100);
            }
            File file = new File("C:\\C2J\\OUT\\out.xlsx");
            ObjectExcelRead.writer(file,list,"导出数据");
            System.out.println("C:\\C2J\\OUT\\out.xlsx文件导出数据成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("程序发生异常，无法继续运行，将自动停止！");
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
