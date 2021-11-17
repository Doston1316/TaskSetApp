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

public class ContractExcelExporter {


    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    List<Contract>contracts;

    public ContractExcelExporter(List<Contract> contracts) {
    this.contracts=contracts;
    workbook=new XSSFWorkbook();
    sheet=workbook.createSheet("contract");
    }

    private void writeHeaderRow(){
        Row row=sheet.createRow(0);

        Cell cell=row.createCell(0);
        cell.setCellValue("ID");

        cell=row.createCell(1);
        cell.setCellValue("Имя");

        cell=row.createCell(2);
        cell.setCellValue("ИНН");

        cell=row.createCell(3);
        cell.setCellValue("Контактный номер");

        cell=row.createCell(4);
        cell.setCellValue("Номер счета");

        cell=row.createCell(5);
        cell.setCellValue("Цена");

        cell=row.createCell(6);
        cell.setCellValue("в цене");

        cell=row.createCell(7);
        cell.setCellValue("НДС");

        cell=row.createCell(8);
        cell.setCellValue("Итоговая цена");

        cell=row.createCell(9);
        cell.setCellValue("Описание");

        cell=row.createCell(10);
        cell.setCellValue("Дата создания");
    }

    private void writeDataRows(){
        int rowCount=1;
        for (Contract contract:contracts){
            Row row=sheet.createRow(rowCount++);

            Cell cell=row.createCell(0);
            cell.setCellValue(contract.getId());

            cell=row.createCell(1);
            cell.setCellValue(contract.getName());

            cell=row.createCell(2);
            cell.setCellValue(contract.getInn());

            cell=row.createCell(3);
            cell.setCellValue(contract.getKNumber());

            cell=row.createCell(4);
            cell.setCellValue(contract.getNumberS());

            cell=row.createCell(5);
            cell.setCellValue(contract.getPrice());

            cell=row.createCell(6);
            cell.setCellValue(contract.getPriceS());

            cell=row.createCell(7);
            cell.setCellValue(contract.getQQS());

            cell=row.createCell(8);
            cell.setCellValue(contract.getAllPrice());

            cell=row.createCell(9);
            cell.setCellValue(contract.getInformation());

            cell=row.createCell(10);
            cell.setCellValue(contract.getDate());


        }
    }

    public void export(HttpServletResponse response) throws IOException {
    writeHeaderRow();
    writeDataRows();
    ServletOutputStream outputStream=response.getOutputStream();
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
    }


}
