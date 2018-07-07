package bdn.quantum.repository;

import java.util.List;

import bdn.quantum.model.SecurityEntity;

public interface SecurityRepository {

	List<SecurityEntity> getSecurities();
	SecurityEntity createSecurity(SecurityEntity security);
	void deleteSecurity(Integer secId);
	
}
