package group6;

import group6.Itf.*;
public class DAOFactory {
	public static IAdminDAO getIAdminDAOInstanse(){
		return new AdminDAOProxy();
	}
	public static IStuDAO getIStuDAOInstanse(){
		return new StuDAOProxy();
	}
}
