/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import ENTITY.*;
import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author huyhoai
 */
public class XExcelTK {
    public static final int COLUMN_INDEX_MASP = 0;
    public static final int COLUMN_INDEX_SANPHAM = 1;
    public static final int COLUMN_INDEX_SOLUONG = 2;
    public static final int COLUMN_INDEX_TONGTIEN = 3;
//    public static final int COLUMN_INDEX_ADDRESS = 4;
//    public static final int COLUMN_INDEX_DTE = 5;
    
    public static final int COLUMN_INDEX_MAHD = 0;
    public static final int COLUMN_INDEX_MANV = 1;
    public static final int COLUMN_INDEX_MAKH = 2;
    public static final int COLUMN_INDEX_TENNV = 3;
    public static final int COLUMN_INDEX_TENKH = 4;
    public static final int COLUMN_INDEX_THANHTIEN = 5;
    public static final int COLUMN_INDEX_NGAYMUA = 6;
    
    public static void exportExcel(String excelFilePath, List<ThongKe> list,List<HoaDon> list1) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
        // Create sheet
        Sheet sheet = workbook.createSheet("Sản Phẩm"); // Create sheet with sheet name
//        XSSFRow row = createRow(COLUMN_INDEX_MASP);
        Sheet sheet1 = workbook.createSheet("Hóa Đơn");
        int rowIndex = 0;
        int rowIndex1 = 0;

        // Write header
        writeHeader(sheet, rowIndex);
        writeHeader2(sheet1, rowIndex1);
        // Write data
        rowIndex++;
        for (ThongKe tk : list) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writethongke(tk, row);
            rowIndex++;
        }
        rowIndex1 ++;
        for (HoaDon hd : list1) {
            // Create row
            Row row = sheet1.createRow(rowIndex1);
            // Write data on row
            writehoadon(hd, row);
            rowIndex1++;
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
        Cell cell = row.createCell(COLUMN_INDEX_MASP);
        cell.setCellValue("Mã Sản Phẩm");

        cell = row.createCell(COLUMN_INDEX_SANPHAM);
        cell.setCellValue("Tên Sản Phẩm");

        cell = row.createCell(COLUMN_INDEX_SOLUONG);
        cell.setCellValue("Số Lượng");

        cell = row.createCell(COLUMN_INDEX_TONGTIEN);
        cell.setCellValue("Tổng Tiền");

//        cell = row.createCell(COLUMN_INDEX_ADDRESS);
//        cell.setCellValue("Địa chỉ");
//
//        cell = row.createCell(COLUMN_INDEX_DTE);
//        cell.setCellValue("Ngày Tham Gia");
    }
    
    private static void writeHeader2(Sheet sheet, int rowIndex) {

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_MAHD);
        cell.setCellValue("Mã Hóa Đơn");

        cell = row.createCell(COLUMN_INDEX_MANV);
        cell.setCellValue("Mã Nhân Viên");

        cell = row.createCell(COLUMN_INDEX_MAKH);
        cell.setCellValue("Mã Khách Hàng");

        cell = row.createCell(COLUMN_INDEX_TENNV);
        cell.setCellValue("Tên Nhân Viên");

        cell = row.createCell(COLUMN_INDEX_TENKH);
        cell.setCellValue("Tên Khách Hàng");

        cell = row.createCell(COLUMN_INDEX_THANHTIEN);
        cell.setCellValue("Thành Tiền");
        
        cell = row.createCell(COLUMN_INDEX_NGAYMUA);
        cell.setCellValue("Ngày Mua");
    }

    // Write data
    private static void writethongke(ThongKe tk, Row row) {
        Cell cell = row.createCell(COLUMN_INDEX_MASP);
        cell.setCellValue(tk.getMaSP());

        cell = row.createCell(COLUMN_INDEX_SANPHAM);
        cell.setCellValue(tk.getTensp());
        
        cell = row.createCell(COLUMN_INDEX_SOLUONG);
        cell.setCellValue(tk.getSoluong());

        cell = row.createCell(COLUMN_INDEX_TONGTIEN);
        cell.setCellValue(tk.getThanhtien());

//        cell = row.createCell(COLUMN_INDEX_ADDRESS);
//        cell.setCellValue(kh.getDiaChi());
//
//        cell = row.createCell(COLUMN_INDEX_DTE);
//        cell.setCellValue(kh.getNgayTG());

    }
    
    private static void writehoadon(HoaDon hd, Row row) {
        Cell cell = row.createCell(COLUMN_INDEX_MAHD);
        cell.setCellValue(hd.getMahd());

        cell = row.createCell(COLUMN_INDEX_MANV);
        cell.setCellValue(hd.getManv());
        
        cell = row.createCell(COLUMN_INDEX_MAKH);
        cell.setCellValue(hd.getMakh());

        cell = row.createCell(COLUMN_INDEX_TENNV);
        cell.setCellValue(hd.getTennv());

        cell = row.createCell(COLUMN_INDEX_TENKH);
        cell.setCellValue(hd.getTenkh());

        cell = row.createCell(COLUMN_INDEX_THANHTIEN);
        cell.setCellValue(hd.getThanhtien());
        
        cell = row.createCell(COLUMN_INDEX_NGAYMUA);
        cell.setCellValue(hd.getNgaymua());

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
