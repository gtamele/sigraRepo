package iim.sigra.model.disciplina.inscricao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.disciplina.DisciplinaVO;
import iim.sigra.model.pagamento.PagamentoVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;


@Entity
@Table(name = "INSCRICAO")
public class InscricaoVO {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected LocalDate dataInscricao;
	
	protected double taxaInscricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_estudante", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	protected  EstudanteVO estudante;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_disciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	protected DisciplinaVO disciplina;
	
	@Transient
	protected ArrayList<DisciplinaVO> discSeleccionadas;
	

	
//	protected PagamentoVO pagamento;
	
	
	public InscricaoVO() {
		
		this.dataInscricao = LocalDate.now();
	}
	
	
	public InscricaoVO(long selfId, LocalDate dataInscricao, double taxaInscricao, EstudanteVO estudante,
			DisciplinaVO disciplina, ArrayList<DisciplinaVO> discSeleccionadas) {
		super();
		this.selfId = selfId;
		this.dataInscricao = LocalDate.now();
		this.taxaInscricao = taxaInscricao;
		this.estudante = estudante;
		this.disciplina = disciplina;
		this.discSeleccionadas = discSeleccionadas;
	}



	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}


	public LocalDate getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(LocalDate dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public DisciplinaVO getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaVO disciplina) {
		this.disciplina = disciplina;
	}



	public double getTaxaInscricao() {
		return taxaInscricao;
	}

	public void setTaxaInscricao(double taxaInscricao) {
		this.taxaInscricao = taxaInscricao;
	}

	public EstudanteVO getEstudante() {
		return estudante;
	}

	public void setEstudante(EstudanteVO estudante) {
		this.estudante = estudante;
	}


	public ArrayList<DisciplinaVO> getDiscSeleccionadas() {
		return discSeleccionadas;
	}


	public void setDiscSeleccionadas(ArrayList<DisciplinaVO> discSeleccionadas) {
		this.discSeleccionadas = discSeleccionadas;
	}

	
	

}
