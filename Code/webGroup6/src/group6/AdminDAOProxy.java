package group6;
import group6.Itf.*;
public class AdminDAOProxy implements IAdminDAO{
	private DatabaseConnection dbc = null;
	private IAdminDAO dao = null;
	public AdminDAOProxy(){
		try{
			this.dbc = new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao = new AdminDAOImpl(this.dbc.getConn());
	}
	
	public boolean findLogin(Admin admin) throws Exception{
		boolean flag =false;
		try{
			flag = this.dao.findLogin(admin);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	public boolean logout(Admin admin) throws Exception{
		boolean flag = false;
		try{
			flag = this.dao.logout(admin);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
}
