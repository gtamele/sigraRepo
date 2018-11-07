package iim.sigra.model.matricula;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.pagamento.PagamentoVO;
import iim.sigra.model.processo.ProcessoVO;

@Entity
@Table(name ="MATRICULA")
public class MatriculaVO {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected int anoLectivo;
	protected LocalDate dataExecucao;
	protected String estadoMatricula;
	

	@OneToOne
	@JoinColumn(name="id_pagamento")
	@Cascade(CascadeType.ALL)
	protected PagamentoVO pagamento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_processo")
	protected ProcessoVO processo;
	
	@Transient
	protected LocalDate localDate = LocalDate.now();
	
	
	
	public MatriculaVO(){
		
		this.anoLectivo = localDate.getYear();
		this.dataExecucao = localDate.now();
	}
	

	public MatriculaVO(long selfId, int anoLectivo, LocalDate dataExecucao, String estadoMatricula,
			LocalDate locaDate, PagamentoVO pagamento, ProcessoVO processo) {
	
		this.selfId = selfId;
		this.anoLectivo = locaDate.getYear();
		this.dataExecucao = dataExecucao;
		this.estadoMatricula = estadoMatricula;
		this.pagamento = pagamento;
		this.processo = processo;
	}




	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}


	public int getAnoLectivo() {
		return anoLectivo;
	}


	public void setAnoLectivo(int anoLectivo) {
		this.anoLectivo = anoLectivo;
	}


	public LocalDate getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(LocalDate dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public String getEstadoMatricula() {
		return estadoMatricula;
	}

	public void setEstadoMatricula(String estadoMatricula) {
		this.estadoMatricula = estadoMatricula;
	}

	public PagamentoVO getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoVO pagamento) {
		this.pagamento = pagamento;
	}


	public ProcessoVO getProcesso() {
		return processo;
	}


	public void setProcesso(ProcessoVO processo) {
		this.processo = processo;
	}
	
	

}
