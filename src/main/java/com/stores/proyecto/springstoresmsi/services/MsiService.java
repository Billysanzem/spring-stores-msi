package com.stores.proyecto.springstoresmsi.services;

import java.util.List;
import java.util.Optional;

import com.stores.proyecto.springstoresmsi.entities.Msi;


public interface MsiService {

    List<Msi> findAll();

    Optional<Msi> findById(Long id);

    Msi save(Msi msi);

}
