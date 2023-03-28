/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dao;


import java.sql.*;
import br.com.projeto_2.dto.PedidoDTO;
/**
 *
 * @author Aluno
 */
public class PedidoDAO {
    
        //Atributo do ResultSet utilizado para realizar consultas
    
    public  PedidoDAO(){
    }
    
    private ResultSet rs = null;
    
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    public  boolean inserirPedido(PedidoDTO pedidoDTO){
        try {
            conexaoDAO.ConectDB();
            
            stmt = conexaoDAO.con.createStatement();
            
            String comando = "INSERT INTO pedido (nome_p, chapaBranca_p, chapaCor_p, corredica_p, fita_p, cola_p, parafuso_p, dias_p, frete_p) " +
                 "VALUES ('" + pedidoDTO.getNome() + "', " + pedidoDTO.getChapaBranca_p() + ", " + pedidoDTO.getChapaCor_p() +
                 ", " + pedidoDTO.getCorredica_p() + ", " + pedidoDTO.getFita_p() + ", " + pedidoDTO.getCola_p() +
                 ", " + pedidoDTO.getParafuso_p() + ", " + pedidoDTO.getDias_p() + ", " + pedidoDTO.getFrete_p() + ")";


                     
            //Executa o comando SQL o banco de Dados
            
            stmt.execute(comando.toUpperCase());
            
            
            conexaoDAO.con.commit();
            
            stmt.close();
            
            return true;
        }//fecha try
        catch (Exception e) {
            System.out.println(e.getMessage());
            return  false;
        }
        
        finally{
            //Chama o metado da clase ConexaoDAO para fechar o banco de Dados
            conexaoDAO.CloseDB();
        }
        
    }//fecha metado inserir;
    
    
        public ResultSet consultarCliente(PedidoDTO pedidoDTO, int opcao){
        try {
            conexaoDAO.ConectDB();
            
            stmt = conexaoDAO.con.createStatement();
            
            String comando = "";
            
            switch(opcao){
                case  1:
                    comando = "Select c.* "+
                            "from pedido c " +
                            "where nome_p like '" + pedidoDTO.getNome() + "%' "+
                            "order by c.nome_p";
                break;
                
                case 2:
                    comando = "Select c.* "+
                            "from pedido c " + 
                            "where c.id_cli = " + pedidoDTO.getId_cli();
                break;
                
                case 3:
                    comando  ="Select c.id_cli, c.nome_p " +
                            "from pedido c ";
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return  rs;
        }//fehca try 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return  rs;
        }//fecha catch
    }//fecha metado consultarCliente
        
        
    public boolean alterarCliente(PedidoDTO pedidoDTO){
        try {
            conexaoDAO.ConectDB();
            
            stmt = conexaoDAO.con.createStatement();
            
            String comando = "Update pedido set "
                + "nome_p = '" + pedidoDTO.getNome()+ "', "
                + "chapabranca_p = " + pedidoDTO.getChapaBranca_p() + ", "
                + "chapacor_p = " + pedidoDTO.getChapaCor_p() + ", "
                + "fita_p = " + pedidoDTO.getFita_p() + ", "
                + "parafuso_p = " + pedidoDTO.getParafuso_p() + ", "
                + "corredica_p = " + pedidoDTO.getCorredica_p() + ", "
                + "cola_p = " + pedidoDTO.getCola_p() + ", "
                + "dias_p = " + pedidoDTO.getDias_p() + ", "
                + "frete_p = " + pedidoDTO.getFrete_p() + " "
                + "where id_cli = " +pedidoDTO.getId_cli();

            
            stmt.execute(comando.toUpperCase());
            
            conexaoDAO.con.commit();
            return true;
            }//fecha try
        catch (Exception e) {
                System.out.println(e.getMessage());
                return  false;
        }//fecha catch
        finally{
            conexaoDAO.CloseDB();
        }
    }//fecha alterarCliente    
    
    
    public boolean excluirCliente(PedidoDTO pedidoDTO){
        try {
            conexaoDAO.ConectDB();
            
            stmt = conexaoDAO.con.createStatement();
            
            String comando = "Delete from pedido where id_cli = "
                            + pedidoDTO.getId_cli();
            
            stmt.execute(comando);
            
            conexaoDAO.con.commit();
            
            stmt.close();
            return true;
                 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  false;
        }//fecha catch
        finally{
            conexaoDAO.CloseDB();
        }
        
    }//fecha excluirCliente
}
