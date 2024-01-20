package com.stores.proyecto.springstoresmsi.dtos;


public class StoreDto {

    private long msiId;

    private boolean activate;

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

    public long getMsiId() {
        return msiId;
    }

    public void setMsiId(long msiId) {
        this.msiId = msiId;
    }

    
	
}
