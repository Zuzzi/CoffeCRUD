package coffe_crud;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
 




public class CoffeDAO {  
	  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?", "root", "1093oriente+");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Coffe e){  
        int status=0;  
        try{  
            Connection con=CoffeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into coffees(cof_name,sup_id,price,sales,total) values (?,?,?,?,?)");  
            ps.setString(1,e.getCofName());  
            ps.setInt(2,e.getSupId());  
            ps.setFloat(3,e.getPrice());  
            ps.setInt(4,e.getSales());
            ps.setInt(5, e.getTotal());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Coffe e){  
        int status=0;  
        try{  
            Connection con=CoffeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update coffees set cof_name=?,sup_id=?,price=?,sales=?,total=? where cof_name=?");  
            ps.setString(1,e.getCofName());  
            ps.setInt(2,e.getSupId());  
            ps.setFloat(3,e.getPrice());  
            ps.setInt(4,e.getSales());  
            ps.setInt(5,e.getTotal());
            ps.setString(6,e.getCofName()); 
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    
    
    public static int delete(String cof_name){  
        int status=0;  
        try{  
            Connection con=CoffeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from coffees where cof_name=?");  
            ps.setString(1,cof_name);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
    
    public static Coffe getCoffeByName(String cofName){  
        Coffe e=new Coffe();  
          
        try{  
            Connection con=CoffeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from coffees where cof_name=?");  
            ps.setString(1,cofName);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setCofName(rs.getString(1));  
                e.setSupId(rs.getInt(2));  
                e.setPrice(rs.getFloat(3));  
                e.setSales(rs.getInt(4));  
                e.setTotal(rs.getInt(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    
    
    
    
    public static ArrayList<Coffe> getAllCoffes(){  
 
    	ArrayList<Coffe> list = new ArrayList<Coffe>();
          
        try{  
            Connection con=CoffeDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from coffees");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Coffe e=new Coffe();  
                e.setCofName(rs.getString(1));  
                e.setSupId(rs.getInt(2));  
                e.setPrice(rs.getFloat(3));  
                e.setSales(rs.getInt(4));  
                e.setTotal(rs.getInt(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  