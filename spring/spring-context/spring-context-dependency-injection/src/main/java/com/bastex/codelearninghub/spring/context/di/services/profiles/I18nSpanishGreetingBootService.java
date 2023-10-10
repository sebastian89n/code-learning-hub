package com.bastex.codelearninghub.spring.context.di.services.profiles;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18nService")
public class I18nSpanishGreetingBootService implements GreetingBootService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo! - ES profile";
    }
}
