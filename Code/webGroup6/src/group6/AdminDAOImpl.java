package group6;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import group6.Itf.IAdminDAO;
public class AdminDAOImpl implements IAdminDAO{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public AdminDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean findLogin(Admin admin) throws Exception{
		boolean flag = false;
		try{
			String sql = "SELECT name,lastlogin FROM administrator WHERE user=? AND passwd=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1,admin.getUser());
			this.pstmt.setString(2,admin.getPasswd());
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				admin.setName(rs.getString(1));
				admin.setLastLogin(rs.getString(2));
				flag = true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pstmt!=null){
				try{
					this.pstmt.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}
	
	public boolean logout(Admin admin) throws Exception{
		boolean flag= false;
		try{
			String sql = "UPDATE `administrator` SET `lastlogin`=now() WHERE (user=?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1,admin.getUser());
			if(this.pstmt.execute())
				flag = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.pstmt!=null){
				try{
					this.pstmt.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}
}
