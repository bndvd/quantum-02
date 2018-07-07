package bdn.quantum.service;

import java.util.List;

import bdn.quantum.model.BasketEntity;
import bdn.quantum.model.SecurityEntity;

public interface AssetService {

	List<BasketEntity> getBaskets();
	BasketEntity createBasket(BasketEntity basket);
	List<SecurityEntity> getSecurities();
	SecurityEntity createSecurity(SecurityEntity security);

}
