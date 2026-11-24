package cl.therionlabs.leadsapi.repository;

import cl.therionlabs.leadsapi.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository  extends JpaRepository<Lead, Long> {
    boolean existsByIdLocalAndFechaCaptura(Long idLocal, Long  fechaCaptura);
}
