package com.example.tasksetapp;

import com.example.tasksetapp.model.Contract;
import com.example.tasksetapp.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TaskSetAppApplication {
    @Autowired
    private ContractRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TaskSetAppApplication.class, args);
    }


    @PostConstruct
    public void init() {
        List<Contract> contractList = Stream.of(
                new Contract(17l, "test", 100200300l, 10l, 40l, 260.87f, 300f, 39.1f, 300f, "1", "03:49:20.024000")
        ).collect(Collectors.toList());
        repository.saveAll(contractList);
    }
}
