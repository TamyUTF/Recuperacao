package br.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Cliente.findAll", query = "SELECT c FROM Cliente c")
   ,@NamedQuery(name="Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome")
})
public class Cliente implements Serializable{
    
 private static final long serialVersionUID = 1L;
 
@Id
@Basic(optional=false)
@NotNull
@Column(name="idcliente")
private Integer idcliente;
@Size(max = 50)
@Column(name="nome")
private String nome;
@Column(name="sexo")
private String sexo;
@Column(name="nasc")
private String nasc;
@Column(name="fkfuncionario")
private int fkfuncionario;

    public Cliente() {}    

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
