package br.com.imc.api.controller;

import br.com.imc.domain.model.Imc;
import br.com.imc.domain.service.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imc")
public class ImcController {

    @Autowired
    private ImcService service;

    @GetMapping
    public Double imcCalc(@RequestBody Imc imc){
        return service.calculate(imc);
    }
    @GetMapping("/situation")
    public String imcSituation(@RequestBody Imc imc){
        return service.situation(imc);
    }
    @GetMapping("/diagnosis")
    public String imcDiagnosis(@RequestBody Imc imc){
        return service.diagnosis(imc);
    }


}
