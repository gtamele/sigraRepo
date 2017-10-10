package iim.sigra.model.disciplina.inscricao;

import java.util.Date;

import iim.sigra.model.pagamento.PagamentoVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;

public class InscricaoVO {
	
	protected long selfId;
	protected String codigo;
	protected Date data;
	protected double taxaInscricao;
	protected  EstudanteVO estudante;
	protected PagamentoVO pagamento;
	
	
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getTaxaInscricao() {
		return taxaInscricao;
	}

	public void setTaxaInscricao(double taxaInscricao) {
		this.taxaInscricao = taxaInscricao;
	}

	public EstudanteVO getEstudante() {
		return estudante;
	}

	public void setEstudante(EstudanteVO estudante) {
		this.estudante = estudante;
	}

	public PagamentoVO getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoVO pagamento) {
		this.pagamento = pagamento;
	}
	

}
