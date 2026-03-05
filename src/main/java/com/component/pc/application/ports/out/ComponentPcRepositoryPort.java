package com.component.pc.application.ports.out;

import com.component.pc.domain.model.ComponentPc;

import java.util.List;
import java.util.Optional;

public interface ComponentPcRepositoryPort {
    ComponentPc save(ComponentPc componentPc);
    void deleteById(Long id);
    Optional<ComponentPc> findById(Long id);
    List<ComponentPc> findAll();
    boolean existsById(Long id);
}
