package challenge.forohub.api.domain.topico;

import java.time.LocalDateTime;

public record DatosListaTopico (
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        Long autor,
        Curso Curso
)
{
    public DatosListaTopico (Topico topico)
    {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
