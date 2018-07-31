/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DA.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author Admin
 */
public class RENT_BL {

    int id;
    String date;
    int dvid;
    int cmid;
    String rtndt;
    String rtnd;
    String name;
    String tit;
    double total;
    int cost;
    int oc;

    public RENT_BL(int i, String dt, int did, int cid, String rdt, String rtn, String n, String t, double amount, int c, int o) {
        id = i;
        date = dt;
        dvid = did;
        cmid = cid;
        rtndt = rdt;
        rtnd = rtn;
        name = n;
        tit = t;
        total = amount;
        cost = c;
        oc = o;
    }

    public void insRent() {
            String sql="INSERT INTO rental_details(RENT_ID,DATE, DVD_ID, CM_ID, RETURN_DATE, RETURNED, NAME, TITLE, TOTAL, COST, OC)VALUES('"+id+"', '"+date+"', '"+dvid+"', '"+cmid+"', '"+rtndt+"', '"+rtnd+"', '"+name+"', '"+tit+"', '"+total+"', '"+cost+"', '"+oc+"')";
            InsUpDelSel iuds = new InsUpDelSel();
            int flg = iuds.execStmt(sql);
            if (flg > 0) {
                JOptionPane.showMessageDialog(null, "Done");
            }

    }

    public void updRent() {
        String sql = "update rental_details set RETURN_DATE='" + rtndt + "',RETURNED='" + rtnd + "' where RENT_ID='" + id + "'";
        InsUpDelSel iuds = new InsUpDelSel();
        int flg = iuds.execStmt(sql);
        if (flg > 0) {
            JOptionPane.showMessageDialog(null, "Done");
        }
    }

    public void delRent() {
        String sql = "delete from rental_details where RENT_ID='" + id + "'";
        InsUpDelSel iuds = new InsUpDelSel();
        int flg = iuds.execStmt(sql);
        if (flg > 0) {
            JOptionPane.showMessageDialog(null, "Done");
        }
    }

    public ResultSet selRent() {
        String sql = "select*from rental_details";
        InsUpDelSel iuds = new InsUpDelSel();
        ResultSet rs = iuds.selectData(sql);
        if (rs == null) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return rs;
    }

    public ResultSet selOneRent() {
        String sql = "select from rental_details where RENT_ID='" + id + "'";
        InsUpDelSel iuds = new InsUpDelSel();
        ResultSet rs = iuds.selectData(sql);
        if (rs == null) {
            JOptionPane.showMessageDialog(null, "Please check the rental id");
        }
        return rs;
    }
}