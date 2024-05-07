package com.huawei.ibooking.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDO {
    private int id;
    private String stuNum;
    private String name;
    private String password;
}
