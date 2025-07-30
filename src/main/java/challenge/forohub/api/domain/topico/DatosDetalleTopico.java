package challenge.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fechaCreacion,
    String status,
    Long autor,
    Curso curso
) {
    public DatosDetalleTopico(Topico topico)
    {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaCreacion(),
            topico.getStatus(),
            topico.getAutor(),
            topico.getCurso()
        );
    }
}
