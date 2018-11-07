package iim.sigra.model.processo;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.matricula.MatriculaVO;
import iim.sigra.model.pedido.PedidoVO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;

@Entity
@Table(name = "PROCESSO")
public class ProcessoVO {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected LocalDate dataCriacao;
	
	@OneToOne
	@JoinColumn(name="id_estudante")
	@Cascade(CascadeType.ALL)
	protected EstudanteVO estudante;
	
	
	@OneToMany(mappedBy="processo", fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	protected Collection<MatriculaVO> matriculas;
	
	@OneToMany(mappedBy="processo", fetch = FetchType.LAZY)
	@Cascade(CascadeType.DELETE)
	protected Collection<PedidoVO> pedidos;
	
	
	public ProcessoVO(){
		this.dataCriacao = LocalDate.now();
	}
	
	

	public ProcessoVO(long selfId, LocalDate dataCriacao, EstudanteVO estudante) {
		this.selfId = selfId;
		this.dataCriacao = LocalDate.now();
		this.estudante = estudante;
	}

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public EstudanteVO getEstudante() {
		return estudante;
	}

	public void setEstudante(EstudanteVO estudante) {
		this.estudante = estudante;
	}
	
	

	public Collection<MatriculaVO> getMatriculas() {
		return matriculas;
	}


	public void setMatriculas(Collection<MatriculaVO> matriculas) {
		this.matriculas = matriculas;
	}



	@Override
	public String toString() {
		
		return "SelfId "+this.selfId+" Data de Criação "+this.dataCriacao+" Estudante ID "+this.estudante.getSelfId();
	}

}
