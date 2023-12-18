package com.fernando.camara_dos_deputados_lp3.controllers;

import com.fernando.camara_dos_deputados_lp3.dtos.DeputadoAdicionarEvento;
import com.fernando.camara_dos_deputados_lp3.dtos.EventoInfoDTO;
import com.fernando.camara_dos_deputados_lp3.entities.Deputado;
import com.fernando.camara_dos_deputados_lp3.entities.Evento;
import com.fernando.camara_dos_deputados_lp3.projections.EventoNomeIDProjection;
import com.fernando.camara_dos_deputados_lp3.services.DeputadoService;
import com.fernando.camara_dos_deputados_lp3.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/deputados")
public class DeputadoController {
    @Autowired
    private DeputadoService deputadoService;

    @Autowired
    private EventoService eventoService;

    @GetMapping("/{id}")
    public ModelAndView info(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("deputado/info");
        Deputado deputado = deputadoService.findByID(id);
        modelAndView.addObject("deputado", deputado);

        return modelAndView;
    }

    @GetMapping("/{id}/eventos")
    public ModelAndView eventos(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("deputado/eventos");
        List<EventoInfoDTO> eventos = deputadoService.findEventos(id);
        Deputado deputado = deputadoService.findByID(id);
        modelAndView.addObject("eventos", eventos);
        modelAndView.addObject("deputado", deputado);

        return modelAndView;
    }

    @PostMapping("/{id}/eventos")
    public String insertEvento(@PathVariable Long id, DeputadoAdicionarEvento deputadoAdicionarEvento) {
        System.out.println(deputadoAdicionarEvento.getEventoID() + " " + id);
        Long eventoID = deputadoAdicionarEvento.getEventoID();
        deputadoService.insertEvento(id, eventoID);
 
        return "redirect:/deputados/" + id + "/eventos";
    }

    @GetMapping("/{id}/eventos/new")
    public ModelAndView formEvento(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("deputado/form-evento");
        List<EventoNomeIDProjection> eventos = eventoService.findAllNomeAndId();
        Deputado deputado = deputadoService.findByID(id);

        DeputadoAdicionarEvento deputadoAdicionarEvento = new DeputadoAdicionarEvento(null);

        modelAndView.addObject("eventos", eventos);
        modelAndView.addObject("deputado", deputado);
        modelAndView.addObject("deputadoAdicionarEvento", deputadoAdicionarEvento);

        return modelAndView;
    }

    @GetMapping("/{deputadoID}/eventos/{eventoID}/delete")
    public ModelAndView confirmDeleteEvento(
        @PathVariable Long deputadoID,
        @PathVariable Long eventoID) {
        ModelAndView modelAndView = new ModelAndView("deputado/confirm-delete-evento");
        EventoInfoDTO evento = deputadoService.findEventoById(deputadoID, eventoID);
        Deputado deputado = deputadoService.findByID(deputadoID);
       
        
        modelAndView.addObject("evento", evento);
        modelAndView.addObject("deputado", deputado);

        return modelAndView;
    }

    @DeleteMapping("/{deputadoID}/eventos/{eventoID}/delete")
    public String deleteEvento(EventoInfoDTO eventoInfoDTO) {
        Long deputadoID = eventoInfoDTO.getDeputadoID();
        Long eventoID = eventoInfoDTO.getId();

        deputadoService.deleteEvento(deputadoID, eventoID);
        return "redirect:/deputados/" + deputadoID + "/eventos";
    }


    


}