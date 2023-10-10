package com.bastex.codelearninghub.spring.context.di.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service - functionally it is the same as @Component, but it provides semantic information that class contains business logic
 */
@Service
@Slf4j
public class UserLoggingService {
    public void logUserInfo(final UserInfo userInfo) {
        log.info("UserInfo: {}", userInfo);
    }
}
