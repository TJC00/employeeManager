package com.blackamanholdings.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author TJChidanika
 * @Date 1/6/2022
 * @TIME 18:28
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {
    @Id
    private String id;
    private String name;
    private String surname;
    private String employeeCode;
    private String imageUrl;
    private String jobTitle;

}
