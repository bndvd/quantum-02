package bdn.quantum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bdn.quantum.model.BasketEntity;
import bdn.quantum.repository.BasketRepository;

@Service("assetService")
public class AssetServiceImpl implements AssetService {

	@Autowired
	BasketRepository basketRepository;

	@Override
	public List<BasketEntity> getBaskets() {
		return basketRepository.getBaskets();
	}

	@Override
	public BasketEntity createBasket(BasketEntity basket) {
		return basketRepository.createBasket(basket);
	}
	
	
	
}
