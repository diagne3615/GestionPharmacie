/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpharmacie;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author djira
 */
public class fonctions {
    
    public static void AlerteExpiration(String table,JTable tableExpire,String id)
            {
                        connexionToDatabase connexion = new connexionToDatabase();
                        Statement stm;
                        String donnee,dat =""; 
                        ResultSet rs;
                        int n=0;
                        boolean  expire = false;
                        DefaultTableModel modeltable=new DefaultTableModel();
                        modeltable.addColumn("Libellé");
                        modeltable.addColumn("Expire dans");
                        
                        DateFormat fd = new SimpleDateFormat("yyyy-MM-dd"); 
	                java.util.Date aujourdhui = Calendar.getInstance().getTime();
	                String dateFormatee = fd.format(aujourdhui);
                        
                        String an0=dateFormatee.substring(0,4);
                        String moi0=dateFormatee.substring(5,7);
                        String jr0=dateFormatee.substring(8,10);
                        int j0=Integer.valueOf(jr0);
                       
                        try
                        {
                           stm = connexion.getConnexionFromDatabase().createStatement();
                           donnee ="SELECT * FROM "+table+" where idphar='"+id+"'";
                            rs=stm.executeQuery(donnee);
                            while (rs.next()){
                                String datExpir=rs.getString("dateexpiration");
                                
                                String an1=datExpir.substring(0,4);
                                String moi1=datExpir.substring(5,7);
                                String jr1=datExpir.substring(8,10);
                                int j1=Integer.valueOf(jr1);
                                int dif=j0-j1;
                                if(an0.equals(an1) && moi0.equals(moi1)){
                                   if(dif<=31){ 
                                       if(dif<0){dif=-dif;}
                                       String libRef=rs.getString("nom")+" "+rs.getString("reference");
                                    expire=true;
                                    modeltable.addRow(new Object[]{libRef, dif+" jour(s)"});

                                    n++;
                                   } 
                                }
                            }                      
                        }catch(SQLException ex){
                            System.err.println(ex);              
                        }
                        tableExpire.setModel(modeltable);
                        if(expire){JOptionPane.showMessageDialog(null, n+" "+table+"(s) va (vont) expirer dans moins d'un mois.\nVeuillez consulter la rubrique des alertes!");}
   }
    
   public static void AlerteAppro(String table,JTable tableAppro,String id)
            {
                        connexionToDatabase connexion = new connexionToDatabase();
                        Statement stm;
                        String donnee ; 
                        ResultSet rs;
                        
                         DefaultTableModel modeltable=new DefaultTableModel();
                         modeltable.addColumn("Libellé");
                         modeltable.addColumn("Restant");
                         
                        int n=0;
                        boolean  appro = false;                      
                        try
                        {
                           stm = connexion.getConnexionFromDatabase().createStatement();
                           donnee ="SELECT * FROM "+table+" where idphar='"+id+"'";
                            rs=stm.executeQuery(donnee);
                            while (rs.next()){
                                String qte=rs.getString("quantite");
                               int q=Integer.valueOf(qte);
                                   if(q<=10){ 
                                    appro=true;
                                     modeltable.addRow(new Object[]{ rs.getString("nom"),rs.getString("quantite")});
                                    n++;
                                   }                               
                            }                      
                        }catch(SQLException ex){
                            System.err.println(ex);              
                        }
                        tableAppro.setModel(modeltable);
                        if(appro){JOptionPane.showMessageDialog(null, n+" médicament(s) a (ont) atteint le seuil d'approvisionnement.\nVeuillez consulter la rubrique des alertes!");}
   }
   
    public static void Recherche(String table,JTable tableResult,String nom,String combo,String id )
            {
                        connexionToDatabase connexion = new connexionToDatabase();
                        Statement stm;
                        String donnee ; 
                        ResultSet rs;
                        
                        DefaultTableModel modeltable=new DefaultTableModel();
                        modeltable.addColumn("Nom");
                        modeltable.addColumn("Prix");                    
                        try
                        {
                           stm = connexion.getConnexionFromDatabase().createStatement();
                           donnee ="SELECT * FROM "+table+" WHERE idphar='"+id+"' AND type='"+combo+"' AND nom='"+nom+"'";
                            rs=stm.executeQuery(donnee);
                            while (rs.next()){
                                     modeltable.addRow(new Object[]{ rs.getString("nom"),rs.getString("prix")+" fcfa"});
                            }                      
                        }catch(SQLException ex){
                            System.err.println(ex);              
                        }
                        tableResult.setModel(modeltable);
   }
    
}
