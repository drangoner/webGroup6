package group6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import group6.Itf.IStuDAO;

public class StuDAOImpl implements IStuDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public StuDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public boolean findLogin(Stu student) throws Exception{
		boolean flag = false;
		try{
			String sql = "SELECT * FROM student WHERE user=? AND passwd=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1,student.getUser());
			this.pstmt.setString(2,student.getPasswd());
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				student.setName(rs.getString("name"));
				student.setLastlogin(rs.getString("lastlogin"));
				student.setSid(rs.getString("sid"));
				student.setSex(rs.getInt("sex"));
				student.setEmail(rs.getString("email"));
				student.setCity(rs.getString("city"));
				student.setSclass(rs.getString("class"));
				student.setMajor(rs.getString("major"));
				student.setPhone(rs.getString("phone"));
				student.setIntime(rs.getString("intime"));
				student.setOuttime(rs.getString("outtime"));
				student.setEmail(rs.getString("email"));
				student.setCompany(rs.getString("company"));
				
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
	
	@Override
	public boolean setValid(Stu stu, int i) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			String sql = "UPDATE `student` SET `isvalid`=? WHERE `sid`=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, i);;
			this.pstmt.setString(2, stu.getSid());
			if(!this.pstmt.execute()){//true if the first result is a ResultSet object; false if the first result is an update count or there is no result
				flag = true;
			}else{
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

	@Override
	public boolean getTotalNum(String[] value) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			String sql = "SELECT count(*) FROM student";
			
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				value[0] = rs.getString(1);
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
	@Override
	public boolean getStuList(String[] json,int isvalid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student where isvalid=?";
		return select(json,sql,""+isvalid);

		
	}
	@Override
	public boolean getDetail(String[] json, String sid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student where sid=?";
		return select(json,sql,sid);

	}
	@Override
	public boolean getStudentsByClass(String[] json, String c) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student where class=?";
		return select(json,sql,c);
	}
	@Override
	public boolean getStudentsByMajor(String[] json, String m) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student where major=?";
		return select(json,sql,m);

	}
	
	
	private boolean select(String[] json ,String sql,String value) throws Exception{
		boolean flag = false;
		try{
			
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, value);
			ResultSet rs = this.pstmt.executeQuery();
		
			String html = "{\"student\":[";
			while(rs.next()){
				html+="{"+"\"id\":\""+rs.getString("sid")+"\","+
						"\"name\":\""+rs.getString("name")+"\","+
						"\"sex\":\""+rs.getInt("sex")+"\","+
						"\"class\":\""+rs.getString("class")+"\","+
						"\"major\":\""+rs.getString("major")+"\","+
						"\"phone\":\""+rs.getString("phone")+"\","+
						"\"email\":\""+rs.getString("email")+"\","+
						"\"intime\":\""+rs.getString("intime")+"\","+
						"\"outtime\":\""+rs.getString("outtime")+"\","+
						"\"company\":\""+rs.getString("company")+"\","+
						"\"city\":\""+rs.getString("city")+"\","+
						"\"lastlogin\":\""+rs.getString("lastlogin")+"\","+
						"\"user\":\""+rs.getString("user")+"\","+
						"\"passwd\":\""+rs.getString("passwd")+"\""+"},";
			}
			if(html.charAt(html.length()-1)==',')
				html =  html.substring(0,html.length()-1);
			html+= "]}";
			json[0] = html;
			flag = true;
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

	@Override
	public boolean regist(Stu stu) throws Exception {//注册
		boolean flag = false;
		String sql = "SELECT * FROM student WHERE user=? or sid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,stu.getUser());
		this.pstmt.setString(2,stu.getSid());
		ResultSet rs = this.pstmt.executeQuery();
		
		if(!rs.next()){
			sql = "insert into student(user,passwd,sid) values(?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stu.getUser());
			this.pstmt.setString(2, stu.getPasswd());
			this.pstmt.setString(3, stu.getSid());
			if(!this.pstmt.execute()){//insert success
				flag=true;
			}
		}
		return flag;
	}

	@Override
	public boolean registdetail(Stu stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			String sql = "UPDATE `student` SET `name`=?, `sex`=?,`major`=?,`class`=?,`phone`=?,`email`=?,`intime`=?,`outtime`=?,`city`=? WHERE `sid`=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stu.getName());
			this.pstmt.setInt(2, stu.getSex());
			this.pstmt.setString(3, stu.getMajor());
			this.pstmt.setString(4, stu.getSclass());
			this.pstmt.setString(5, stu.getPhone());
			this.pstmt.setString(6, stu.getEmail());
			this.pstmt.setString(7, stu.getIntime());
			this.pstmt.setString(8, stu.getOuttime());
			this.pstmt.setString(9, stu.getCity());
			this.pstmt.setString(10, stu.getSid());
			if(!this.pstmt.execute()){//true if the first result is a ResultSet object; false if the first result is an update count or there is no result
				flag = true;
			}else{
				System.out.println("hahah");
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

	@Override
	public boolean update(Stu stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			String sql = "UPDATE `student` SET `name`=?,`major`=?,`class`=?,`phone`=?,`email`=?,`intime`=?,`outtime`=?,`city`=?,`passwd`=? WHERE `sid`=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stu.getName());
			this.pstmt.setString(2, stu.getMajor());
			this.pstmt.setString(3, stu.getSclass());
			this.pstmt.setString(4, stu.getPhone());
			this.pstmt.setString(5, stu.getEmail());
			this.pstmt.setString(6, stu.getIntime());
			this.pstmt.setString(7, stu.getOuttime());
			this.pstmt.setString(8, stu.getCity());
			this.pstmt.setString(9, stu.getPasswd());
			this.pstmt.setString(10, stu.getSid());
			if(!this.pstmt.execute()){//true if the first result is a ResultSet object; false if the first result is an update count or there is no result
				flag = true;
			}else{
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
}
