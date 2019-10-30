package org.techzoo.ems.util;

public enum Department {

	IT,
	Service,
	HR,
	Finance,
	Management,
	Security;
	
	public static Department toEnum(String dept){
		for(Department d: Department.values()){
			if(d.toString().equals(dept)) {
				return d;
			}
		}
		return Department.Management;
	} 
}
