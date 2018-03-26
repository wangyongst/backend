package com.myweb.excel;

import com.myweb.Table;
import com.myweb.chinabrands.CBAPIKey;
import com.myweb.jumia.APIKey;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectExcelRead {

    /*读取xlsx文件*/
    public static List<Table> readExcelByFileForXlsx(File file, int startrow, int col, int sheetnum) throws Exception {
        List<Table> varList = new ArrayList<Table>();
        FileInputStream fi = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fi);//xslx
        XSSFSheet sheet = wb.getSheetAt(sheetnum); //sheet 从0开始
        int rowNum = sheet.getLastRowNum() + 1;                     //取得最后一行的行号
        for (int i = startrow; i < rowNum; i++) {                    //行循环开始
            Table table = new Table();
            XSSFRow row = sheet.getRow(i);                             //行
            XSSFCell cell = row.getCell(col);
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            if (row != null && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("") && !cell.getStringCellValue().equals("null")) {
                table.setSku(cell.getStringCellValue());
                varList.add(table);
            }
        }
        return varList;
    }


    /*读取xlsx文件*/
    public static CBAPIKey readCBAPIKeyByFileForXlsx(File file, int sheetnum) throws Exception {
        List<CBAPIKey> varList = new ArrayList<CBAPIKey>();
        FileInputStream fi = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fi);//xslx
        XSSFSheet sheet = wb.getSheetAt(sheetnum); //sheet 从0开始
        CBAPIKey cbapikey = new CBAPIKey();
        XSSFRow row = sheet.getRow(1);                             //行
        XSSFCell cell1 = row.getCell(0);
        XSSFCell cell2 = row.getCell(1);
        XSSFCell cell3 = row.getCell(2);
        XSSFCell cell4 = row.getCell(3);
        cell1.setCellType(XSSFCell.CELL_TYPE_STRING);
        cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
        cell3.setCellType(XSSFCell.CELL_TYPE_STRING);
        cell4.setCellType(XSSFCell.CELL_TYPE_STRING);
        if (row != null && cell1.getStringCellValue() != null && !cell1.getStringCellValue().equals("") && !cell1.getStringCellValue().equals("null")) {
            cbapikey.setEmail(cell1.getStringCellValue());
            cbapikey.setPassword(cell2.getStringCellValue());
            cbapikey.setClientid(cell3.getStringCellValue());
            cbapikey.setApikey(cell4.getStringCellValue());
        }
        return cbapikey;
    }


    /*读取xlsx文件*/
    public static List<APIKey> readAPIKeyByFileForXlsx(File file, int sheetnum) throws Exception {
        List<APIKey> varList = new ArrayList<APIKey>();
        FileInputStream fi = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fi);//xslx
        XSSFSheet sheet = wb.getSheetAt(sheetnum); //sheet 从0开始
        int rowNum = sheet.getLastRowNum() + 1;                     //取得最后一行的行号
        for (int i = 1; i < rowNum; i++) {                    //行循环开始
            APIKey apikey = new APIKey();
            XSSFRow row = sheet.getRow(i);                             //行
            XSSFCell cell1 = row.getCell(0);
            XSSFCell cell2 = row.getCell(1);
            XSSFCell cell3 = row.getCell(2);
            cell1.setCellType(XSSFCell.CELL_TYPE_STRING);
            cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
            cell3.setCellType(XSSFCell.CELL_TYPE_STRING);
            if (row != null && cell1.getStringCellValue() != null && !cell1.getStringCellValue().equals("") && !cell1.getStringCellValue().equals("null")) {
                apikey.setUserId(cell1.getStringCellValue());
                apikey.setApiKey(cell2.getStringCellValue());
                apikey.setApiUrl(cell3.getStringCellValue());
                varList.add(apikey);
            }
        }
        return varList;
    }

    public static void writer(File file, List<Table> list, String sheetName) throws Exception {

        XSSFWorkbook wb = new XSSFWorkbook();//xslx
        XSSFSheet sheet = wb.createSheet(sheetName);

        //添加表头
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("sku");
        row.createCell(1).setCellValue("goods_number");
        row.createCell(2).setCellValue("price");
        row.createCell(3).setCellValue("ship_weight");
        row.createCell(4).setCellValue("volume_weight");
        row.createCell(5).setCellValue("msg1");
        row.createCell(6).setCellValue("msg2");
        for (int i = 0; i < list.size(); i++) {
            row = (Row) sheet.createRow(i + 1);
            row.setHeight((short) 500);
            row.createCell(0).setCellValue((list.get(i)).getSku());
            row.createCell(1).setCellValue((list.get(i)).getGoods_number());
            row.createCell(2).setCellValue((list.get(i)).getPrice());
            row.createCell(3).setCellValue((list.get(i)).getShip_weight());
            row.createCell(4).setCellValue((list.get(i)).getVolume_weight());
            row.createCell(5).setCellValue((list.get(i)).getMsg1());
            row.createCell(6).setCellValue((list.get(i)).getMsg2());
        }
        OutputStream outputStream = new FileOutputStream(file);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public static void main(String[] args) {
        try {
            File file = new File("C:\\C2J\\SKU\\cbapikey.xlsx");
            CBAPIKey cbapiKey = readCBAPIKeyByFileForXlsx(file,0);
            System.out.println(cbapiKey.getEmail()+cbapiKey.getPassword());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}