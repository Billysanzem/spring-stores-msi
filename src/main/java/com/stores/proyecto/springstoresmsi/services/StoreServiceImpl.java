package com.stores.proyecto.springstoresmsi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.proyecto.springstoresmsi.entities.Msi;
import com.stores.proyecto.springstoresmsi.entities.Store;
import com.stores.proyecto.springstoresmsi.repositories.MsiRepository;
import com.stores.proyecto.springstoresmsi.repositories.StoreRepository;



@Service
public class StoreServiceImpl  implements StoreService{

    @Autowired
    private StoreRepository repository;

    @Autowired
    private MsiRepository repositoryMsi;

    @Override
    @Transactional(readOnly = true)
    public List<Store> findAll() {
       return (List<Store>) repository.findAll();
    }

    @Override
    public Optional<Store> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Store save(Store store) {
        return repository.save(store);
    }

    @Override
	public void updateMSIStore(long storeId, long msiId) throws Exception {
		Optional<Store> oStore = repository.findById(storeId);
		
        
        if(oStore.isPresent()){
            Store store = oStore.get();
            Optional<Msi> oMsi = repositoryMsi.findById((long) msiId);

            if (oMsi.isPresent()) {
                store.setMsi(oMsi.get());
                repository.save(store);
            }   
        } else {
            throw new Exception("No se encontró la tienda");
        }
	    
	}
		
    @Override
	public void activateMSI(long storeId, boolean activate) {
		Optional<Store> oStore = repository.findById(storeId);

        if(oStore.isPresent()) {
            Store store = oStore.get();
            store.setActivate(activate);
            repository.save(store);
        }
            
		
	}

}
