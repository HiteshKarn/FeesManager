package utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import supportclasses.GenericBaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExcelUtility extends GenericBaseClass {
    FileInputStream fis;
    private HSSFWorkbook workbook;
    private File pdir;

    public void prepareErrorLog(ArrayList<String> list) throws IOException {
        ArrayList<String> lst = new ArrayList<String>(Arrays.asList("Date", "Scenario", "Page", "Error Message"));
        File file = new File("E:/testreports/" + readFile.readProperty(fileUI, "schoolname") + File.separator + readFile.readProperty(fileUI, "errorlogexcelname"));
        createFile(file);
        fis = new FileInputStream(file);
        workbook = new HSSFWorkbook();
        Sheet sheet = workbook.getSheet(readFile.readProperty(fileUI, "errorlogsheetname"));
        if (sheet == null)
            sheet = workbook.createSheet(readFile.readProperty(fileUI, "errorlogsheetname"));
        int rowcount = sheet.getPhysicalNumberOfRows() - sheet.getFirstRowNum();
        Row row = sheet.getRow(rowcount);
        if (rowcount == 0)
            row = sheet.createRow(rowcount);
        writeInExcel(file, row, lst);
        rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        row = sheet.createRow(rowcount + 1);
        writeInExcel(file, row, list);
    }

    private void createFile(File fl) throws IOException {
        pdir = fl.getParentFile();
        if (!fl.exists()) {
            System.out.println(readFile.readProperty(fileMsg, "filenotfound"));
            if (pdir != null)
                pdir.mkdirs();
            fl.createNewFile();
        }
    }

    private void writeInExcel(File file, Row row, ArrayList<String> lst) throws IOException {
        int i = 0;
        for (String l : lst) {
            Cell cell = row.createCell(i);
            cell.setCellValue(l);
            i++;
        }
        FileOutputStream fout = new FileOutputStream(file);
        workbook.write(fout);
    }
}