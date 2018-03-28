package com.myweb.autocall;

import android.content.Context;
import android.os.Environment;
import android.os.StrictMode;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ExcelUtil {

    public static PhoneNumber gePhoneNumbertXlsData() throws Exception {
        ArrayList<PhoneNumber> countryList = new ArrayList<PhoneNumber>();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        File file = new File(Environment.getExternalStorageDirectory() +"/AutoCall/phone.xls");
        Workbook workbook = Workbook.getWorkbook(new FileInputStream(file));
        Sheet sheet = workbook.getSheet(0);
        int sheetRows = sheet.getRows();
        boolean isThisNumber = false;
        PhoneNumber phoneNumber = new PhoneNumber();
        for (int i = 0; i < sheetRows; i++) {
            if(sheet.getCell(1,i).getContents().equals("1")){
                phoneNumber.setNumber(sheet.getCell(0,i).getContents());
            }
        }
        workbook.close();
        return phoneNumber;
    }
}
