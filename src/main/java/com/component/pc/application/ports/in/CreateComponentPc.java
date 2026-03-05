package com.component.pc.application.ports.in;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.dto.SaveComponentCommand;

public interface CreateComponentPc {
    public ComponentResponse save(SaveComponentCommand command);
}
