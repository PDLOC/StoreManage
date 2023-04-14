/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import ENTITY.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author ADMIN
 */
public class XExcel {
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_NAME = 1;
    public static final int COLUMN_INDEX_SEX = 2;
    public static final int COLUMN_INDEX_PHONE = 3;
    public static final int COLUMN_INDEX_ADDRESS = 4;
    public static final int COLUMN_INDEX_DTE = 5;

    public static void exportExcel(String excelFilePath, List<KhachHang> list) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
        // Create sheet
        Sheet sheet = workbook.createSheet("Guest"); // Create sheet with sheet name

        int rowIndex = 0;

        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (KhachHang kh : list) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeKhachHang(kh, row);
            rowIndex++;
        }

        // Write footer
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
    }

    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue("Mã Nhân Viên");

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellValue("Tên Nhân Viên");

        cell = row.createCell(COLUMN_INDEX_SEX);
        cell.setCellValue("Giới Tính");

        cell = row.createCell(COLUMN_INDEX_PHONE);
        cell.setCellValue("Số Điện Thoại");

        cell = row.createCell(COLUMN_INDEX_ADDRESS);
        cell.setCellValue("Địa chỉ");

        cell = row.createCell(COLUMN_INDEX_DTE);
        cell.setCellValue("Ngày Tham Gia");
    }

    // Write data
    private static void writeKhachHang(KhachHang kh, Row row) {
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(kh.getMaKh());

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellValue(kh.getTenKh());
        
        cell = row.createCell(COLUMN_INDEX_SEX);
        cell.setCellValue(kh.isGioiTinh()? "Nam" : "Nữ");

        cell = row.createCell(COLUMN_INDEX_PHONE);
        cell.setCellValue(kh.getSdt());

        cell = row.createCell(COLUMN_INDEX_ADDRESS);
        cell.setCellValue(kh.getDiaChi());

        cell = row.createCell(COLUMN_INDEX_DTE);
        cell.setCellValue(kh.getNgayTG());

    }

    // Create CellStyle for header
   

    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try ( OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

}
