package com.app.crud.controller;

import com.app.crud.entity.Estudiante;
import com.app.crud.service.EstudianteCrudImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesController {

    @Autowired
    private EstudianteCrudImp servicio;

    @GetMapping("/todos")
    public String verTodosLosEstudiantes(Model modelo){
        modelo.addAttribute("estudiantes", servicio.obtenerTodo());
        return "estudiantes";
    }

    @GetMapping("/nuevo")
    public String formularioDeRegistro(Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "registroEstudiante";
    }

    @GetMapping("/editar/{id}")
    public String formularioDeEditar(@PathVariable Long id, Model model){
        model.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
        return "editarEstudiante";
    }

    @PostMapping("/nuevo")
    public String registrarEstudiante(@ModelAttribute("estudiante")Estudiante estudiante, RedirectAttributes re){
        servicio.registrar(estudiante);
        re.addFlashAttribute("msgExito","Registro exitoso");
        return "redirect:/estudiantes/todos";
    }

    @PostMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model model,
                                   RedirectAttributes re){
        Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEdad(estudiante.getEdad());
        estudianteExistente.setDocumento(estudiante.getDocumento());
        estudianteExistente.setFicha(estudiante.getFicha());
        servicio.actualizar(estudianteExistente);
        re.addFlashAttribute("msgExito", "Registro actualizado con exito");
        return "redirect:/estudiantes/todos";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id, RedirectAttributes re){
        servicio.delete(id);
        re.addFlashAttribute("msgExito", "Registro eliminado con exito");
        return "redirect:/estudiantes/todos";
    }



}
