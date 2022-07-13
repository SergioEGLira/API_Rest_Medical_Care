package com.sergio.eduardo.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sergio.eduardo.entities.Paciente;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepOpenFeignResource {

	@GetMapping("/{cep}/json")
	Paciente obterCep(@PathVariable("cep") String cep);
} 
