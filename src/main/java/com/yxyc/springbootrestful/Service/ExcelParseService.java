package com.yxyc.springbootrestful.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;

public class ExcelParseService {

    @Test
    public void testRegion() throws Exception{
        path+="region.xls";
        XSSFWorkbook xlsx = new XSSFWorkbook();
        XSSFSheet sheet = xlsx.createSheet();
        XSSFRow row = sheet.createRow(0);
        CellRangeAddress address = new CellRangeAddress(0,2,1,3);
        sheet.addMergedRegion(address);
        row.createCell(0).setCellValue(0);

        FileOutputStream fos = new FileOutputStream(path);
        xlsx.write(fos);
        fos.flush();
        fos.close();

    }
    @Test
    public void createExcel() throws Exception{
        path+="newExcel.xls";
//        FileOutputStream fileOutputStream = new FileOutputStream(path);
//        FileInputStream fis = new FileInputStream(path);
//        if
        POIFSFileSystem psf = new POIFSFileSystem();
        HSSFWorkbook workbook1 = new HSSFWorkbook();
        HSSFSheet newsheet1 = workbook1.createSheet("新建1");
        workbook1.createSheet();
        workbook1.setSheetName(1,"this_is_new_sheet");

        HSSFRow row = newsheet1.createRow(0);
        HSSFCellStyle cellStyle = workbook1.createCellStyle();
        HSSFDataFormat dataFormat = workbook1.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat("@"));
        System.out.println(cellStyle);
        row.createCell(0).setCellStyle(cellStyle);

        row.createCell(1).setCellValue("姓名");
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        HSSFCell cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        
        cell.setCellValue(1.02);
        short lastCellNum = row.getLastCellNum();
        int rowNum = row.getRowNum();
        short lastCellNum1 = row.getLastCellNum();
        System.out.println("last cell num: "+lastCellNum1);
        System.out.println("rownum: "+rowNum);
        System.out.println("lastcellnum: "+lastCellNum);
        double numericCellValue = cell.getNumericCellValue();
//        newsheet1.addMergedRegion();

        XSSFWorkbook sheets = new XSSFWorkbook();
//        sheets.setsh
//        XSSFCellStyle cellStyle1 = sheets.createCellStyle();
//        cellStyle1.setDataFormat(sheets.createDataFormat().getFormat("@"));
//        XSSFSheet sheet = sheets.createSheet();
        //output
        FileOutputStream fos =new FileOutputStream(path);
        workbook1.write(fos);
        fos.flush();
        fos.close();
        System.out.println("end");

    }
    String path ="C:\\Users\\mike\\Desktop\\";
    @Test
    public void parseExcel() throws Exception{
        String fileName ="student(3).xls";

        path+=fileName;

        POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(path));
        Workbook workbook=new HSSFWorkbook(pfs);
//        for (Sheet rows : workbook) {
//
//        }
        System.out.println("start read excel");
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        while(iterator.hasNext()){
            Row next = iterator.next();
            Iterator<Cell> cellIterator = next.cellIterator();
            while(cellIterator.hasNext()){
                Cell next1 = cellIterator.next();
                String stringCellValue = next1.getStringCellValue();
                System.out.print(stringCellValue+"-->");
            }
            System.out.print("\r\n");
        }
        System.out.println("read excel ended");



    }
}
