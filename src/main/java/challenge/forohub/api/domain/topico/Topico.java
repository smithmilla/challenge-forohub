package challenge.forohub.api.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    private String status;
    private long autor; //Usuario -> IdUsuario

    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DatosRegistroTopico datos)
    {
        this.id = null;
        this.autor = datos.autor();
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.curso = datos.curso();
        this.fechaCreacion = LocalDateTime.now();
        this.status = "REGISTRADO";
    }

    public void actualizarInformacion(@Valid DatosActualizacionTopico datos)
    {
        if(datos.titulo() != null){
            this.titulo = datos.titulo();
        }

        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }

        if(datos.curso() != null){
            this.curso = datos.curso();
        }
    }

}
