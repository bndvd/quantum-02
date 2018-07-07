package bdn.quantum.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Asset {

	private Integer groupId;
	private String groupName;
	private Double principal;
	private Double principalEff;
	private Double value;
	private List<Position> securities;

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

	public List<Position> getSecurities() {
		return securities;
	}

	public void setSecurities(List<Position> securities) {
		this.securities = securities;
	}

}
