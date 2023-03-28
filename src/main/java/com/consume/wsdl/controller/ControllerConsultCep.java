package com.consume.wsdl.controller;


import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import com.consume.wsdl.service.ConsultCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consult")
public class ControllerConsultCep {

    @Autowired
    private ConsultCepService service;
    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoERP> consult(@PathVariable String cep){
        return ResponseEntity.ok(service.consult(cep));
    }
}
