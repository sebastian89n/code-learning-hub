package com.bastex.codelearninghub.jakartaee.jsonb.dto;

import com.bastex.codelearninghub.jakartaee.jsonb.deserializers.CertificationDateDeserializer;
import com.bastex.codelearninghub.jakartaee.jsonb.serializers.CertificationDateIsoSerializer;
import jakarta.json.bind.annotation.JsonbAnnotation;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbNillable;
import jakarta.json.bind.annotation.JsonbNumberFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonbAnnotation
@JsonbPropertyOrder({"id", "fullName", "salary", "address", "birthDate"})
public class Employee {

    @JsonbProperty("employeeId")
    private int id;

    private String fullName;

    @JsonbNumberFormat("#,##0.00")
    private BigDecimal salary;

    @JsonbNillable
    private String address;

    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate birthDate;

    private List<String> skills = new ArrayList<>();

    @JsonbTransient
    private Instant lastLogin;

    @JsonbTypeSerializer(CertificationDateIsoSerializer.class)
    @JsonbTypeDeserializer(CertificationDateDeserializer.class)
//    @JsonbTypeAdapter(CertificationDateAdapter.class)
    private Instant certificationDate;
}
