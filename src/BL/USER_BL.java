/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;
import DA.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author Admin
 */
public class USER_BL {
     public int id;
    public String name;
    public String pass;
    
    public USER_BL(int i,String nm,String p)
    {id=i;
    name=nm;
    pass=p;
    }
    
   public void insUsr()
           {String sql= "insert into user(USER_ID,USER_NAME,PASSWORD) values ('"+id+"','"+name+"','"+pass+"')";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");}
    }
  
   public void upUsr()
   {String sql= "update user set PASSWORD='"+pass+"' where USER_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");} 
    }
   
   public void delUsr()
    {String sql= "delete*from user where USER_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");} 
    }
   
   public ResultSet srchUsr()
   {String sql="select max(USER_ID)from user";
   InsUpDelSel iuds=new InsUpDelSel();
   ResultSet rs=iuds.selectData(sql);
if(rs==null)
{JOptionPane.showMessageDialog(null,"Please check the user id");}
return rs;
   
   }
   
}
