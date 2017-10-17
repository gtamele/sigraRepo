package iim.sigra.model.pessoa.estudante;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import iim.sigra.model.pessoa.PessoaVO;

@Entity
public class EstudanteVO extends PessoaVO{
	
	@Id
	@GeneratedValue
	protected long selfId;
	protected String codEstudante;
	protected boolean isTrabalhador;
	protected String localTrabalho;
	
	
	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public String getCodEstudante() {
		return codEstudante;
	}

	public void setCodEstudante(String codEstudante) {
		this.codEstudante = codEstudante;
	}

	public boolean isTrabalhador() {
		return isTrabalhador;
	}

	public void setTrabalhador(boolean isTrabalhador) {
		this.isTrabalhador = isTrabalhador;
	}

	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

}
