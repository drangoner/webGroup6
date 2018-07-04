package group6.Itf;

import group6.Admin;

public interface IAdminDAO {
	
	public boolean findLogin(Admin admin) throws Exception;
	public boolean logout(Admin admin) throws Exception;
	
}
