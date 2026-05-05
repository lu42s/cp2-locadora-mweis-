package br.fiap.cp1.locadora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    @GetMapping
    public String catalogo() {
        return "como perder um homem em 10 dias - como eu era antes de você - um lugar chamado notting hill";
    }

    @GetMapping("/filme")
    public String filme(){
        return "como perder um homem em 10 dias";
    }
}

