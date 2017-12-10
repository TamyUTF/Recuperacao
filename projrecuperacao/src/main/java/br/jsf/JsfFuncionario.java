/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.entity.Funcionario;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class JsfFuncionario {
    private int idfuncionario;
    private String desc;

    public JsfFuncionario() {
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void persist() {
        Funcionario f = new Funcionario();
        f.setIdfuncionario(idfuncionario);
        f.setDescricao(desc);
        new br.crud.CrudFuncionario().persist(f);
    }

}
