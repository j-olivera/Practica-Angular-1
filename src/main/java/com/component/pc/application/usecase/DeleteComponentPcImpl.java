package com.component.pc.application.usecase;

import com.component.pc.application.ports.in.DeleteComponentPc;
import com.component.pc.application.ports.out.ComponentPcRepositoryPort;

public class DeleteComponentPcImpl implements DeleteComponentPc {

    private final ComponentPcRepositoryPort componentPcRepositoryPort;

    public DeleteComponentPcImpl(ComponentPcRepositoryPort componentPcRepositoryPort) {
        this.componentPcRepositoryPort = componentPcRepositoryPort;
    }

    @Override
    public void delete(Long id) {
        componentPcRepositoryPort.deleteById(id);
    }
}
