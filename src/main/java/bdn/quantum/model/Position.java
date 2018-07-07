package bdn.quantum.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Position {

	private Integer secId;
	private String symbol;
	private Double principal;
	private Double principalEff;
	private Double shares;
	private Double price;
	private List<TranEntity> transactions;

	public Integer getSecId() {
		return secId;
	}

	public void setSecId(Integer secId) {
		this.secId = secId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public Double getShares() {
		return shares;
	}

	public void setShares(Double shares) {
		this.shares = shares;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<TranEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TranEntity> transactions) {
		this.transactions = transactions;
	}

}
