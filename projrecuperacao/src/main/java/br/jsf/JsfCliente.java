/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.entity.Cliente;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class JsfCliente {

    private int idcliente;
    private int fkfuncionario;
    private String nome;
    private Date nasc;
    private char sexo;

    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public JsfCliente() {
    }


    public void persist(){
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setSexo(sexo);
        c.setIdcliente(idcliente);
        c.setNasc(nasc);
        c.setFkfuncionario(fkfuncionario);
        new br.crud.CrudCliente().persist(c);
        this.nome = "";
        this.idcliente=0;
        this.nasc=null;
        this.fkfuncionario=0;
    }
    
    public java.util.Collection<br.entity.Cliente> getAll(){
        return new br.crud.CrudCliente().getAll();
    }
    
    public void remove(br.entity.Cliente cli){
        new br.crud.CrudCliente().remove(cli);
    }
    
    public String update(br.entity.Cliente cli){
        this.idcliente = cli.getIdcliente();
        this.nome = cli.getNome();
        this.nasc= cli.getNasc();
        this.fkfuncionario= cli.getFkfuncionario();
        this.sexo = cli.getSexo();
        return "merge.xhtml";
    }
    
    public void merge(){
        br.entity.Cliente cli = new br.entity.Cliente();
        cli.setIdcliente(idcliente);
        cli.setFkfuncionario(fkfuncionario);
        cli.setNome(nome);
        cli.setNasc(nasc);
        cli.setSexo(sexo);
        new br.crud.CrudCliente().merge(cli);
        this.nome = "";
        this.idcliente=0;
        this.nasc=null;
        this.fkfuncionario=0;
        
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

    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    public int getFkfuncionario() {
        return fkfuncionario;
    }

    public void setFkfuncionario(int fkfuncionario) {
        this.fkfuncionario = fkfuncionario;
    }
    
}
