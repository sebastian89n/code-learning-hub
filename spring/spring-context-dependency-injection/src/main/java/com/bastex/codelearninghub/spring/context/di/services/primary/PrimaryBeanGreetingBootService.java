package com.bastex.codelearninghub.spring.context.di.services.primary;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // this bean gets injected by default as impl of GreetingBootService if no bean Qualifier is provided
// (if there's more than one impl of given interface)
class PrimaryBeanGreetingBootService implements GreetingBootService {
    @Override
    public String sayGreeting() {
        return "Primary bean: Hello World!";
    }
}
