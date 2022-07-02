package com.backend.restempresa.controllers;

import com.backend.restempresa.dtos.EmpresaDto;
import com.backend.restempresa.dtos.MensajeDto;
import com.backend.restempresa.models.Empresa;
import com.backend.restempresa.services.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;

/**
 * The type Empresa controller.
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/rest/v1/empresa"})
public class EmpresaController {

    @Resource
    private EmpresaService service;

    /**
     * Registrar Empresa.
     *
     * @param empresaDto the empresa dto
     * @return the response entity
     */
    @PostMapping("/registrar")
    public ResponseEntity<MensajeDto> registrar(@RequestBody EmpresaDto empresaDto){
        //valida campos no nulos
        if(StringUtils.isBlank(empresaDto.getNombre()) || StringUtils.isBlank(empresaDto.getNumeroNit()) || StringUtils.isBlank(empresaDto.getDireccion())) {
            return new ResponseEntity(new MensajeDto("Todos los campos son Obligatorios"), HttpStatus.BAD_REQUEST);
        }

        //validar que no exista el nit o el nombre a registrar
        if(service.existsByNit(empresaDto.getNumeroNit()) || service.existsByNombre(empresaDto.getNombre())){
            return new ResponseEntity(new MensajeDto("La empresa que intenta registrar ya existe, revise el nombre y su NIT nuevamente."), HttpStatus.BAD_REQUEST);
        }

        //validar longitud de NIT
        if(empresaDto.getNumeroNit().length()>8){
            return new ResponseEntity(new MensajeDto("El NIT de la empresa no puede tener una longitud mayor a 8 digitos."), HttpStatus.BAD_REQUEST);
        }

        //validar longitud de Nombre
        if(empresaDto.getNombre().length()>150){
            return new ResponseEntity(new MensajeDto("El Nombre de la empresa no puede tener una longitud mayor a 150 caracteres."), HttpStatus.BAD_REQUEST);
        }

        //validar longitud de Direccion
        if(empresaDto.getDireccion().length()>150){
            return new ResponseEntity(new MensajeDto("La Direccion de la empresa no puede tener una longitud mayor a 150 caracteres."), HttpStatus.BAD_REQUEST);
        }

        //registrar empresa
        Empresa empresa = new Empresa(
                empresaDto.getNombre(),
                empresaDto.getNumeroNit(),
                empresaDto.getFechaFundacion(),
                empresaDto.getDireccion());
        service.save(empresa);
        return new ResponseEntity(new MensajeDto("La empresa "+empresaDto.getNombre()+" se registro exitosamente"), HttpStatus.OK);

    }

    /**
     * Actualizar Empresa
     *
     * @param id         the id
     * @param empresaDto the empresa dto
     * @return the response entity
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<MensajeDto> actualizar(@PathVariable("id") int id, @RequestBody EmpresaDto empresaDto){

        //evalua si existe la empresa
        if(!service.existsById(id)){
            return new ResponseEntity(new MensajeDto("La empresa con ID "+id+" No existe"), HttpStatus.NOT_FOUND);
        }

        //valida campos no nulos
        if(StringUtils.isBlank(empresaDto.getNombre()) || StringUtils.isBlank(empresaDto.getNumeroNit()) || StringUtils.isBlank(empresaDto.getDireccion())) {
            return new ResponseEntity(new MensajeDto("Todos los campos son Obligatorios"), HttpStatus.BAD_REQUEST);
        }

        //validar longitud de NIT
        if(empresaDto.getNumeroNit().length()>8){
            return new ResponseEntity(new MensajeDto("El NIT de la empresa no puede tener una longitud mayor a 8 digitos."), HttpStatus.BAD_REQUEST);
        }

        //validar longitud de Nombre
        if(empresaDto.getNombre().length()>150){
            return new ResponseEntity(new MensajeDto("El Nombre de la empresa no puede tener una longitud mayor a 150 caracteres."), HttpStatus.BAD_REQUEST);
        }

        //validar longitud de Direccion
        if(empresaDto.getDireccion().length()>150){
            return new ResponseEntity(new MensajeDto("La Direccion de la empresa no puede tener una longitud mayor a 150 caracteres."), HttpStatus.BAD_REQUEST);
        }

        //validar que no exista el nit o el nombre a actualizar
        if(service.existsByNit(empresaDto.getNumeroNit()) || service.existsByNombre(empresaDto.getNombre())){
            return new ResponseEntity(new MensajeDto("Los nuevos datos para la empresa ya existe, revise el nombre y su NIT nuevamente."), HttpStatus.BAD_REQUEST);
        }
        //actualizar empresa
        Empresa empresa = service.getOne(id).get();
        empresa.setNombre(empresaDto.getNombre());
        empresa.setNumeroNit(empresaDto.getNumeroNit());
        empresa.setFechaFundacion(empresaDto.getFechaFundacion());
        empresa.setDireccion(empresaDto.getDireccion());

        service.save(empresa);
        return new ResponseEntity(new MensajeDto("La empresa con ID "+id+" se actualizo exitosamente"), HttpStatus.OK);

    }

    /**
     * Eliminar Empresa
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeDto> eliminar(@PathVariable("id") int id){
        //comprobamos que exista
        if(!service.existsById(id))
            return new ResponseEntity(new MensajeDto("No existe la empresa que se desea eliminar"), HttpStatus.NOT_FOUND);
        service.delete(id);
        return new ResponseEntity(new MensajeDto("La empresa con ID "+id+" se elimino correctamente !!!"), HttpStatus.OK);
    }

    /**
     * Buscar empresa id.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/buscarEmpresaID/{id}")
    public ResponseEntity<Empresa> buscarEmpresaID(@PathVariable("id") int id){
        //evaluamos si existe
        if(!service.existsById(id))
            return new ResponseEntity(new MensajeDto("No existe la empresa con ID "+id), HttpStatus.NOT_FOUND);
        Empresa empresa = service.getOne(id).get();
        return new ResponseEntity(empresa, HttpStatus.OK);
    }

    /**
     * Buscar empresa nombre.
     *
     * @param nombre the nombre
     * @return the response entity
     */
    @GetMapping("/buscarEmpresaNombre/{nombre}")
    public ResponseEntity<Empresa> buscarEmpresaNombre(@PathVariable("nombre") String nombre){
        //evaluamos si existe
        if(!service.existsByNombre(nombre))
            return new ResponseEntity(new MensajeDto("No existe la empresa con Nombre "+nombre), HttpStatus.NOT_FOUND);
        Empresa empresa = service.getByNombre(nombre).get();
        return new ResponseEntity(empresa, HttpStatus.OK);
    }

    /**
     * Buscar empresa nit.
     *
     * @param nit the nit
     * @return the response entity
     */
    @GetMapping("/buscarEmpresaNit/{nit}")
    public ResponseEntity<Empresa> buscarEmpresaNit(@PathVariable("nit") String nit){
        //evaluamos si existe
        if(!service.existsByNit(nit))
            return new ResponseEntity(new MensajeDto("No existe la empresa con Numero de NIT "+nit), HttpStatus.NOT_FOUND);
        Empresa empresa = service.getByNumeroNit(nit).get();
        return new ResponseEntity(empresa, HttpStatus.OK);
    }

}
