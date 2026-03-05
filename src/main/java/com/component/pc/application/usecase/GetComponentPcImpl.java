package com.component.pc.application.usecase;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.ports.in.GetComponentPc;
import com.component.pc.application.ports.out.ComponentPcRepositoryPort;
import com.component.pc.domain.model.ComponentPc;
import com.component.pc.infrasctructure.adapters.ComponentPcMapper;

public class GetComponentPcImpl implements GetComponentPc {
    private final ComponentPcRepositoryPort componentPcRepositoryPort;
    private final ComponentPcMapper componentPcMapper;

    public GetComponentPcImpl(ComponentPcRepositoryPort componentPcRepositoryPort, ComponentPcMapper componentPcMapper) {
        this.componentPcRepositoryPort = componentPcRepositoryPort;
        this.componentPcMapper = componentPcMapper;
    }

    public ComponentPcRepositoryPort getComponentPcRepositoryPort() {
        return componentPcRepositoryPort;
    }

    public ComponentPcMapper getComponentPcMapper() {
        return componentPcMapper;
    }

    @Override
    public ComponentResponse get(Long id) {
        ComponentPc componentPc = componentPcRepositoryPort.findById(id).orElseThrow(()-> new RuntimeException("Component not found"));
        return componentPcMapper.toResponse(componentPc);
    }
}
