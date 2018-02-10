package iim.sigra.model.processo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	protected EstudanteVO estudante;
	

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
	



}
