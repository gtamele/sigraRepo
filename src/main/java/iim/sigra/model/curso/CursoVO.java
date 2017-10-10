package iim.sigra.model.curso;

import iim.sigra.model.departamento.DepartamentoVO;

public class CursoVO {

	protected long selfId;
	protected String codigo;
	protected String designacao;
	protected int duracaoNumSemestres;
	protected DepartamentoVO dept;

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public int getDuracaoNumSemestres() {
		return duracaoNumSemestres;
	}

	public void setDuracaoNumSemestres(int duracaoNumSemestres) {
		this.duracaoNumSemestres = duracaoNumSemestres;
	}

	public DepartamentoVO getDept() {
		return dept;
	}

	public void setDept(DepartamentoVO dept) {
		this.dept = dept;
	}

}
