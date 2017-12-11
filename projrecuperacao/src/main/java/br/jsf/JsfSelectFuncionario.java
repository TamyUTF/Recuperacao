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
public class JsfSelectFuncionario {

    private int idfuncionario;
    private String descricao;

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
    
    public java.util.Collection<br.entity.Funcionario> getSelect(){
        return new br.crud.CrudFuncionario().SelectByDesc(this.descricao);
    }

}
