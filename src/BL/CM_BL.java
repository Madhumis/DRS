/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;
import DA.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class CM_BL {
    public int id;
    public int nic;
    public String name;
    public String adrs;
    public int telno;
    public String date;
    
    
    public CM_BL(int i,int n,String nm,String ad,int tel, String dt)
    {id=i;
    nic=n;
    name=nm;
    adrs=ad;
    telno=tel;
    date=dt;
     }
    
    public void insCm()
    {String sql= "insert into customer(CM_ID,CM_NIC,NAME,ADDRESS,TELEPHONE,REG_DATE) values ('"+id+"','"+nic+"','"+name+"','"+adrs+"',"+telno+",'"+date+"')";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");}
    }
    
public void upCm()
    {String sql= "update customer set ADDRESS='"+adrs+"',TELEPHONE='"+telno+"' where CM_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");} 
    }
         
   
public void delCm()
   {String sql= "delete from customer where CM_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");} 
    }
            

public ResultSet selCm()
        {String sql= "select*from customer";
InsUpDelSel iuds=new InsUpDelSel();
ResultSet rs=iuds.selectData(sql);
if(rs==null)
{JOptionPane.showMessageDialog(null,"Error");}
return rs;
} 

public ResultSet selOneCm()
{String sql="select from customer where CM_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
ResultSet rs=iuds.selectData(sql);
if(rs==null)
{JOptionPane.showMessageDialog(null,"Please check the user id");}
return rs;
}

}

