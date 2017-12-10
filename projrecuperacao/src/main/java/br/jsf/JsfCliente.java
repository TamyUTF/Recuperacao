/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.entity.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class JsfCliente {
    private int idcliente;
    private String nome;
    private String nasc;
    private int fkfuncionario;


    public JsfCliente() {
    }
    
    
    public void persist(){
        Cliente c = new Cliente();
        c.setSexo(nome);
        c.setIdcliente(idcliente);
        c.setNasc(nasc);
        c.setFkfuncionario(fkfuncionario);
        new br.crud.CrudCliente().persist(c);
        this.nome = "";
        
        
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public int getFkfuncionario() {
        return fkfuncionario;
    }

    public void setFkfuncionario(int fkfuncionario) {
        this.fkfuncionario = fkfuncionario;
    }
    
}
