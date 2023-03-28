/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_2.ctr;

/**
 *
 * @author Usuário
 */

import java.sql.ResultSet;
import br.com.projeto_2.dto.PedidoDTO;
import br.com.projeto_2.dao.PedidoDAO;
import br.com.projeto_2.dao.conexaoDAO;
public class PedidoCTR {
    PedidoDAO pedidoDAO = new PedidoDAO();
    
    
        public String inserirPedido(PedidoDTO pedidoDTO){
        try {
            if(pedidoDAO.inserirPedido(pedidoDTO)){
                return "Pedido cadastrado com Sucesso!!!";
            }
            else{
                return "Pedido NÂO Cadastrado";
            }
        }//fecha try
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "pedido NÂO Cadastrado";
        }//fecha catch
       }
    
    public  ResultSet consultarCliente(PedidoDTO pedidoDTO,int opcao){
        ResultSet rs= null;
        
        rs = pedidoDAO.consultarCliente(pedidoDTO, opcao);
        
        return  rs;
    }// fecha metado consultarCliente
    
    
    public  String alterarCliente(PedidoDTO pedidoDTO){
        try {
            if(pedidoDAO.alterarCliente(pedidoDTO)){
                return  "Cliente Alterado com Sucesso!!!";
            }else{
                return  "Cliente NÂO alterado!!!";
            }
        }//fecha try
        catch (Exception e) {
            System.out.println(e.getMessage());
            return  "Cliente NAO alterado!!!";
        }//fecha catch
    
    }//fecha alterarcliente
    
    
    public String excluirCliente(PedidoDTO pedidoDTO){
        try {
            if(pedidoDAO.excluirCliente(pedidoDTO)){
                return  "Cliente Excluído com Sucesso!!!";
            }else{
                return "Cliente NÂO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÂO Excluído!!!";
        }
    }//fecha o metado excluirCliente
    
    public  void CloseDB(){
        conexaoDAO.CloseDB();
    }//fecha metada closeDB
        
}
