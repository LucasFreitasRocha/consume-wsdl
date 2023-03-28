package com.consume.wsdl.service;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultCepService {

    @Autowired
    private AtendeCliente atendeCliente;
    public EnderecoERP consult(String cep){
        try {
           return atendeCliente.consultaCEP(cep);
        } catch (SQLException_Exception e) {
            throw new RuntimeException(e);
        } catch (SigepClienteException e) {
            throw new RuntimeException(e);
        }
    }
}
