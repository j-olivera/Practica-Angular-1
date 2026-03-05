package com.component.pc.infrasctructure.persistence;

import com.component.pc.domain.model.ComponentPc;
import org.springframework.stereotype.Component;

@Component
public class ComponentPcMapperJpa {
    public ComponentPc toDomain(ComponentPcEntity entity){
        return ComponentPc.reconstruir(
                entity.getId(),
                entity.getPiece_name(),
                entity.getMarca(),
                entity.getPrice()
        );
    }
    public ComponentPcEntity toEntity(ComponentPc domain){
        return new ComponentPcEntity(
                domain.getId(),
                domain.getPiece_name(),
                domain.getMarca(),
                domain.getPrice()
        );
    }
}
