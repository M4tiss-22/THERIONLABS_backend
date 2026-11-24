package cl.therionlabs.leadsapi.service;

import cl.therionlabs.leadsapi.dto.LeadRequest;
import cl.therionlabs.leadsapi.model.Lead;
import cl.therionlabs.leadsapi.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class LeadService {
    
    private final LeadRepository repositorio;

    public LeadService(LeadRepository repositorio) {
        this.repositorio = repositorio;
    }

    public boolean registrar(LeadRequest r) {
        if (repositorio.existsByIdLocalAndFechaCaptura(r.idLocal(), r.fechaCaptura())) {
            return false;
        }

        Lead lead = new Lead();
        lead.setIdLocal(r.idLocal());
        lead.setNombre(r.nombre().trim());
        lead.setEmail(r.email().trim());
        lead.setTelefono(r.telefono());
        lead.setNivelEducacion(r.nivelEducacion());
        lead.setCursoInteres(r.cursoInteres());
        lead.setModalidad(r.modalidad());
        lead.setCanalContacto(r.canalContacto());
        lead.setObservaciones(r.observaciones());
        lead.setFechaCaptura(r.fechaCaptura());

        repositorio.save(lead);
        return true;
    }
    
    public List<Lead> listar() {
        return repositorio.findAll();
    }
}
