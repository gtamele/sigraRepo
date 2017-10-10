package iim.sigra.model.disciplina;

public class DisciplinaVO {
	
	protected long selfId;
	protected String codigo;
	protected String designacao;
	protected String descricao;
	protected boolean isTecnica;
	protected String duracaoLectiva;
	
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isTecnica() {
		return isTecnica;
	}

	public void setTecnica(boolean isTecnica) {
		this.isTecnica = isTecnica;
	}

	public String getDuracaoLectiva() {
		return duracaoLectiva;
	}

	public void setDuracaoLectiva(String duracaoLectiva) {
		this.duracaoLectiva = duracaoLectiva;
	}
	
	
}
