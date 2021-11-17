package com.example.tasksetapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Long inn;
    private Long KNumber;
    private Long numberS;
    private Float Price;
    private Float priceS;
    private Float QQS;
    private Float allPrice;
    private String Information;
    private String date;

    public Contract() {
    }

}
