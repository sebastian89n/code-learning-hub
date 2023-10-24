package com.bastex.codelearninghub.java.jaxp.model.students;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Students {
    private List<Student> students = new ArrayList<>();
}
