package com.bastex.codelearninghub.spring.context.annotations.beans;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class UserInfo {
    private String firstName;

    private String lastName;
}
