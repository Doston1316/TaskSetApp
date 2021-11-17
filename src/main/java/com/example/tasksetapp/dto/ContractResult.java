package com.example.tasksetapp.dto;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ContractResult implements RowMapper {


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ContractDto contractDto=new ContractDto();
        contractDto.setId(resultSet.getLong("id"));
        contractDto.setName(resultSet.getString("name"));
        contractDto.setInn(resultSet.getLong("inn"));
        contractDto.setDate(resultSet.getString("data"));
        contractDto.setInformation(resultSet.getString("Information"));
        contractDto.setKNumber(resultSet.getLong("KNumber"));
        contractDto.setNumberS(resultSet.getLong("numberS"));
        contractDto.setPrice(resultSet.getFloat("Price"));
        contractDto.setPriceS(resultSet.getFloat("priceS"));
        contractDto.setAllPrice(resultSet.getFloat("allPrice"));
        contractDto.setQQS(resultSet.getFloat("QQS"));
        return contractDto;
    }
}
