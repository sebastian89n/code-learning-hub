package com.bastex.codelearninghub.spring.context.annotations.services;

import com.bastex.codelearninghub.spring.context.annotations.beans.UserInfo;

public interface UserService {
    String extractFullUserName(UserInfo userInfo);
}
