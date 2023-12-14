package com.fernando.camara_dos_deputados_lp3.controllers;

import com.fernando.camara_dos_deputados_lp3.entities.Deputado;
import com.fernando.camara_dos_deputados_lp3.services.DeputadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private DeputadoService deputadoService;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Deputado> deputados = deputadoService.findAll();

        modelAndView.addObject("deputados", deputados);

        return modelAndView;
    }
}