package com.fernando.camara_dos_deputados_lp3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import com.fernando.camara_dos_deputados_lp3.services.EventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping("/{id}/update")
    public ModelAndView updateEventoForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("evento/update");
        Evento evento = eventoService.findByID(id);
        modelAndView.addObject("evento", evento);

        return modelAndView;
    }

    @PutMapping("/{id}/update")
    public String updateEvento(@PathVariable Long id, Evento evento) {
        eventoService.updateEvento(evento);
        return "redirect:/";
    }
}
