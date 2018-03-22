package com.myweb.excel;

import com.myweb.Table;
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
            if(row != null && cell.getStringCellValue() != null && !cell.getStringCellValue().equals("")&& !cell.getStringCellValue().equals("null")) {
                table.setSku(cell.getStringCellValue());
                varList.add(table);
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
        row.createCell(7).setCellValue("jumia");
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
            row.createCell(7).setCellValue((list.get(i)).getJumia());
        }
        OutputStream outputStream = new FileOutputStream(file);
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public static void main(String[] args) {
        try {
            File skuFile = new File("C:\\C2J\\SKU\\sku.xlsx");
            List<Table> list = readExcelByFileForXlsx(skuFile, 1, 0, 0);
            for (Table table : list) {
                System.out.println(table.getSku() + "|" + table.getGoods_number() + "|" + table.getShip_weight() + "|" + table.getVolume_weight() + "|" + table.getPrice() + "|" + table.getMsg1() + "|" + table.getMsg2());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}