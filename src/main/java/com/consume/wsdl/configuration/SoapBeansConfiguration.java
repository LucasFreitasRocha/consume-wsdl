package com.consume.wsdl.configuration;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.xml.ws.BindingProvider;

@Configuration
public class SoapBeansConfiguration {



    @Bean
    @Scope("singleton")
    public AtendeCliente getConnectionAtendeCliente(){
        AtendeClienteService atendeClienteService = new AtendeClienteService();
        AtendeCliente soap = atendeClienteService.getAtendeClientePort();
        BindingProvider bp = (BindingProvider) soap;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente");
        return soap;
    }
}
