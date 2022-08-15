package io.icednut.dewdrop.exercise.config;

import events.dewdrop.config.DependencyInjectionAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DewdropDependencyInjection implements DependencyInjectionAdapter {

    private ApplicationContext applicationContext;

    public DewdropDependencyInjection(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <T> T getBean(Class<?> clazz) {
        return (T) applicationContext.getBean(clazz);
    }
}
