package com.component.pc.interfaces;

import com.component.pc.application.dto.ComponentResponse;
import com.component.pc.application.dto.SaveComponentCommand;
import com.component.pc.application.ports.in.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/components")
@CrossOrigin(origins = "http://localhost:4200")
public class ComponentPcController {
    private final CreateComponentPc createComponentPc;
    private final DeleteComponentPc deleteComponentPc;
    private final GetComponentPc getComponentPc;
    private final ComponentExistById componentExistById;
    private final FindAllComponents findAllComponents;
    public ComponentPcController(CreateComponentPc createComponentPc, DeleteComponentPc deleteComponentPc, GetComponentPc getComponentPc, ComponentExistById componentExistById,  FindAllComponents findAllComponents) {
        this.createComponentPc = createComponentPc;
        this.deleteComponentPc = deleteComponentPc;
        this.getComponentPc = getComponentPc;
        this.componentExistById = componentExistById;
        this.findAllComponents = findAllComponents;
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
    @GetMapping
    public ResponseEntity<List<ComponentResponse>> getAllComponents() {
        List<ComponentResponse> responses = findAllComponents.findAll();
        return ResponseEntity.ok(responses);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComponentById(@PathVariable Long id) {
        deleteComponentPc.delete(id);
        return ResponseEntity.ok("Deleted");
    }

}
