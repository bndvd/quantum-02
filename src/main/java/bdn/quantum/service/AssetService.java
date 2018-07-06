package bdn.quantum.service;

import java.util.List;

import bdn.quantum.model.BasketEntity;

public interface AssetService {

	List<BasketEntity> getBaskets();
	BasketEntity createBasket(BasketEntity basket);
	
}
