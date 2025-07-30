package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos){
        repository.save(new Medico(datos));
    }
    @GetMapping //agregar un nuevo registro a la bd
    public Page<DatosListaMedico> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion){     //nuestro repository que nos devuelve una lista de los medicos que hay en nuestra bd, convertimos esa lista de medicos en un stream para poder conseguir llamar un map,ese map convierte cada uno de los items a un DatosListaMedico que hicimos el constructor y luego reconvertimos esa lista en una lista propiamente dicha
        return repository.findAllByActivoTrue(paginacion)
                .map(DatosListaMedico::new);

    }
    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionMedico datos){
        var medico = repository.getReferenceById(datos.id());
        medico.actualizarInformaciones(datos);

    }
    @Transactional
    @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id){
            var medico = repository.getReferenceById(id);
            medico.eliminarInformacion();
        }
}
