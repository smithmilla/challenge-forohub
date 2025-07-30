package challenge.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Curso curso
) {
}
