package iim.sigra.model.pedido;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.processo.ProcessoVO;

@Entity
@Table(name = "PEDIDO")
public class PedidoVO {
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	@DateTimeFormat(pattern="dd/mm/yyyy")
	protected LocalDate dataEmissao;
	protected String cabecalho;
	protected String texto;
	protected String diferimento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipoPedido")
	protected TipoPedidoVO tipoPedido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_processo")
	protected ProcessoVO processo;
	
	
	public PedidoVO(){
		
		this.dataEmissao = LocalDate.now();
	}
	
	
	public long getSelfId() {
		return selfId;
	}
	
	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}
	
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}
	
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	public String getCabecalho() {
		return cabecalho;
	}
	
	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getDiferimento() {
		return diferimento;
	}
	
	public void setDiferimento(String diferimento) {
		this.diferimento = diferimento;
	}
	
	public TipoPedidoVO getTipoPedido() {
		return tipoPedido;
	}
	
	public void setTipoPedido(TipoPedidoVO tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	
	public ProcessoVO getProcesso() {
		return processo;
	}
	
	public void setProcesso(ProcessoVO processo) {
		this.processo = processo;
	}
	
	
	
	

}
