package io.github.zforgo.guides.aop;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    @Logged
    public String greet(String name) {
        return "Hello " + name;
    }
}
