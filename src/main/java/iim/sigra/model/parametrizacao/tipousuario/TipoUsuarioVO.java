package iim.sigra.model.parametrizacao.tipousuario;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.usuario.UsuarioVO;


@Entity
@Table(name = "TIPOUSUARIO")
public class TipoUsuarioVO {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	@NotNull
	protected String designacao;
	protected String descricao;
	
	@OneToMany(mappedBy="tipoUsuario", fetch = FetchType.LAZY)
	protected Collection<UsuarioVO> usuarios;
	

	public TipoUsuarioVO() {
		
	}
	
	public TipoUsuarioVO(String str) {
		
		this.selfId = Long.parseLong(str);
		
	}
	
	public TipoUsuarioVO(HttpServletRequest rq) {
		
	}
	
	public TipoUsuarioVO(long SelfId, String designacao, String descricao){
		
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
		
		TipoUsuarioVO tipo = (TipoUsuarioVO) object;
		
		return (this.selfId==tipo.selfId && tipo.selfId!=0) || (this.designacao!=null && this.designacao.equalsIgnoreCase(tipo.designacao));
	}
	
	@Override
	public String toString() {
		
		return "SelfId: "+this.selfId +","+" Designação: "+this.designacao +","+" Descrição: "+this.descricao;
	}


}
