package com.component.pc.interfaces;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.dto.SaveComponentCommand;
import com.component.pc.application.ports.in.ComponentExistById;
import com.component.pc.application.ports.in.CreateComponentPc;
import com.component.pc.application.ports.in.DeleteComponentPc;
import com.component.pc.application.ports.in.GetComponentPc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/components")
public class ComponentPcController {
    private final CreateComponentPc createComponentPc;
    private final DeleteComponentPc deleteComponentPc;
    private final GetComponentPc getComponentPc;
    private final ComponentExistById componentExistById;

    public ComponentPcController(CreateComponentPc createComponentPc, DeleteComponentPc deleteComponentPc, GetComponentPc getComponentPc, ComponentExistById componentExistById) {
        this.createComponentPc = createComponentPc;
        this.deleteComponentPc = deleteComponentPc;
        this.getComponentPc = getComponentPc;
        this.componentExistById = componentExistById;
    }

    @PostMapping
    public ResponseEntity<ComponentResponse> register(@RequestBody SaveComponentCommand  saveComponentCommand) {
        ComponentResponse response = createComponentPc.save(saveComponentCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ComponentResponse> getComponentById(@PathVariable Long id) {
       ComponentResponse response = getComponentPc.get(id);
       return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComponentById(@PathVariable Long id) {
        deleteComponentPc.delete(id);
        return ResponseEntity.ok("Deleted");
    }

}
