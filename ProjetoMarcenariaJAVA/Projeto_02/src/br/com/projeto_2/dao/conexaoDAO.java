/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dao;

import java.sql.*;
/**
 *
 * @author Aluno
 */
public class conexaoDAO {
       
    public  static  Connection con = null;
    
    public conexaoDAO(){
        
    
    }
    
    public  static void ConectDB(){
        try {
            //Dados para conectar com o banco de dados Postgres
            String dsn = "projeto_marcenaria";
            String user = "postgres";
            String senha = "postdba";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url= "jdbc:postgresql://localhost:5432/" + dsn;
            
            //jdbc:postgresql://localhost:5432/
            con = DriverManager.getConnection(url, user , senha);
            
            con.setAutoCommit(false);
            if(con == null){
                System.out.println("erro ao abrir o banco");
            }
        }//fecha try
        catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados: " + e.getMessage());
        }//fecha catch
    
    }//Fecha o métado ConectDB
    
    
    public static void CloseDB(){
        try {
            con.close();
        }//fecha try
        catch (Exception e) {
            System.out.println("Problema ao abir a base de dados!" + e.getMessage());
        }
        
    }
}
