package com.bastex.codelearninghub.spring5.boot.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Functionally it is the same as @Component, but it provides semantic information that class contains business logic
 */
@Service
@Slf4j
public class UserLoggingService {
    public void logUserInfo(final UserInfo userInfo) {
        log.info("UserInfo: {}", userInfo);
    }
}
