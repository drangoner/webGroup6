package group6;

public class Admin {
	
	
	private String user;
	private String name;
	private String passwd;
	private String lastlogin;
	
	public String getUser(){
		return user;
	}
	public void setUser(String user){
		this.user = user;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getPasswd(){
		return passwd;
	}
	public void setPasswd(String passwd){
		this.passwd = passwd;
	}
	
	public String getLastLogin(){
		return lastlogin;
	}
	public void setLastLogin(String lastLogin){
		this.lastlogin = lastLogin;
	}
}
