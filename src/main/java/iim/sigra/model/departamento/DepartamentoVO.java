package iim.sigra.model.departamento;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.especialidade.EspecialidadeVO;

@Entity
@Table(name = "DEPARTAMENTO")
public class DepartamentoVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected String designacao;
	protected String descricao;
	
	@OneToMany(mappedBy="departamento", fetch = FetchType.LAZY)
	protected Collection<EspecialidadeVO> especialidades;
	
	
	public DepartamentoVO(){}
	
	public DepartamentoVO(String str){
		
		this.selfId= Long.parseLong(str);
		
	}
	

	public DepartamentoVO(long selfId, String designacao, String descricao,
			Collection<EspecialidadeVO> especialidades) {
		this.selfId = selfId;
		this.designacao = designacao;
		this.descricao = descricao;
		this.especialidades = especialidades;
	}

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
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

	public Collection<EspecialidadeVO> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Collection<EspecialidadeVO> especialidades) {
		this.especialidades = especialidades;
	}
	
	
	
	/**
	@Override
	public String toString() {
		
		return "selfId: "+this.selfId+" designacao: "+this.descricao+" descricao:"+this.descricao;
	}
	**/
}
