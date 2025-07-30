package challenge.forohub.api.controller;

import challenge.forohub.api.domain.ValidacionException;
import challenge.forohub.api.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;


    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listarTopicos(
            @RequestParam(required = false) Curso curso,
            @RequestParam(required = false) Integer anio,
            @PageableDefault(size = 10, sort = {"fechaCreacion"}, direction = Sort.Direction.ASC) Pageable paginacion)
    {
        var page = repository.buscarConFiltros(curso, anio, paginacion).map(DatosListaTopico::new);
        return ResponseEntity.ok(page);
    }


    @GetMapping("/{id}")
    public ResponseEntity detalleTopico(@PathVariable Long id)
    {
        if(id == null || id <= 0){
            throw new ValidacionException("Obligatorio: Ingresa un ID para detallar un topico");
        }

        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }


    @Transactional
    @PostMapping
    public ResponseEntity registrarTopico (@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder)
    {
        var existeTopicoPorTituloYMensaje =  repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if(existeTopicoPorTituloYMensaje){
            throw new ValidacionException("Ya existe un topico con el mismo titulo y mensaje");
        }

        var topico = new Topico(datos);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizarTopico (@RequestBody @Valid DatosActualizacionTopico datos)
    {
        var existeTopico = repository.existsById(datos.id());
        if(!existeTopico){
            throw new ValidacionException("No existe el ID del topico a actualizar");
        }

        var topico = repository.getReferenceById(datos.id());
        topico.actualizarInformacion(datos);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico (@PathVariable Long id)
    {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
