

import java.sql.*;

public class Database {
	private static String USERNAME = "sa";
	private static String PASSWORD = "Mrma88888888";
	private static String databese;
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://simpleme.cc:1433;databaseName=listtest";


	
    static {  
        try {  
            // 加载驱动  
            Class.forName(DRIVER);  
            System.out.println("测试加载驱动");
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
	private static Connection conn = null;
	
    public Connection getConn() throws SQLException {  
        conn = null;  
//        System.out.println("开始连接数据库");  
        try{  
            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        }catch(SQLException e){  
            e.printStackTrace();  
            System.out.println("数据库连接失败！");  
        }  
//        System.out.println("数据库连接成功");  

        return conn;  
    }



    public ResultSet getSQL(String SQL){
//    	PreparedStatement pstmt = null;
		ResultSet rs = null;
//        	try {
//				pstmt = conn.prepareStatement(SQL);
//				if(pstmt==null){
//					System.out.println("连接为空");
//				}
//				rs = pstmt.executeQuery(SQL);
//				if(rs == null){
//					System.out.println("rs为空");
//				}
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//				if (conn == null){
//					System.out.println(pstmt);
//				}
//			}
        Statement stmt;
		try {
			stmt = conn.createStatement();
	        rs = stmt.executeQuery(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
    }

    public String putSQL(String SQL) throws SQLException {
    	PreparedStatement pstmt = null;
        try{
        	int i = 0;
        	getConn();
        	
        		pstmt = conn.prepareStatement(SQL);
                pstmt.executeUpdate();
                pstmt.close();

            return "成功";
          }
//        }
        catch(Exception e){
        	System.out.println("sql失败"+SQL);
        }
        return "失败";
    }
    /* 
     * 关闭数据库连接，注意关闭的顺序 
     */  
    public void close(ResultSet rs, PreparedStatement ps, Connection conn) {  
        if(rs!=null){  
            try{  
                rs.close();  
                rs=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("关闭ResultSet失败");  
            }  
        }  
        if(ps!=null){  
            try{  
                ps.close();  
                ps=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("关闭PreparedStatement失败");  
            }  
        }  
        if(conn!=null){  
            try{  
                conn.close();  
                conn=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("关闭Connection失败");  
            }  
        }  
    }  
}  
    
    
    
