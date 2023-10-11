package com.bastex.codelearninghub.java.libs.mapstruct.transformers;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation to map common values
 */
@Retention(RetentionPolicy.CLASS)
@Mapping(target = "name", source = "description")
@interface NameToDescription {
}
