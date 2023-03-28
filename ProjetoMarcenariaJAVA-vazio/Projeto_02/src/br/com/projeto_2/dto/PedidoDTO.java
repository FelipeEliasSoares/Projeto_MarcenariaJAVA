/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dto;

/**
 *
 * @author Aluno
 */
public class PedidoDTO {
    private String nome;
    private int id_cli,numero_cli;

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public int getNumero_cli() {
        return numero_cli;
    }

    public void setNumero_cli(int numero_cli) {
        this.numero_cli = numero_cli;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getChapaBranca_p() {
        return chapaBranca_p;
    }

    public void setChapaBranca_p(float chapaBranca_p) {
        this.chapaBranca_p = chapaBranca_p;
    }

    public float getChapaCor_p() {
        return chapaCor_p;
    }

    public void setChapaCor_p(float chapaCor_p) {
        this.chapaCor_p = chapaCor_p;
    }

    public float getCorredica_p() {
        return corredica_p;
    }

    public void setCorredica_p(float corredica_p) {
        this.corredica_p = corredica_p;
    }

    public float getFita_p() {
        return fita_p;
    }

    public void setFita_p(float fita_p) {
        this.fita_p = fita_p;
    }

    public float getCola_p() {
        return cola_p;
    }

    public void setCola_p(float cola_p) {
        this.cola_p = cola_p;
    }

    public float getParafuso_p() {
        return parafuso_p;
    }

    public void setParafuso_p(float parafuso_p) {
        this.parafuso_p = parafuso_p;
    }

    public float getDias_p() {
        return dias_p;
    }

    public void setDias_p(float dias_p) {
        this.dias_p = dias_p;
    }

    public float getFrete_p() {
        return frete_p;
    }

    public void setFrete_p(float frete_p) {
        this.frete_p = frete_p;
    }
    private float chapaBranca_p,chapaCor_p,corredica_p,fita_p,cola_p,parafuso_p,dias_p,frete_p;
}
