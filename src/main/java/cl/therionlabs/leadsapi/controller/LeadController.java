package cl.therionlabs.leadsapi.controller;

import cl.therionlabs.leadsapi.dto.LeadRequest;
import cl.therionlabs.leadsapi.model.Lead;
import cl.therionlabs.leadsapi.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/leads")
public class LeadController {
    
    private final LeadService servicio;

    public LeadController(LeadService service) {
        this.servicio = service;
    }

    @PostMapping
    public ResponseEntity<Void> recibir(@Valid @RequestBody LeadRequest solicitud ) {
        boolean esNuevo = servicio.registrar(solicitud);
        return esNuevo  ? ResponseEntity.status(201).build()
                        : ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Lead> listar() {
        return servicio.listar();
    }
}
