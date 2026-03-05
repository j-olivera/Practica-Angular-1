package com.component.pc.infrasctructure.config;

import com.component.pc.application.ports.in.ComponentExistById;
import com.component.pc.application.ports.in.CreateComponentPc;
import com.component.pc.application.ports.in.DeleteComponentPc;
import com.component.pc.application.ports.in.GetComponentPc;
import com.component.pc.application.ports.out.ComponentPcRepositoryPort;
import com.component.pc.application.usecase.ComponentExistByIdImpl;
import com.component.pc.application.usecase.DeleteComponentPcImpl;
import com.component.pc.application.usecase.GetComponentPcImpl;
import com.component.pc.application.usecase.RegisterComponentImpl;
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
}
