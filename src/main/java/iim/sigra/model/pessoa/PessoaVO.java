package iim.sigra.model.pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import iim.sigra.model.documentoidentificacao.DocumentoIdentificacaoVO;
import iim.sigra.model.endereco.EnderecoVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;

@Entity
@Table(name ="PESSOA")
@Inheritance(strategy=InheritanceType.JOINED)
public class PessoaVO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	@NotNull
	protected String apelido;
	@NotNull
	protected String nome;
	protected char genero;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	protected LocalDate dataNascimento;
	
	protected String estadoCivil;
	protected String nomePai;
	protected String nomeMae;
	protected String nacionalidade;
	protected String naturalidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_endereco", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.ALL)
	protected EnderecoVO endereco;
						 
	
	@OneToOne(mappedBy="pessoa")
	@Cascade(CascadeType.ALL)
	protected DocumentoIdentificacaoVO documento;
	
	@OneToOne(mappedBy="pessoa")
	protected EstudanteVO estudante;
	
	
	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	
	public EnderecoVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}
	
	
	public DocumentoIdentificacaoVO getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoIdentificacaoVO documento) {
		this.documento = documento;
	}
	

	
}
