package com.stores.proyecto.springstoresmsi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.stores.proyecto.springstoresmsi.dtos.StoreDto;
import com.stores.proyecto.springstoresmsi.entities.Store;
import com.stores.proyecto.springstoresmsi.services.StoreService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    @Autowired
    private StoreService service;

	@GetMapping
	public List<Store> list() {
		return service.findAll();

 }

   @GetMapping("/{id}")
	public Store show(@PathVariable Long id) {
		return service.findById(id).get();
	}

    @PostMapping
	public ResponseEntity<Store>create (@RequestBody Store store) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(store));
	} 

	@PostMapping("/{id}/msi")
	public String setMSI(@PathVariable Long id, @RequestBody StoreDto storeDto) throws Exception {
		service.updateMSIStore(id, storeDto.getMsiId());
		return "Actualizado con éxito";
	}

	@PutMapping("/{id}/msi")
	public String activateMSI(@PathVariable long id, @RequestBody StoreDto storeDto) {
		service.activateMSI(id, storeDto.isActivate());
		return "Actualizado con éxito";
	}
}