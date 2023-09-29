package com.bastex.codelearninghub.spring.context.annotations.services;

import com.bastex.codelearninghub.spring.context.annotations.beans.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("annotationInitializedBeanService")
class UserServiceImpl implements UserService {
    @Override
    public String extractFullUserName(final UserInfo userInfo) {
        return userInfo.getFirstName() + " " + userInfo.getLastName();
    }
}
