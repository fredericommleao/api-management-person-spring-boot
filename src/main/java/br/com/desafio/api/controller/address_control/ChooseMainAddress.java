/**
 * Controlador responsável por gerenciar o endereço principal de uma pessoa.
 */

package br.com.desafio.api.controller.address_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.api.service.address_impl.AddMainAddressService;



@RestController
public class ChooseMainAddress {
	 
	 @Autowired
	 private AddMainAddressService Impl;
	 
	 /*
	  * Método que marca um endereço específico como principal para uma pessoa.
	  * */
	
	 @PutMapping("/person/{id}/address/{addressId}/primary")
	    public void primaryAddress(@PathVariable Long id, @PathVariable Long addressId) {
		 //
		 Impl.mainAddress(id, addressId);
	    }

}
