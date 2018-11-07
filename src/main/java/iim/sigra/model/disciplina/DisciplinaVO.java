package iim.sigra.model.disciplina;

import java.io.Serializable;
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

import iim.sigra.model.disciplina.inscricao.InscricaoVO;

@Entity
@Table(name = "DISCIPLINA")
public class DisciplinaVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected String codigo;
	protected String designacao;
	protected String descricao;
	protected int cargaHoraria;
	protected boolean tecnica;
	protected String duracaoLectiva;
	
	@OneToMany(mappedBy="disciplina", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	protected Collection<InscricaoVO> inscricoes;
	
	
	
	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public boolean isTecnica() {
		return tecnica;
	}

	public void setTecnica(boolean tecnica) {
		this.tecnica = tecnica;
	}

	public String getDuracaoLectiva() {
		return duracaoLectiva;
	}

	public void setDuracaoLectiva(String duracaoLectiva) {
		this.duracaoLectiva = duracaoLectiva;
	}
	
	
}
