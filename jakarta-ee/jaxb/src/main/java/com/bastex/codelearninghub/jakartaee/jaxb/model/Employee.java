package com.bastex.codelearninghub.jakartaee.jaxb.model;

import com.bastex.codelearninghub.jakartaee.jaxb.adapters.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "employee")
@XmlType(propOrder = {"id", "firstName", "lastName", "birthDate"}) // specifies order of elements
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    // specifies attribute
    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "firstname")
    private String firstName;

    @XmlElement(name = "lastname")
    private String lastName;

    @XmlElement(name = "birthdate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class) // adapter to parse String to LocalDate and vice versa
    private LocalDate birthDate;

    @XmlTransient // field will be ignored when marshalling / unmarshalling
    private Instant lastUpdatedTimestamp;
}
