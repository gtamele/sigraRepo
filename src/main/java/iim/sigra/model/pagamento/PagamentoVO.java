package iim.sigra.model.pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import iim.sigra.model.matricula.MatriculaVO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;


@Entity
@Table(name ="PAGAMENTO")
public class PagamentoVO {
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	protected LocalDate dataPagamento;
	protected long numComprovativo;
	protected BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipopagamento")
	protected TipoPagamentoVO tipoPagamento;
	
	
	@OneToOne(mappedBy="pagamento")
	protected MatriculaVO matricula;

	
	
	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}


	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public long getNumComprovativo() {
		return numComprovativo;
	}

	public void setNumComprovativo(long numComprovativo) {
		this.numComprovativo = numComprovativo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoPagamentoVO getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamentoVO tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public MatriculaVO getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculaVO matricula) {
		this.matricula = matricula;
	}
	
	

}
