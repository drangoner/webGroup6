package group6;
import group6.Itf.*;

public class StuDAOProxy implements IStuDAO{
	private DatabaseConnection dbc = null;
	private IStuDAO dao = null;
	public StuDAOProxy(){
		try{
			this.dbc = new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao = new StuDAOImpl(this.dbc.getConn());
	}
	
	@Override
	public boolean getStuList(String[] json, int isvalid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.getStuList(json, isvalid);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	public boolean findLogin(Stu student) throws Exception{
		boolean flag =false;
		try{
			flag = this.dao.findLogin(student);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	
	@Override
	public boolean getDetail(String[] json, String sid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.getDetail(json, sid);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean setValid(Stu stu, int i) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.setValid(stu, i);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean getTotalNum(String[] value) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.getTotalNum(value);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean getStudentsByClass(String[] json, String c) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.getStudentsByClass(json, c);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean getStudentsByMajor(String[] json, String m) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.getStudentsByMajor(json, m);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean regist(Stu stu) throws Exception {
		boolean flag =false;
		try{
			flag = this.dao.regist(stu);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean registdetail(Stu stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.registdetail(stu);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean update(Stu stu) throws Exception {
		// TODO Auto-generated method stub
		boolean flag =false;
		try{
			flag = this.dao.update(stu);
		}catch(Exception e){
			throw e;
		}finally{
			if(this.dbc!=null)
				this.dbc.close();
		}
		return flag;
	}

}
