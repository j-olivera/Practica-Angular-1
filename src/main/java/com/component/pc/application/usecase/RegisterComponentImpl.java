package com.component.pc.application.usecase;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.dto.SaveComponentCommand;
import com.component.pc.application.ports.in.CreateComponentPc;
import com.component.pc.application.ports.out.ComponentPcRepositoryPort;
import com.component.pc.domain.model.ComponentPc;
import com.component.pc.infrasctructure.adapters.ComponentPcMapper;

public class RegisterComponentImpl implements CreateComponentPc {

    private final ComponentPcRepositoryPort componentPcRepositoryPort;
    private final ComponentPcMapper componentPcMapper;

    public RegisterComponentImpl(ComponentPcRepositoryPort componentPcRepositoryPort, ComponentPcMapper componentPcMapper) {
        this.componentPcRepositoryPort = componentPcRepositoryPort;
        this.componentPcMapper = componentPcMapper;
    }

    @Override
    public ComponentResponse save(SaveComponentCommand command) {
        command.validate();
        ComponentPc component1 = componentPcMapper.toDomain(command);
        ComponentPc component2 = componentPcRepositoryPort.save(component1);
        return componentPcMapper.toResponse(component2);
    }
}
