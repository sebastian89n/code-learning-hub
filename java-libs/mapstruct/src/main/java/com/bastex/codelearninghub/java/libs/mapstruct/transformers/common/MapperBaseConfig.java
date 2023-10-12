package com.bastex.codelearninghub.java.libs.mapstruct.transformers.common;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * Common Config uses in @Mapper annotation.
 * Compiler will fail if there is unmapped field, and will force to specifically mapped as ignored.
 * Adds Spring support. It will add @Component on generated mapper. Requires Spring Context on the classpath.
 */
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, //
        componentModel = "spring", //
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MapperBaseConfig {
}
