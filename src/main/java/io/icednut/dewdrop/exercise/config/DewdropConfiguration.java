package io.icednut.dewdrop.exercise.config;

import events.dewdrop.Dewdrop;
import events.dewdrop.config.DewdropProperties;
import events.dewdrop.config.DewdropSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DewdropConfiguration {

    @Bean
    public DewdropProperties dewdropProperties() {
        return DewdropProperties.builder()
                .packageToScan("io.icednut.dewdrop.exercise")
                .connectionString("esdb://localhost:2113?tls=false")
                .create();
    }

    @Bean
    public Dewdrop dewdrop(DewdropProperties dewdropProperties, DewdropDependencyInjection dependencyInjectionAdapter) {
        return DewdropSettings.builder()
                .properties(dewdropProperties)
                .dependencyInjectionAdapter(dependencyInjectionAdapter)
                .create()
                .start();
    }
}
