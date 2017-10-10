package iim.sigra.model.pagamento;

import java.util.Date;

import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;

public class PagamentoVO {

	protected long selfId;
	protected Date data;
	protected String descricao;
	protected TipoPagamentoVO tipoPagamento;
	

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoPagamentoVO getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamentoVO tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

}
