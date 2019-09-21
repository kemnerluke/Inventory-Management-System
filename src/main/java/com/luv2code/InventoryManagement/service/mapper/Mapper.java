package com.luv2code.InventoryManagement.service.mapper;

public abstract class Mapper<D, E> {
	
	public abstract D mapToDTO(E e);
	
	public abstract E mapToEntity(D d);
	

}
