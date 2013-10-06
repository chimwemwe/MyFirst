//STEP 1. Import required packages

import java.sql.*;

public class ShowRooms {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/MIYE";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "Ist303@cgu";
   
   public static void main(String[] args) throws Exception {
   Connection conn = null;
   Statement stmt = null;
   //try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      //System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT r.Room_Name, rt.Room_Type, rt.Capacity FROM Room r, Room_Type rt WHERE r.Room_Type_Id = rt.Room_Type_Id AND rt.Room_Type_Id = 3";
      ResultSet rs = stmt.executeQuery(sql);
      

      //STEP 5: Extract data from result set
      System.out.println("The following rooms are available");
      System.out.println("Room Name " + "Room Type " + "Capacity");
      while(rs.next()){
         //Retrieve by column name
         String rn  = rs.getString("Room_Name");
         String rt = rs.getString("Room_Type");
         int cap = rs.getInt("Capacity");
         

         //Display values
         
         System.out.println(rn + " " + rt + " " + cap);
       

      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();

   System.out.println("Goodbye!");
}//end main
}//end FirstExample

