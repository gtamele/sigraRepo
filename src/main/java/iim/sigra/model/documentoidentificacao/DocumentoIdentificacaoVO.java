package iim.sigra.model.documentoidentificacao;

import java.util.Date;

import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.pessoa.PessoaVO;

public class DocumentoIdentificacaoVO {

	protected long selfId;
	protected String numero;
	protected Date emissao;
	protected Date validade;
	protected boolean vitalicio;
	protected String localEmissao;

	protected TipoDocIdentificacaoVO tipoDoc;
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

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
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
