/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_2.view;

import br.com.projeto_2.ctr.PedidoCTR;
import br.com.projeto_2.dto.PedidoDTO;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuário
 */
public class CalculoPreço extends javax.swing.JFrame {

    /**
     * Creates new form blabla
     */
    public CalculoPreço() {
        initComponents();
        
        liberaCampos(false);
        
        liberaBotoes(true, false, false, false, true,false);
        modelo_jtl_consultar_cliente = (DefaultTableModel) jtl_consultar_cliente.getModel();
    }
    
    
    
    PedidoDTO pedidoDTO = new PedidoDTO();
    PedidoCTR pedidoCTR = new PedidoCTR();
    
    int gravar_alterar;
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_cliente;
    
    private void liberaCampos(boolean a){
        nome_p.setEnabled(a);
        chapaBranca_p.setEnabled(a);
        chapaCor_p.setEnabled(a);
        corredica_p.setEnabled(a);
        fita_p.setEnabled(a);
        cola_p.setEnabled(a);
        parafuso_p.setEnabled(a);
        dias_p.setEnabled(a);
        frete_p.setEnabled(a);    
    }//Fecha liberaCampos
     
    private void limpaCampos(){
        nome_p.setText("");
        chapaBranca_p.setText("");
        chapaCor_p.setText("");
        corredica_p.setText("");
        fita_p.setText("");
        cola_p.setText("");
        parafuso_p.setText("");
        dias_p.setText("");
        frete_p.setText("");
        
    }//Fecha limpaCampos
     
    
    private void liberaBotoes(boolean a, boolean  b, boolean c, boolean  d, boolean e,boolean f){
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
        btnMonstra.setEnabled(f);
    }
    

    
    
       private void gravar(){
        try{
           pedidoDTO.setNome(nome_p.getText());
           pedidoDTO.setChapaBranca_p(Float.parseFloat(chapaBranca_p.getText()));
           pedidoDTO.setChapaCor_p(Float.parseFloat(chapaCor_p.getText()));
           pedidoDTO.setCorredica_p(Float.parseFloat(corredica_p.getText()));
           pedidoDTO.setFita_p(Float.parseFloat(fita_p.getText()));
           pedidoDTO.setCola_p(Float.parseFloat(cola_p.getText()));
           pedidoDTO.setParafuso_p(Float.parseFloat(parafuso_p.getText()));
           pedidoDTO.setDias_p(Float.parseFloat(dias_p.getText()));
           pedidoDTO.setFrete_p(Float.parseFloat(frete_p.getText()));
           
           JOptionPane.showMessageDialog(null, pedidoCTR.inserirPedido(pedidoDTO));
        }//fecha try
        catch (Exception e) {
            System.out.println("Erro ao Gravar" + e.getMessage());
        }//fecgha catch
    
    }
    
     
    /**
     * Creates new form PedidoVIEW
     */
    
    

