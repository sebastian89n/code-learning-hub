package com.bastex.codelearninghub.spring5boot.services.primary;

import com.bastex.codelearninghub.spring5boot.services.GreetingBootService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // this bean gets injected by default as impl of GreetingBootService if no bean Qualifier is provided
class PrimaryBeanGreetingBootService implements GreetingBootService {
    @Override
    public String sayGreeting() {
        return "Primary bean: Hello World!";
    }
}
