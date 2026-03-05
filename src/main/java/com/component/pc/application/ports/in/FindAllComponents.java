package com.component.pc.application.ports.in;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.domain.model.ComponentPc;

import java.util.List;

public interface FindAllComponents {
    List<ComponentResponse> findAll();
}
