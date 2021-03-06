package bdn.quantum.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bdn.quantum.model.Asset;
import bdn.quantum.model.BasketEntity;
import bdn.quantum.model.Position;
import bdn.quantum.model.SecurityEntity;
import bdn.quantum.service.AssetService;

@RestController("assetController")
@RequestMapping("api/v1/")
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	@RequestMapping(value = "/baskets", method = RequestMethod.GET)
	public List<BasketEntity> getBaskets() {
		return assetService.getBaskets();
	}
	
	@RequestMapping(value = "/basket", method = RequestMethod.POST)
	public BasketEntity createBasket(@RequestBody BasketEntity basket) {
		return assetService.createBasket(basket);
	}
	
	@RequestMapping(value = "/securities", method = RequestMethod.GET)
	public List<SecurityEntity> getSecurities() {
		return assetService.getSecurities();
	}
	
	@RequestMapping(value = "/securities/{basketId}", method = RequestMethod.GET)
	public List<SecurityEntity> getSecurities(@PathVariable(value="basketId") Integer basketId) {
		return assetService.getSecurities(basketId);
	}
	
	@RequestMapping(value = "/security", method = RequestMethod.POST)
	public SecurityEntity createSecurity(@RequestBody SecurityEntity security) {
		return assetService.createSecurity(security);
	}
	
	@RequestMapping(value = "/assets", method = RequestMethod.GET)
	public List<Asset> getAssets() {
		return assetService.getAssets();
	}
	
	@RequestMapping(value = "/positions/{basketId}", method = RequestMethod.GET)
	public List<Position> getPositions(@PathVariable(value="basketId") Integer basketId) {
		return assetService.getPositions(basketId);
	}
	
	
	/*@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException exc) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), exc.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}*/

}
