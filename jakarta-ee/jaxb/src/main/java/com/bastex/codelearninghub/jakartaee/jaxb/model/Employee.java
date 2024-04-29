package com.bastex.codelearninghub.jakartaee.jaxb.model;

import com.bastex.codelearninghub.jakartaee.jaxb.adapters.LocalDateXmlAdapter;
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
    @XmlAttribute(name = "id", required = true)
    private String id;

    @XmlElement(name = "firstname", required = true)
    private String firstName;

    @XmlElement(name = "lastname", required = true)
    private String lastName;

    @XmlElement(name = "birthdate", required = true)
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class) // adapter to parse String to LocalDate and vice versa
    private LocalDate birthDate;

    @XmlTransient // field will be ignored when marshalling / unmarshalling
    private Instant lastUpdatedTimestamp;
}
