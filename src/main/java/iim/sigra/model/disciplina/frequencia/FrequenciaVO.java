package iim.sigra.model.disciplina.frequencia;

import iim.sigra.model.disciplina.inscricao.InscricaoVO;

public class FrequenciaVO {

	protected long selfId;
	protected double notaFinal;
	protected String resultadoFinal;
	protected InscricaoVO idIinscricao;
	
	

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(String resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public InscricaoVO getIdIinscricao() {
		return idIinscricao;
	}

	public void setIdIinscricao(InscricaoVO idIinscricao) {
		this.idIinscricao = idIinscricao;
	}

}
