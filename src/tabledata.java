import javax.swing.*;
import java.sql.*;
import java.util.Vector;
public class tabledata 
{
void tbldata()
{
     try{
         
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","user");
        String sql="select * from studentdata";
        PreparedStatement pst=con.prepareStatement(sql); 
       
        ResultSet rs=pst.executeQuery();
        ResultSetMetaData rsmt=rs.getMetaData();
        int c=rsmt.getColumnCount();
        Vector column=new Vector(c);
        for(int i=1;i<=c;i++)
        {
            column.add(rsmt.getColumnName(i));
            
        }
         Vector data=new Vector();    
        while(rs.next())
        {
             Vector row=new Vector(c);
             for(int i=1;i<=c;i++)
        {
            row.add(rs.getString(i));
                        
        }
             data.add(row);
        }
            JFrame frame=new JFrame("STUDENTS TABLE");
            frame.setSize(1400,700);
            JPanel panel=new JPanel();
            JTable table =new JTable(data,column);
            table.setBounds(30,40,1400,700);
            JScrollPane jsp=new JScrollPane(table);
            frame.add(jsp);
            frame.setVisible(true);
         }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null,"error");}
}
}