package iim.sigra.model.endereco;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.pessoa.PessoaVO;

@Entity
@Table(name = "Endereco")
public class EnderecoVO {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected String nomeRuaAvenida;
	protected int numeroRuaAvenida;
	protected String bairro;
	protected int numQuarteirao;
	protected int andar;
	protected int numeroCasa;

	
	@OneToMany(mappedBy="endereco", fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	protected Collection<PessoaVO> pessoas;
	
	

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public String getNomeRuaAvenida() {
		return nomeRuaAvenida;
	}

	public void setNomeRuaAvenida(String nomeRuaAvenida) {
		this.nomeRuaAvenida = nomeRuaAvenida;
	}

	public int getNumeroRuaAvenida() {
		return numeroRuaAvenida;
	}

	public void setNumeroRuaAvenida(int numeroRuaAvenida) {
		this.numeroRuaAvenida = numeroRuaAvenida;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public int getNumQuarteirao() {
		return numQuarteirao;
	}

	public void setNumQuarteirao(int numQuarteirao) {
		this.numQuarteirao = numQuarteirao;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	

	public Collection<PessoaVO> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Collection<PessoaVO> pessoas) {
		this.pessoas = pessoas;
	}

	

}
