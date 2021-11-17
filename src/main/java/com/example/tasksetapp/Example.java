package com.example.tasksetapp;

import com.example.tasksetapp.model.Contract;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Example {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Contract>contractList;

    public Example(XSSFWorkbook workbook, XSSFSheet sheet, List<Contract> contractList) {
        this.workbook = workbook;
        workbook=new XSSFWorkbook();
        sheet=workbook.createSheet("nomini kirit");
    }


    public void writeHeaderRow(){
        Row row=sheet.createRow(0);

        Cell cell=row.createCell(0);
        cell.setCellValue("id");

        cell=row.createCell(1);
        cell.setCellValue("name");

        cell=row.createCell(2);
        cell.setCellValue("inn");

        cell=row.createCell(3);
        cell.setCellValue("111");

        cell=row.createCell(4);
        cell.setCellValue("2222");

        cell=row.createCell(5);
        cell.setCellValue("3333");
    }

    public void writeDataRow(){
        int rowCount=1;

        for (Contract contract:contractList){
            Row row=sheet.createRow(rowCount++);

            Cell cell=row.createCell(0);
            cell.setCellValue(contract.getId());

            cell=row.createCell(1);
            cell.setCellValue(contract.getDate());

            cell=row.createCell(2);
            cell.setCellValue(contract.getInformation());

            cell=row.createCell(3);
            cell.setCellValue(contract.getPriceS());

            cell=row.createCell(4);
            cell.setCellValue(contract.getQQS());
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeDataRow();
        writeDataRow();
        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

}
