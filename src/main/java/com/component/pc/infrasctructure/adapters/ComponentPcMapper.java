package com.component.pc.infrasctructure.adapters;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.dto.SaveComponentCommand;
import com.component.pc.domain.model.ComponentPc;

import java.util.List;

public class ComponentPcMapper {
    public ComponentPc toDomain(SaveComponentCommand command) {
        return ComponentPc.createComponent(
                command.getPiece_name(),
                command.getMarca(),
                command.getPrice()
        );
    }

    public ComponentResponse toResponse(ComponentPc componentPc) {
        return new ComponentResponse(
                componentPc.getId(),
                componentPc.getPiece_name(),
                componentPc.getMarca(),
                componentPc.getPrice()
        );
    }
    public List<ComponentResponse> toResponseList(List<ComponentPc> componentPcs) {
        return componentPcs.stream().map(this::toResponse).toList();
    }
}
