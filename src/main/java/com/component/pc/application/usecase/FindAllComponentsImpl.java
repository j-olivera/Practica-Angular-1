package com.component.pc.application.usecase;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.ports.in.FindAllComponents;
import com.component.pc.application.ports.out.ComponentPcRepositoryPort;
import com.component.pc.domain.model.ComponentPc;
import com.component.pc.infrasctructure.adapters.ComponentPcMapper;

import java.util.ArrayList;
import java.util.List;

public class FindAllComponentsImpl implements FindAllComponents {
    private final ComponentPcRepositoryPort componentPcRepositoryPort;
    private final ComponentPcMapper componentPcMapper;

    public FindAllComponentsImpl(ComponentPcRepositoryPort componentPcRepositoryPort, ComponentPcMapper componentPcMapper) {
        this.componentPcRepositoryPort = componentPcRepositoryPort;
        this.componentPcMapper = componentPcMapper;
    }

    @Override
    public List<ComponentResponse> findAll() {
        List<ComponentPc> components= componentPcRepositoryPort.findAll();
        return componentPcMapper.toResponseList(components);
    }
}
