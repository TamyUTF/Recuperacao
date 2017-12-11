package br.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Cliente.findAll", query = "SELECT c FROM Cliente c")
   ,@NamedQuery(name="Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE UPPER(FUNCTION('TRANSLATE', c.nome, 'ÁÀÃÂÄáàãâäÍÌÏíìïÚÙÜúùüÉÈÊËéèêëÓÒÕÔÖóòõôöÇç', 'AAAAAaaaaaIIIiiiUUUuuuEEEEeeeeOOOOOoooooCc')) LIKE :nome")
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
private char sexo;
@Column(name="nasc")
@Temporal(TemporalType.DATE)
private Date nasc;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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
