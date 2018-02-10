package iim.sigra.model.parametrizacao.tipopagamento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TIPOPAGAMENTO")
public class TipoPagamentoVO {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	@NotNull
	protected String designacao;
	protected String descricao;
	

	public TipoPagamentoVO() {
		
	}
	


	
	public TipoPagamentoVO(long selfId, @NotNull String designacao, String descricao, LocalDate data) {
		super();
		this.selfId = selfId;
		this.designacao = designacao;
		this.descricao = descricao;
	}



	public TipoPagamentoVO(HttpServletRequest rq) {
			
		}
	
	
	public TipoPagamentoVO(long SelfId, String designacao, String descricao){
		
		this.selfId = 0;
		this.designacao = designacao;
		this.descricao = descricao;
		
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
	
	

	@Override
	public boolean equals(Object object) {
		
		TipoPagamentoVO tipo = (TipoPagamentoVO) object;
		
		return (this.selfId==tipo.selfId && tipo.selfId!=0) || (this.designacao!=null && this.designacao.equalsIgnoreCase(tipo.designacao));
	}
	
	@Override
	public String toString() {
		
		return "SelfId: "+this.selfId +","+" Designação: "+this.designacao +","+" Descrição: "+this.descricao;
	}

}
