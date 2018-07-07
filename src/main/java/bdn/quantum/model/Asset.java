package bdn.quantum.model;

import java.util.List;

import javax.persistence.Entity;

//
// Asset is a rough representation of a Basket, and is a grouping of one or more Positions that 
// represent the same underlying asset (e.g., an index fund and an ETF of the same asset)
//
@Entity
public class Asset {

	private Integer groupId;
	private String groupName;
	private Double principal;
	private Double principalEff;
	private Double value;
	private List<Position> positions;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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


}
