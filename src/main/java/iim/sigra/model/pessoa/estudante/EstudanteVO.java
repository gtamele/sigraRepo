package iim.sigra.model.pessoa.estudante;

import iim.sigra.model.pessoa.PessoaVO;

public class EstudanteVO extends PessoaVO{

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
