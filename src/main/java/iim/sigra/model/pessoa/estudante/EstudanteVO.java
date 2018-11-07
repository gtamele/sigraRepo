package iim.sigra.model.pessoa.estudante;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import iim.sigra.model.disciplina.inscricao.InscricaoVO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.processo.ProcessoVO;

@Entity
@Table(name = "ESTUDANTE")
@PrimaryKeyJoinColumn(name = "id_estudante")
public class EstudanteVO extends PessoaVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected boolean trabalhador;
	protected String profissao;
	protected String localTrab;
	
	protected String turno;
	protected String encarregadoNome;
	protected String encarregadoProfissao;
	protected String encarregadoCell;
	protected String encarregadoTelf;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Especialidade")
	protected EspecialidadeVO especialidade;
	
	@OneToOne(mappedBy="estudante")
	@Cascade(CascadeType.ALL)
	protected ProcessoVO processo;
	
	
	@OneToMany(mappedBy="estudante", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	protected Collection<InscricaoVO> inscricoes;
	
	
	
	
	public boolean isTrabalhador() {
		return trabalhador;
	}


	public void setTrabalhador(boolean trabalhador) {
		this.trabalhador = trabalhador;
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
	

	public EspecialidadeVO getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeVO especialidade) {
		this.especialidade = especialidade;
	}

	public ProcessoVO getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoVO processo) {
		this.processo = processo;
	}

	

}
