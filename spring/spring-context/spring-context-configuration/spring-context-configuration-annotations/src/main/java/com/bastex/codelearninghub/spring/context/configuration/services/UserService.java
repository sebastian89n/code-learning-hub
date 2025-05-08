package com.bastex.codelearninghub.spring.context.configuration.services;

import com.bastex.codelearninghub.spring.context.configuration.beans.UserInfo;

public interface UserService {
    String extractFullUserName(UserInfo userInfo);
}
