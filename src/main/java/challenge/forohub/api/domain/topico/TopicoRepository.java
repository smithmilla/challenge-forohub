package challenge.forohub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long>
{
    @Query("""
        SELECT t FROM Topico t
        WHERE (:curso IS NULL OR t.curso = :curso)
          AND (:anio IS NULL OR YEAR(t.fechaCreacion) = :anio)
        """)
    Page<Topico> buscarConFiltros( @Param("curso") Curso curso, @Param("anio") Integer anio, Pageable pageable);

    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
