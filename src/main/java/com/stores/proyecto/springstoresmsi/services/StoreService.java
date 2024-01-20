package com.stores.proyecto.springstoresmsi.services;

import java.util.List;
import java.util.Optional;

import com.stores.proyecto.springstoresmsi.entities.Store;

public interface StoreService {

    List<Store> findAll();
    
    Optional<Store> findById(long id);

    Store save(Store store);

     void updateMSIStore(long storeId, long msiId) throws Exception;

     void activateMSI(long storeId, boolean activate);

    //Store updateMSIDto(long id, long msiDto);


}
