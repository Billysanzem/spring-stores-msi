package com.stores.proyecto.springstoresmsi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="msis")
public class Msi {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private int msi;
    
    @JsonIgnore
    @OneToMany(mappedBy = "msi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Store> store;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getMsi() {
        return msi;
    }
    public void setMsi(int msi) {
        this.msi = msi;
    }

    public List<Store> getStore() {
        return store;
    }
    public void setStore(List<Store> store) {
        this.store = store;
    }

}
