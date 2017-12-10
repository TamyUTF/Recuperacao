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

/**
 *
 * @author Tamy
 */
@Entity
@Table(name="funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Funcionario.all", query="SELECT f FROM funcionario f")
   ,@NamedQuery(name="Funcionario.findDesc", query="SELECT f FROM funcionario f WHERE f.desc = :desc")
})
public class Funcionario implements Serializable{
    
private static final long serialVersionUID = 1L;
@Id
@Basic(optional=false)
@NotNull
@Column(name="idfuncionario")
private Integer idfuncionario;
@Size(max=20)
@Column(name="descricao")
private String descricao;

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
