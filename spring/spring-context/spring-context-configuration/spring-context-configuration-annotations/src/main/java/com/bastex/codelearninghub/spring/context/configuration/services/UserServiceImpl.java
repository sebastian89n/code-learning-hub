package com.bastex.codelearninghub.spring.context.configuration.services;

import com.bastex.codelearninghub.spring.context.configuration.beans.UserInfo;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userService")
class UserServiceImpl implements UserService {
    @Override
    public String extractFullUserName(@NonNull final UserInfo userInfo) {
        validateUserInfo(userInfo);

        return userInfo.getFirstName() + " " + userInfo.getLastName();
    }

    private static void validateUserInfo(final UserInfo userInfo) {
        if (userInfo.getFirstName().isBlank() || userInfo.getLastName().isBlank()) {
            throw new IllegalArgumentException("First name and last name must be provided");
        }
    }
}
