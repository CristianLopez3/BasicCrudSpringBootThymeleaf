package com.app.crud.controller;

import com.app.crud.entity.Estudiante;
import com.app.crud.entity.Ficha;
import com.app.crud.service.EstudianteCrudImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
@RequestMapping("/estudiantes")
public class EstudiantesController {

    /**
     * Llamamos el servicio que se encarga de retornarnos los valores que necestiamos para
     * poder enviarlos al modelo
     */

    @Autowired
    private EstudianteCrudImp servicio;

    @GetMapping("/todos")
    public String verTodosLosEstudiantes(Model modelo){
        modelo.addAttribute("estudiantes", servicio.obtenerTodo());
        return "estudiantes";
    }


    /**
     * controller que nos dirige al formulario de registro al cual le enviamos el objeto con el
     * cual vamos a trabajar en el formulario por medio del model.
     * @param model
     * @return
     */

    @GetMapping("/nuevo")
    public String formularioDeRegistro(Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "registroEstudiante";
    }

    /**
     * Controller que nos dirige al formulario para editar un estudiante, dicho formulario necesita
     * el id por medio del metodo get(url) para poder saber que estudiante va a ser editado, muy importante
     * tener cuidado con el RequestMapping del controller que en este caso es /estudiantes
     * @param id
     * @param model
     * @return
     */

    @GetMapping("/editar/{id}")
    public String formularioDeEditar(@PathVariable Long id, Model model){
        model.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
        return "editarEstudiante";
    }

    /**
     * Recibimos el atributo que nos envia el modelo del formualrio del regisdtro y con la clase redirectatribute
     * hacemos un flash message para saber que si se actualizo correctamente
     * @param estudiante
     * @param re
     * @return
     */

    @PostMapping("/nuevo")
    public String registrarEstudiante(@ModelAttribute("estudiante")Estudiante estudiante, RedirectAttributes re){
        servicio.registrar(estudiante);
        re.addFlashAttribute("msgExito","Registro exitoso");
        return "redirect:/estudiantes/todos";
    }


    /**
     * Recibimos la variable por metodo get y el atributo que nos envia el modelo para poder actualizarlo en la base de datos
     * @param id
     * @param estudiante
     * @param model
     * @param re
     * @return
     */
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


    /**
     * Recibimos el path de la variable y se lo enviamos al metodo para eliminarlo
     * @param id
     * @param re
     * @return
     */

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id, RedirectAttributes re){
        servicio.delete(id);
        re.addFlashAttribute("msgExito", "Registro eliminado con exito");
        return "redirect:/estudiantes/todos";
    }


    /**
     * Tomamos el numero de ficha el cual pasamos a nuestro servicio y este a la vez se lo pasa
     * a la fichaRepository para hallar la ficha y de tal forma hallar la ficha y poder
     * retornarla, esto se accedera desde la interfaz no por metodo get si no sencillamente por atributo
     * por ejemplo:
     * ${ficha.id}
     * ${ficha.numero}
     * ${ficha.programa}
     * @param numero
     * @param model
     * @return
     */
    @GetMapping("/estudiante/ficha/{numero}")
    public String verFicha(@PathVariable String numero, Model model){
        model.addAttribute("ficha", servicio.obtenerFichaPorNumero(numero));
        return "fichaSeleccionada";
    }



}
