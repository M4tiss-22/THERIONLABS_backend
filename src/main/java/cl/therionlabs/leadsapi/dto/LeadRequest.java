package cl.therionlabs.leadsapi.dto;

import jakarta.validation.constraints.*;

public record LeadRequest(
        @NotNull Long idLocal,
        @NotBlank @Size(min = 3) String nombre,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "^[0-9]{9}$") String telefono,
        String nivelEducacion,
        String cursoInteres,
        String modalidad,
        String canalContacto,
        String observaciones,
        @NotNull Long fechaCaptura
) {}