/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DA.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.*;


/**
 *
 * @author Admin
 */
public class DVD_BL {
     public int id;
     public String name;
     public String type;
     public String language;
     public int copies;
     
     public DVD_BL(int i,String nm,String typ,String lan,int cop){
         id=i;
         name=nm;
         type=typ;
         language=lan;
         copies=cop;
     }
     
     public void insDvd()
           {String sql= "insert into dvds(DVD_ID,NAME,TYPE,LANGUAGE,NO_OF_COPIES) values ('"+id+"','"+name+"','"+type+"','"+language+"','"+copies+"')";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");}
 }
     
public void upDvd()
        {String sql= "update dvds set COPIES='"+copies+"' where DVD_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");} 
    }
   
public void delDvd()
        {String sql= "delete from dvds where DVD_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
int flg=iuds.execStmt(sql);
if(flg>0)
{JOptionPane.showMessageDialog(null,"Done");} 
    }

public ResultSet selDvd()
        {String sql= "select*from dvds";
InsUpDelSel iuds=new InsUpDelSel();
ResultSet rs=iuds.selectData(sql);
if(rs==null)
{JOptionPane.showMessageDialog(null,"Error");}
return rs;
}  

public ResultSet selOneDvd()
{String sql="select from dvds where DVD_ID='"+id+"'";
InsUpDelSel iuds=new InsUpDelSel();
ResultSet rs=iuds.selectData(sql);
if(rs==null)
{JOptionPane.showMessageDialog(null,"Please check the dvd id");}
return rs;
}
}

