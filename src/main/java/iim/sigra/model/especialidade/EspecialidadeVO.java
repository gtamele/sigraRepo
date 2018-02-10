package iim.sigra.model.especialidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.departamento.DepartamentoVO;

@Entity
@Table(name = "ESPECIALIDADE")
public class EspecialidadeVO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected String designacao;
	protected String codigo;
	protected String descricao;
	protected int numSemestresdiurno;
	protected int numSemestresNocturno;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_departamento")
	protected DepartamentoVO departamento;
	

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}


	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public int getNumSemestresdiurno() {
		return numSemestresdiurno;
	}

	public void setNumSemestresdiurno(int numSemestresdiurno) {
		this.numSemestresdiurno = numSemestresdiurno;
	}

	public int getNumSemestresNocturno() {
		return numSemestresNocturno;
	}

	public void setNumSemestresNocturno(int numSemestresNocturno) {
		this.numSemestresNocturno = numSemestresNocturno;
	}

	public DepartamentoVO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoVO departamento) {
		this.departamento = departamento;
	}

	

}
