package com.bastex.codelearninghub.jakartaee.jaxws.server.web.dto;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "StatusResponse")
@XmlEnum
public enum StatusResponse {
    SUCCESS, NOT_FOUND, ERROR
}
