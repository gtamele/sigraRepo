package iim.sigra.model.matricula;

import java.util.Date;

import iim.sigra.model.curso.CursoVO;
import iim.sigra.model.pagamento.PagamentoVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;

public class MatriculaVO {

	protected long selfId;
	protected Date data;
	protected int nivel;
	protected double taxa;
	protected String proveniencia;
	protected int previousNivel;
	protected String turma;
	protected int num;

	protected EstudanteVO estudante;
	protected CursoVO curso;
	protected PagamentoVO pagamento;
	

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public String getProveniencia() {
		return proveniencia;
	}

	public void setProveniencia(String proveniencia) {
		this.proveniencia = proveniencia;
	}

	public int getPreviousNivel() {
		return previousNivel;
	}

	public void setPreviousNivel(int previousNivel) {
		this.previousNivel = previousNivel;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public EstudanteVO getEstudante() {
		return estudante;
	}

	public void setEstudante(EstudanteVO estudante) {
		this.estudante = estudante;
	}

	public CursoVO getCurso() {
		return curso;
	}

	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}

	public PagamentoVO getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoVO pagamento) {
		this.pagamento = pagamento;
	}

}
