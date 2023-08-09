package com.uniamerica.estatisticas.controller;

import com.uniamerica.estatisticas.entity.Estatistica;
import com.uniamerica.estatisticas.service.EstatisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estatisticas")
public class EstatisticasController {

    @Autowired
    private EstatisticasService estatisticasService;
    @PostMapping
    public ResponseEntity<?> calcular(@RequestBody Estatistica valores){
        try{
            Estatistica estatistica = this.estatisticasService.calculaTodos(valores);
            return ResponseEntity.ok().body(estatistica);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
