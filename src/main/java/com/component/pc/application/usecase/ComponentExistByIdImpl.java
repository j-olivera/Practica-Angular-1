package com.component.pc.application.usecase;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.ports.in.ComponentExistById;
import com.component.pc.application.ports.out.ComponentPcRepositoryPort;
import com.component.pc.infrasctructure.adapters.ComponentPcMapper;

public class ComponentExistByIdImpl implements ComponentExistById {
    private final ComponentPcRepositoryPort componentPcRepositoryPort;

    public ComponentExistByIdImpl(ComponentPcRepositoryPort componentPcRepositoryPort) {
        this.componentPcRepositoryPort = componentPcRepositoryPort;

    }

    @Override
    public boolean componentExistById(Long id) {
        return componentPcRepositoryPort.existsById(id);
    }
}
