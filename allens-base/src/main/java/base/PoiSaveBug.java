package com.olymtech.extend.common.utils;

import base.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;

public class PoiSaveBug
{
    public static void main(String[] args) throws IOException {
        Workbook wb = new SXSSFWorkbook(10);
        populateWorkbook(wb);
        saveTwice(wb);

//        wb = new SXSSFWorkbook();
//        populateWorkbook(wb);
//        saveTwice(wb);
    }

    static void populateWorkbook(Workbook wb) {
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 100; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }
        }
    }

    static void saveTwice(Workbook wb) {
        for(int i=0; i<2; i++) {
            try (NullOutputStream out = new NullOutputStream()) {
                wb.write(out);
            } catch(Exception e) {
                System.err.println("ERROR: failed on "+(i+1)+"th time calling "+wb.getClass().getName()+".write() with exception "+e.getMessage());
            }
        }
    }
    static class NullOutputStream extends OutputStream {
        public void write(int b) throws IOException {
        }
    }
}