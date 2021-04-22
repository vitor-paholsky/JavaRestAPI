package com.vitorduarte.OrangeTalentsAPI.controller;

import com.vitorduarte.OrangeTalentsAPI.entities.Address;
import com.vitorduarte.OrangeTalentsAPI.repository.AddressRepository;
import com.vitorduarte.OrangeTalentsAPI.entities.Usuario;
import com.vitorduarte.OrangeTalentsAPI.integration.ViaCepApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressController {

    private ViaCepApi viaCepApi;
    private AddressRepository addressRepository;

    public AddressController(ViaCepApi viaCepApi, AddressRepository addressRepository) {
        this.viaCepApi = viaCepApi;
        this.addressRepository = addressRepository;
    }

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public Address create(@RequestBody @Valid AddressRequest address) {
        Address viaAddress = this.viaCepApi.getAddress(address.getCep());
        viaAddress.setComplemento(address.getComplemento());
        viaAddress.setNumero(address.getNumero());
        viaAddress.setUsuario(Usuario.of(address.getUserId()));

        return addressRepository.save(viaAddress);
    }

    @GetMapping("/address/{cep}")
    public Address getAddress(@PathVariable("cep") String cep) {
        return this.viaCepApi.getAddress(cep);
    }


}
