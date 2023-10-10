package com.bastex.codelearninghub.spring.context.di.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Component - defines Spring bean that will be picked up by @ComponentScan
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;

    private String emailAddress;

    private String firstName;

    private String lastName;
}
