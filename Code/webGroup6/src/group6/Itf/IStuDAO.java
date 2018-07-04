package group6.Itf;


import group6.Stu;
public interface IStuDAO {
	public boolean getStuList(String[] json,int isvalid) throws Exception;
	public boolean getDetail(String[] json, String sid) throws Exception;
	public boolean setValid(Stu stu,int i) throws Exception;
	public boolean findLogin(Stu student) throws Exception;
	public boolean getTotalNum(String[] value) throws Exception;
	public boolean getStudentsByClass(String[] json, String c) throws Exception;
	public boolean getStudentsByMajor(String[] json, String m) throws Exception;
	public boolean regist(Stu stu)throws Exception;
	public boolean registdetail(Stu stu) throws Exception;
	public boolean update(Stu stu) throws Exception;
}
