

import java.sql.*;

public class Database {
	private static String USERNAME = "sa";
	private static String PASSWORD = "Mrma88888888";
	private static String databese;
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://simpleme.cc:1433;databaseName=listtest";


	
    static {  
        try {  
            // ��������  
            Class.forName(DRIVER);  
            System.out.println("���Լ�������");
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
	private static Connection conn = null;
	
    public Connection getConn() throws SQLException {  
        conn = null;  
//        System.out.println("��ʼ�������ݿ�");  
        try{  
            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        }catch(SQLException e){  
            e.printStackTrace();  
            System.out.println("���ݿ�����ʧ�ܣ�");  
        }  
//        System.out.println("���ݿ����ӳɹ�");  

        return conn;  
    }



    public ResultSet getSQL(String SQL){
//    	PreparedStatement pstmt = null;
		ResultSet rs = null;
//        	try {
//				pstmt = conn.prepareStatement(SQL);
//				if(pstmt==null){
//					System.out.println("����Ϊ��");
//				}
//				rs = pstmt.executeQuery(SQL);
//				if(rs == null){
//					System.out.println("rsΪ��");
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

            return "�ɹ�";
          }
//        }
        catch(Exception e){
        	System.out.println("sqlʧ��"+SQL);
        }
        return "ʧ��";
    }
    /* 
     * �ر����ݿ����ӣ�ע��رյ�˳�� 
     */  
    public void close(ResultSet rs, PreparedStatement ps, Connection conn) {  
        if(rs!=null){  
            try{  
                rs.close();  
                rs=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("�ر�ResultSetʧ��");  
            }  
        }  
        if(ps!=null){  
            try{  
                ps.close();  
                ps=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("�ر�PreparedStatementʧ��");  
            }  
        }  
        if(conn!=null){  
            try{  
                conn.close();  
                conn=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("�ر�Connectionʧ��");  
            }  
        }  
    }  
}  
    
    
    
