/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tamy
 */

@ManagedBean
@RequestScoped
public class JsfFuncionario {
    private int idfuncionario;
    private String descricao;

    public JsfFuncionario() {
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void persist() {
        br.entity.Funcionario f = new br.entity.Funcionario();
        f.setIdfuncionario(idfuncionario);
        f.setDescricao(descricao);
        new br.crud.CrudFuncionario().persist(f);
        this.idfuncionario=0;
        this.descricao = "";
    }
    
    public java.util.Collection<br.entity.Funcionario> getAll(){
        return new br.crud.CrudFuncionario().getAll();
    }
    
    public void remove(br.entity.Funcionario func){
        new br.crud.CrudFuncionario().remove(func);
    }
    
    public String update(br.entity.Funcionario func){
        this.idfuncionario = func.getIdfuncionario();
        this.descricao = func.getDescricao();
        return "merge.xhtml";
    }
    
    public void merge(){
        br.entity.Funcionario f = new br.entity.Funcionario();
        f.setIdfuncionario(idfuncionario);
        f.setDescricao(descricao);
        new br.crud.CrudFuncionario().merge(f);
        this.descricao = "";
        this.idfuncionario = 0;    
    }

}
