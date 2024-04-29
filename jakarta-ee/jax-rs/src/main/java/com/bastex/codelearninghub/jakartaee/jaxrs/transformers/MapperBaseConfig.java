package com.bastex.codelearninghub.jakartaee.jaxrs.transformers;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR)
public class MapperBaseConfig {
}
