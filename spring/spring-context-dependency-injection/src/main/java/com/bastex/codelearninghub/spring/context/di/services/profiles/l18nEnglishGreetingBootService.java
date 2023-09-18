package com.bastex.codelearninghub.spring.context.di.services.profiles;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// default profile is executed if no other profile is preselected. Configured in application.properties
@Profile({"default", "EN"})
@Service("i18nService")
public class l18nEnglishGreetingBootService implements GreetingBootService {
    @Override
    public String sayGreeting() {
        return "Hello World! - EN/default profile";
    }
}
