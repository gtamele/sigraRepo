package iim.sigra.model.parametrizacao.tipopedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import iim.sigra.model.pedido.PedidoVO;

@Entity
@Table(name = "TIPOPEDIDO")
public class TipoPedidoVO {
	
	
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected String designacao;
	protected String descricao;
	@DateTimeFormat(pattern="dd/MM/yyyy")	

	
	@OneToMany(mappedBy="tipoPedido", fetch = FetchType.LAZY)
//	@Cascade(CascadeType.DELETE)
	protected Collection<PedidoVO> pedidos;
	
	@Transient
	protected int discSeleccionadas[] ;
	
	
	public TipoPedidoVO() {
		
	}
	
	public TipoPedidoVO(String str){
		
		this.selfId = Long.parseLong(str);
		
	}
	

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


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	


	public Collection<PedidoVO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<PedidoVO> pedidos) {
		this.pedidos = pedidos;
	}
	

	public int[] getDiscSeleccionadas() {
		return discSeleccionadas;
	}

	public void setDiscSeleccionadas(int[] discSeleccionadas) {
		this.discSeleccionadas = discSeleccionadas;
	}

	@Override
	public String toString() {
		
		return "SelfId: "+this.selfId +","+" Designação: "+this.designacao +","+" Descrição: "+this.descricao;
	}

}
