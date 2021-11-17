package com.example.tasksetapp.repository;

import com.example.tasksetapp.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