    private void preenchaTabela(String nome){
        try {
            //limpa todas a as linhas
            modelo_jtl_consultar_cliente.setNumRows(0);
            
            pedidoDTO.setNome(nome);
            rs= pedidoCTR.consultarCliente(pedidoDTO, 1);
            while(rs.next()){
               modelo_jtl_consultar_cliente.addRow(new Object[]{
                   rs.getString("id_cli"),
                   rs.getString("nome_p"),
               });
            }
        }//fecha try 
        catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }//fecha cacth
        finally{
            pedidoCTR.CloseDB();
        }
    }//fecha preenchetabela
    
    
       private void preencheCampos(int id_cliente){
        try {
            pedidoDTO.setId_cli(id_cliente);
            rs = pedidoCTR.consultarCliente(pedidoDTO, 2);
            if(rs.next()){
                limpaCampos();
                
                nome_p.setText(rs.getString("nome_p"));
                chapaBranca_p.setText(rs.getString("chapabranca_p"));
                chapaCor_p.setText(rs.getString("chapacor_p"));
                fita_p.setText(rs.getString("fita_p"));
                parafuso_p.setText(rs.getString("parafuso_p"));
                corredica_p.setText(rs.getString("corredica_p"));
                cola_p.setText(rs.getString("cola_p"));
                dias_p.setText(rs.getString("dias_p"));
                frete_p.setText(rs.getString("frete_p"));
                
                
                gravar_alterar =2;
                liberaCampos(true);
            }
        }//fecha try 
        catch (Exception erTab) {
            System.out.println("Erro SQL: "+ erTab);
        }//fecha catch
        finally{
            pedidoCTR.CloseDB();
        }
    }//fecha preencheCampos
       
    private void alterar(){
        try{
           pedidoDTO.setNome(nome_p.getText());
           pedidoDTO.setChapaBranca_p(Float.parseFloat(chapaBranca_p.getText()));
           pedidoDTO.setChapaCor_p(Float.parseFloat(chapaCor_p.getText()));
           pedidoDTO.setCorredica_p(Float.parseFloat(corredica_p.getText()));
           pedidoDTO.setFita_p(Float.parseFloat(fita_p.getText()));
           pedidoDTO.setCola_p(Float.parseFloat(cola_p.getText()));
           pedidoDTO.setParafuso_p(Float.parseFloat(parafuso_p.getText()));
           pedidoDTO.setDias_p(Float.parseFloat(dias_p.getText()));
           pedidoDTO.setFrete_p(Float.parseFloat(frete_p.getText()));
           
           JOptionPane.showMessageDialog(null, pedidoCTR.alterarCliente(pedidoDTO));
        }//fecha try
        catch (Exception e) {
            System.out.println("Erro ao Gravar" + e.getMessage());
        }//fecgha catch
    
    }  
    
    
    private void excluir(){
        if(JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir o Pedido?","Aviso",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, pedidoCTR.excluirCliente(pedidoDTO)
            );
        }
    }//Fecha métado excluir()

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        corredica_p = new javax.swing.JTextField();
        Label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fita_p = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cola_p = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        parafuso_p = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dias_p = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        frete_p = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        nome_p = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMonstra = new javax.swing.JButton();
        chapaBranca_p = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_cliente = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chapaCor_p = new javax.swing.JTextField();
        pesquisa_nome_cliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel6.setText("Corrediça:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_2/imagens/arquivo-de-documento.png"))); // NOI18N
        btnPesquisar.setText("OK");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        Label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Label.setText("CONSULTAR");

        jLabel7.setText("Fita Borda(M)");

        jLabel8.setText("Cola:");

        cola_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cola_pActionPerformed(evt);
            }
        });

        jLabel9.setText("Parafuso");

        jLabel10.setText("Dias Trabalhados");

        jLabel11.setText("Frete");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_2/imagens/novo-arquivo (1).png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_2/imagens/salve-.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_2/imagens/cancelar (2).png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("CALCULO DE PREÇO");

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_2/imagens/lixo.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_2/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        btnMonstra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_2/imagens/bolsa-de-dinheiro.png"))); // NOI18N
        btnMonstra.setText(" PREÇO");
        btnMonstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonstraActionPerformed(evt);
            }
        });

        chapaBranca_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chapaBranca_pActionPerformed(evt);
            }
        });

        jLabel3.setText("Chapa Branca:");

        jtl_consultar_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_cliente);

        jLabel4.setText("Chapa Cor:");

        jLabel12.setText("Nome:");

        pesquisa_nome_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisa_nome_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMonstra, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(599, 599, 599)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(corredica_p, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(cola_p, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(dias_p, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(frete_p, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(74, 74, 74))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(10, 10, 10)
                                            .addComponent(nome_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(65, 65, 65))))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(chapaBranca_p, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(parafuso_p, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fita_p, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(chapaCor_p, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Label)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(pesquisa_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(pesquisa_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPesquisar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(nome_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(chapaBranca_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(chapaCor_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(fita_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(parafuso_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(corredica_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8))
                            .addComponent(cola_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel10))
                            .addComponent(dias_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11))
                            .addComponent(frete_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMonstra)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovo))
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        preenchaTabela(pesquisa_nome_cliente.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cola_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cola_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cola_pActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, true, true,true);
        gravar_alterar =1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(gravar_alterar==1){
            gravar();
            gravar_alterar=0;
        }else{
            if(gravar_alterar ==2){
                alterar();
                gravar_alterar = 0;
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro no Sistema");
            }
            
        }
        
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true,true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_cliente.setNumRows(0);
        liberaBotoes(true, false, false, false, true,false);
        gravar_alterar=0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true,false,false,false,true,false);
        modelo_jtl_consultar_cliente.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
        TelaLogin telaLogin = new TelaLogin();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnMonstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonstraActionPerformed
        pedidoDTO.setChapaBranca_p(Float.parseFloat(chapaBranca_p.getText()));
        pedidoDTO.setChapaCor_p(Float.parseFloat(chapaCor_p.getText()));
        pedidoDTO.setFita_p(Float.parseFloat(fita_p.getText()));
        pedidoDTO.setCola_p(Float.parseFloat(cola_p.getText()));
        pedidoDTO.setParafuso_p(Float.parseFloat(parafuso_p.getText()));
        pedidoDTO.setDias_p(Float.parseFloat(dias_p.getText()));
        pedidoDTO.setFrete_p(Float.parseFloat(frete_p.getText()));

        JOptionPane.showMessageDialog(null, pedidoCTR.CalculoPedido(pedidoDTO));

        liberaBotoes(true, false, false, false, true,true);
    }//GEN-LAST:event_btnMonstraActionPerformed

    private void chapaBranca_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapaBranca_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chapaBranca_pActionPerformed

    private void jtl_consultar_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_clienteMouseClicked
        preencheCampos(Integer.parseInt(String.valueOf(jtl_consultar_cliente.getValueAt(
        jtl_consultar_cliente.getSelectedRow(), 0))));
        liberaBotoes(false, true, true, true, true,true);
    }//GEN-LAST:event_jtl_consultar_clienteMouseClicked

    private void pesquisa_nome_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisa_nome_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisa_nome_clienteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculoPreço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculoPreço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculoPreço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculoPreço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculoPreço().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnMonstra;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField chapaBranca_p;
    private javax.swing.JTextField chapaCor_p;
    private javax.swing.JTextField cola_p;
    private javax.swing.JTextField corredica_p;
    private javax.swing.JTextField dias_p;
    private javax.swing.JTextField fita_p;
    private javax.swing.JTextField frete_p;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtl_consultar_cliente;
    private javax.swing.JTextField nome_p;
    private javax.swing.JTextField parafuso_p;
    private javax.swing.JTextField pesquisa_nome_cliente;
    // End of variables declaration//GEN-END:variables
}
