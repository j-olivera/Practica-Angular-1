package com.component.pc.infrasctructure.config;

import com.component.pc.application.ports.in.*;
import com.component.pc.application.ports.out.ComponentPcRepositoryPort;
import com.component.pc.application.usecase.*;
import com.component.pc.infrasctructure.adapters.ComponentPcMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    //mapper
    @Bean
    public ComponentPcMapper componentPcMapper() {
        return new ComponentPcMapper();
    }
    //use cases
    @Bean
    public ComponentExistById componentExistById(ComponentPcRepositoryPort componentPcRepositoryPort) {
        return new ComponentExistByIdImpl(componentPcRepositoryPort);
    }
    @Bean
    public DeleteComponentPc deleteComponentPc(ComponentPcRepositoryPort componentPcRepositoryPort) {
        return new DeleteComponentPcImpl(componentPcRepositoryPort);
    }
    @Bean
    public GetComponentPc getComponentPc(ComponentPcRepositoryPort componentPcRepositoryPort,ComponentPcMapper componentPcMapper) {
        return  new GetComponentPcImpl(componentPcRepositoryPort,componentPcMapper);
    }
    @Bean
    public CreateComponentPc createComponentPc(ComponentPcRepositoryPort componentPcRepositoryPort,ComponentPcMapper componentPcMapper) {
        return new RegisterComponentImpl(componentPcRepositoryPort,componentPcMapper);
    }
    @Bean
    public FindAllComponents  findAllComponents(ComponentPcRepositoryPort componentPcRepositoryPort,ComponentPcMapper componentPcMapper) {
        return new FindAllComponentsImpl(componentPcRepositoryPort,componentPcMapper);
    }
}
