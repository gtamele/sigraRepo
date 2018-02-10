package iim.sigra.model.pessoa.estudante;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.processo.ProcessoVO;

@Entity
@Table(name = "ESTUDANTE")
public class EstudanteVO extends PessoaVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	protected long selfId;
	protected boolean trabalhador;
	protected String localTrabalho;
	protected String profissao;
	protected String localTrab;
	
//	protected CursoVO especialidade
	protected String especialidade;
	protected String turno;
	protected String encarregadoNome;
	protected String encarregadoProfissao;
	protected String encarregadoCell;
	protected String encarregadoTelf;
	
	@OneToOne(mappedBy="estudante")
	@Cascade(CascadeType.ALL)
	protected ProcessoVO processo;
	
	@OneToOne
	@JoinColumn(name="id_pessoa")
	protected PessoaVO pessoa;
	
	
	public long getSelfId() {
		return selfId;
	}
	
	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}
	
	public boolean isTrabalhador() {
		return trabalhador;
	}
	
	public void setTrabalhador(boolean trabalhador) {
		this.trabalhador = trabalhador;
	}
	

	public String getLocalTrabalho() {
		return localTrabalho;
	}
	
	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}
	
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public String getLocalTrab() {
		return localTrab;
	}
	
	public void setLocalTrab(String localTrab) {
		this.localTrab = localTrab;
	}
	
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getEncarregadoNome() {
		return encarregadoNome;
	}
	
	public void setEncarregadoNome(String encarregadoNome) {
		this.encarregadoNome = encarregadoNome;
	}
	
	public String getEncarregadoProfissao() {
		return encarregadoProfissao;
	}
	
	public void setEncarregadoProfissao(String encarregadoProfissao) {
		this.encarregadoProfissao = encarregadoProfissao;
	}
	
	public String getEncarregadoCell() {
		return encarregadoCell;
	}
	
	public void setEncarregadoCell(String encarregadoCell) {
		this.encarregadoCell = encarregadoCell;
	}
	
	public String getEncarregadoTelf() {
		return encarregadoTelf;
	}
	
	public void setEncarregadoTelf(String encarregadoTelf) {
		this.encarregadoTelf = encarregadoTelf;
	}
	
	
	
	
	
	
	
	

}
