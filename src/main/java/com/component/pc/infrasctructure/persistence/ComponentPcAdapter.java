package com.component.pc.infrasctructure.persistence;

import com.component.pc.application.ports.out.ComponentPcRepositoryPort;
import com.component.pc.domain.model.ComponentPc;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class ComponentPcAdapter implements ComponentPcRepositoryPort {

    public final ComponentPcJpaRepository componentPcJpaRepository;
    public final ComponentPcMapperJpa componentPcMapperJpa;

    public ComponentPcAdapter(ComponentPcJpaRepository componentPcJpaRepository, ComponentPcMapperJpa componentPcMapperJpa) {
        this.componentPcJpaRepository = componentPcJpaRepository;
        this.componentPcMapperJpa = componentPcMapperJpa;
    }

    @Override
    public ComponentPc save(ComponentPc componentPc) {
        ComponentPcEntity entity = componentPcMapperJpa.toEntity(componentPc);
        ComponentPcEntity savedEntity = componentPcJpaRepository.save(entity);
        return componentPcMapperJpa.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        componentPcJpaRepository.deleteById(id);
    }

    @Override
    public Optional<ComponentPc> findById(Long id) {
        return componentPcJpaRepository.findById(id).map(componentPcMapperJpa::toDomain);
    }

    @Override
    public List<ComponentPc> findAll() {
        return componentPcJpaRepository.findAll()
                .stream()
                .map(componentPcMapperJpa::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return componentPcJpaRepository.existsById(id);
    }
}
