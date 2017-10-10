package iim.sigra.model.pedido;

import java.util.Date;

import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;

public class PedidoVO {

	protected long selfId;
	protected Date data;
	protected double taxa;
	protected TipoPedidoVO tipoPedido;
	protected EstudanteVO requerente;
	

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

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public TipoPedidoVO getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedidoVO tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public EstudanteVO getRequerente() {
		return requerente;
	}

	public void setRequerente(EstudanteVO requerente) {
		this.requerente = requerente;
	}

}
