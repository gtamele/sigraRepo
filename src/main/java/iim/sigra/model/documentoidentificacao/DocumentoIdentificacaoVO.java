package iim.sigra.model.documentoidentificacao;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.pessoa.PessoaVO;

@Entity
@Table(name="DOCUMENTO_IDENTIFICACAO")
public class DocumentoIdentificacaoVO {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	protected String numero;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	protected LocalDate emissao;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	protected LocalDate validade;
	
	protected boolean vitalicio;
	protected String localEmissao;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipoDoc")
	protected TipoDocIdentificacaoVO tipoDoc;
	
	@OneToOne
	@JoinColumn(name="id_pessoa")
	protected PessoaVO pessoa;

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public LocalDate getEmissao() {
		return emissao;
	}

	public void setEmissao(LocalDate emissao) {
		this.emissao = emissao;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public boolean isVitalicio() {
		return vitalicio;
	}

	public void setVitalicio(boolean vitalicio) {
		this.vitalicio = vitalicio;
	}

	public String getLocalEmissao() {
		return localEmissao;
	}

	public void setLocalEmissao(String localEmissao) {
		this.localEmissao = localEmissao;
	}
	

	public TipoDocIdentificacaoVO getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocIdentificacaoVO tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public PessoaVO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaVO pessoa) {
		this.pessoa = pessoa;
	}


}
