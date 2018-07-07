package bdn.quantum.model;

import java.util.List;

import javax.persistence.Entity;

//
// Asset is a rough representation of a Basket, and is a grouping of one or more Positions that 
// represent the same underlying asset (e.g., an index fund and an ETF of the same asset)
//
@Entity
public class Asset {

	private Integer basketId;
	private String basketName;
	private Double principal;
	private Double principalEff;
	private Double value;
	private List<Position> positions;

	public Asset() {}
	
	public Asset(Integer basketId, String basketName, Double principal, Double principalEff, Double value, List<Position> positions) {
		this.basketId = basketId;
		this.basketName = basketName;
		this.principal = principal;
		this.principalEff = principalEff;
		this.value = value;
		this.positions = positions;
	}

	public Integer getBasketId() {
		return basketId;
	}

	public void setBasketId(Integer basketId) {
		this.basketId = basketId;
	}

	public String getBasketName() {
		return basketName;
	}

	public void setBasketName(String basketName) {
		this.basketName = basketName;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getPrincipalEff() {
		return principalEff;
	}

	public void setPrincipalEff(Double principalEff) {
		this.principalEff = principalEff;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	@Override
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("BasketId:");
		strBuf.append(basketId);
		strBuf.append(", BasketName:");
		strBuf.append(basketName);
		return strBuf.toString();
	}

}
