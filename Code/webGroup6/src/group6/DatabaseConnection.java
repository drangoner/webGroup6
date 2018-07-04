package group6;

import java.sql.*;

public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBNAME = "webgroup6";
	private static final String USER = "admin";
	private static final String PASSWD = "admin";
	private static final String DBURL = "jdbc:mysql://115.159.86.195:3306/"+DBNAME+"?useUnicode=true&characterEncoding=UTF-8";
	private  Statement stmt;
	private  Connection conn = null; 
	private  ResultSet rs = null;
	
	public DatabaseConnection() {
		//瀹炰緥鍖栭┍鍔�
		try {
			Class.forName(DBDRIVER).newInstance();
			System.out.println("椹卞姩鍔犺浇鎴愬姛");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

		//杩炴帴鏁版嵁搴�
		try {
			conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			stmt = conn.createStatement();
			System.out.println("杩炴帴鎴愬姛");
		} catch (SQLException e) {
			System.out.println("杩炴帴澶辫触");
			e.printStackTrace();
		}
	}
	public  Statement getStat() {
		return stmt;
	}

	public  Connection getConn() {
		return conn;
	}
	public  ResultSet getRs() {
		return rs;
	}
	public void close()throws Exception{
		if(this.conn!= null){
			try{
				if(this.rs!=null)
					this.rs.close();
				if(this.stmt!=null)
					this.stmt.close();
				this.conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	//curd
	public  boolean select(String sql) {
	        /*try {
	        	rs = stmt.executeQuery(sql);
	            ResultSetMetaData meta_data = WeatherSpider.rs.getMetaData();//鍒楀悕
	            for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
	                System.out.print(meta_data.getColumnLabel(i_col) + "   ");
	            }
	            System.out.println();
	            while (WeatherSpider.rs.next()) {
	                for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
	                    System.out.print(WeatherSpider.rs.getString(i_col) + "  ");
	                }
	                System.out.println();
	            }
	            WeatherSpider.rs.close();
	        }catch (Exception e) {
	            System.out.println("鏁版嵁鏌ヨ澶辫触!");
	        }*/
		
			try{
				rs = stmt.executeQuery(sql);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("鏁版嵁鏌ヨ澶辫触!");
				return false;
			}
			
	    }
	    public  boolean insert(String sql) {
	        try {
	        	stmt.clearBatch();
	        	stmt.addBatch(sql);
	        	stmt.executeBatch();
	            System.out.println("鏁版嵁鎻掑叆鎴愬姛!");
	            return true;
	        }catch (Exception e) {
	        	e.printStackTrace();
	            System.out.println("鏁版嵁鎻掑叆澶辫触!");
	            return false;
	        }

	    }
	    public  boolean update(String sql) {
	        try {
	        	stmt.executeUpdate(sql);
	            System.out.println("鏁版嵁鏇存柊鎴愬姛!");
	            return true;
	        }catch (Exception e) {
	        	e.printStackTrace();
	            System.out.println("鏁版嵁鏇存柊澶辫触!");
	            return false;
	        }
	    }
	    
	    public boolean delete(String sql){
	    	try{
	    		stmt.execute(sql);
	    		System.out.println("鏁版嵁鍒犻櫎鎴愬姛!");
		        return true;
	    	}catch (Exception e) {
	        	e.printStackTrace();
	            System.out.println("鏁版嵁鍒犻櫎澶辫触!");
	            return false;
	        }
	    }
	   
}
