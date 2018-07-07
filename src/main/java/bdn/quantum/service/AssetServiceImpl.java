package bdn.quantum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bdn.quantum.model.BasketEntity;
import bdn.quantum.model.SecurityEntity;
import bdn.quantum.repository.BasketRepository;
import bdn.quantum.repository.SecurityRepository;

@Service("assetService")
public class AssetServiceImpl implements AssetService {

	@Autowired
	BasketRepository basketRepository;
	@Autowired
	SecurityRepository securityRepository;
	@Autowired
	TransactionService transactionService;

	@Override
	public List<BasketEntity> getBaskets() {
		return basketRepository.getBaskets();
	}

	@Override
	public BasketEntity createBasket(BasketEntity basket) {
		return basketRepository.createBasket(basket);
	}

	@Override
	public List<SecurityEntity> getSecurities() {
		return securityRepository.getSecurities();
	}

	@Override
	public List<SecurityEntity> getSecurities(Integer basketId) {
		return securityRepository.getSecurities(basketId);
	}
	
	@Override
	public SecurityEntity createSecurity(SecurityEntity security) {
		return securityRepository.createSecurity(security);
	}

	
	
}
