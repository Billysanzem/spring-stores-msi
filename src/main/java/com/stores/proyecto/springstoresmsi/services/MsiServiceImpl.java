package com.stores.proyecto.springstoresmsi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.proyecto.springstoresmsi.entities.Msi;
import com.stores.proyecto.springstoresmsi.repositories.MsiRepository;

@Service
public class MsiServiceImpl implements MsiService{

    @Autowired
    private MsiRepository repositoryMsi;

    @Override
     @Transactional(readOnly = true)
    public List<Msi> findAll() {
        return (List<Msi>) repositoryMsi.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Msi> findById(Long id) {
        return repositoryMsi.findById(id);
    }

    @Override
    @Transactional
    public Msi save(Msi msi) {
        return repositoryMsi.save(msi);
    }

}
