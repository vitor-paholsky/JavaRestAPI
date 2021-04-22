package com.vitorduarte.OrangeTalentsAPI.integration;

import com.vitorduarte.OrangeTalentsAPI.entities.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepApi {
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json", produces = "application/json")
    Address getAddress(@PathVariable("cep") String cep);
}
