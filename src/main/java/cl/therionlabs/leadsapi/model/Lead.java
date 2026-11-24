package cl.therionlabs.leadsapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity 
@Table (name = "leads")
public class Lead {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idLocal;
    private String nombre;
    private String email;
    private String telefono;
    private String nivelEducacion;
    private String cursoInteres;
    private String modalidad;
    private String canalContacto;

    @Column(length = 1000)
    private String observaciones;

    private Long fechaCaptura;
}