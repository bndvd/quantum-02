package bdn.quantum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bdn.quantum.model.Asset;
import bdn.quantum.model.BasketEntity;
import bdn.quantum.model.Position;
import bdn.quantum.model.SecurityEntity;
import bdn.quantum.model.TranEntity;
import bdn.quantum.model.util.PositionComparator;
import bdn.quantum.model.util.TranEntryComparator;
import bdn.quantum.repository.BasketRepository;
import bdn.quantum.repository.SecurityRepository;
import bdn.quantum.repository.TransactionRepository;
import bdn.quantum.util.PortfolioConstants;

@Service("assetService")
public class AssetServiceImpl implements AssetService {

	@Autowired
	BasketRepository basketRepository;
	@Autowired
	SecurityRepository securityRepository;
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	TranEntryComparator transactionComparator;
	@Autowired
	PositionComparator positionComparator;

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

	@Override
	public List<Asset> getAssets() {
		List<Asset> result = new ArrayList<>();
		
		List<BasketEntity> baskets = basketRepository.getBaskets();
		for (BasketEntity b : baskets) {
			Integer basketId = b.getBasketId();
			String basketName = b.getName();
			Double principal = 0.0;
			Double principalEff = 0.0;
			Double value = 0.0;
			
			List<Position> positions = getPositions(basketId);
			positions.sort(positionComparator);
			
			for (Position p : positions) {
				principal += p.getPrincipal();
				principalEff += p.getPrincipalEff();
				Double positionValue = p.getPrice() * p.getShares();
				value += (positionValue >= 0.0 ) ? positionValue : 0.0;
			}
			
			Asset a = new Asset(basketId, basketName, principal, principalEff, value, positions);
			result.add(a);
		}
		
		return result;
	}

	@Override
	public List<Position> getPositions(Integer basketId) {
		List<Position> result = new ArrayList<>();
		
		List<SecurityEntity> securities = securityRepository.getSecurities(basketId);
		for (SecurityEntity s : securities) {
			Integer secId = s.getSecId();
			String symbol = s.getSymbol();
			Double principal = 0.0;
			Double shares = 0.0;
			// TODO get price from public service
			Double price = -1.0;
			
			List<TranEntity> transactions = transactionRepository.getTransactions(secId);
			transactions.sort(transactionComparator);
			for (TranEntity t : transactions) {
				if (t.getType().equals(PortfolioConstants.TYPE_BUY)) {
					principal += (t.getPrice() * t.getShares());
					shares += t.getShares();
				}
				else if (t.getType().equals(PortfolioConstants.TYPE_SELL)) {
					Double valuePriorToSale = shares * t.getPrice();
					Double principalToValueRatioPriorToSale = principal / valuePriorToSale;
					Double valueOfSale = t.getShares() * t.getPrice();
					Double principalPortionOfSale = valueOfSale * principalToValueRatioPriorToSale;
					principal -= principalPortionOfSale;
					shares -= t.getShares();
				}
			}
			// TODO calculate effective principal
			Double principalEff = principal;
			
			Position p = new Position(secId, symbol, principal, principalEff, shares, price, transactions);
			result.add(p);
		}
		
		result.sort(positionComparator);
		return result;
	}

	
}
