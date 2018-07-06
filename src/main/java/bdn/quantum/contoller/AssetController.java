package bdn.quantum.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bdn.quantum.model.BasketEntity;
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
	
	/*@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException exc) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), exc.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}*/

}
