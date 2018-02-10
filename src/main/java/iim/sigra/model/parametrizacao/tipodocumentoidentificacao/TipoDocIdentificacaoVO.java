package iim.sigra.model.parametrizacao.tipodocumentoidentificacao;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.documentoidentificacao.DocumentoIdentificacaoVO;

@Entity
@Table(name="TIPO_DOC_IDENT")
public class TipoDocIdentificacaoVO {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	protected String designacao;
	protected String descricao;
	
	@OneToMany(mappedBy="tipoDoc", fetch = FetchType.LAZY)
	protected Collection<DocumentoIdentificacaoVO> docsIdent;
	
	
	
	public TipoDocIdentificacaoVO() {
		
	}
	
	public TipoDocIdentificacaoVO(String str) {
		
		this.selfId= Long.parseLong(str);	
	}
		
		

	public TipoDocIdentificacaoVO(long selfId, String designacao, String descricao,
			Collection<DocumentoIdentificacaoVO> docsIdent) {
		super();
		this.selfId = selfId;
		this.designacao = designacao;
		this.descricao = descricao;
		this.docsIdent = docsIdent;
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

	public Collection<DocumentoIdentificacaoVO> getDocsIdent() {
		return docsIdent;
	}

	public void setDocsIdent(Collection<DocumentoIdentificacaoVO> docsIdent) {
		this.docsIdent = docsIdent;
	}
	
	

}
