package com.app.crud.controller;


import com.app.crud.entity.Estudiante;
import com.app.crud.entity.Ficha;
import com.app.crud.service.ficha.FichaCrudImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/ficha")
@Controller
public class FichaController {

    @Autowired
    private FichaCrudImp service;

    @GetMapping("/todos")
    public String obtenerTodo(Model model){
        model.addAttribute("fichas", service.obtenerTodo());
        return "ficha";
    }

    @GetMapping("/guardar")
    public String formularioDeRegistro(Model model){
        Ficha ficha = new Ficha();
        model.addAttribute("ficha", ficha);
        return "registroFicha";
    }

    @PostMapping("/guardar")
    public String guardarFicha(@ModelAttribute("ficha") Ficha ficha, RedirectAttributes re){
        service.registrar(ficha);
        re.addFlashAttribute("msgExito", "Ficha registrada con exito");
        return "redirect:/ficha/todos";
    }



}
