package com.cab.Services;


import java.util.Set;

import com.cab.Model.Admin;

public interface AdminServices {
public Admin createAdmin(Admin admin); 
	
	public Admin updateAdmin(Admin user);
	
	public Admin getUser(String username);
	
	public Set<Admin> getAllAdmin();
	
}
