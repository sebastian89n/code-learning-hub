package com.bastex.codelearninghub.spring.context.annotations.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserInfo {
    private String firstName;

    private String lastName;
}
