package com.example.tasksetapp.service;

import com.example.tasksetapp.dto.ContractResult;
import com.example.tasksetapp.model.Contract;
import com.example.tasksetapp.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {


    private final ContractResult contractResult;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ContractRepository repository;

    public List<Contract>list(){
     return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    String query="elect * from contract c";
    public List<Contract>contracts(){
        return namedParameterJdbcTemplate.query(query,contractResult);
    }


}
