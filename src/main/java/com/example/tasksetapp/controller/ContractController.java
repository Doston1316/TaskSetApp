package com.example.tasksetapp.controller;

import com.example.tasksetapp.ContractExcelExporter;
import com.example.tasksetapp.model.Contract;
import com.example.tasksetapp.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.DataFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;


    @GetMapping("/api")
    public void expertToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue=" attachement; fileName=contract.xlsx";

//        SimpleDateFormat dataFormat=  new SimpleDateFormat("yyyy-mm-dd_HH-mm-ss");
//        String currentDataType= String.valueOf(dataFormat.format(String.valueOf(new Date())));
//        String fileName="contract_"+ currentDataType +" xlsx";


        response.setHeader(headerKey,headerValue);

        List<Contract>contracts=contractService.list();

        ContractExcelExporter excelExporter=new ContractExcelExporter(contracts);
        excelExporter.export(response);

    }

//    @GetMapping("/{id}")
//    public void delete(@PathVariable Long id){
//        contractService.delete(id);
//    }


}
