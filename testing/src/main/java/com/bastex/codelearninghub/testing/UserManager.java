package com.bastex.codelearninghub.testing;

import com.bastex.codelearninghub.testing.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserManager {
    private final UserService userService;

}
