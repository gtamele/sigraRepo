package iim.sigra.model.contacto;

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

import iim.sigra.model.pessoa.PessoaVO;

@Entity
@Table(name = "Contacto")
public class ContactoVO {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected String telfCell;
	protected String telfFixo;
	protected String fax;
	protected String email;
	
	@OneToMany(mappedBy="contacto", fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	protected Collection<PessoaVO> pessoas;
	
	
	public long getSelfId() {
		return selfId;
	}
	
	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}
	
	public String getTelfCell() {
		return telfCell;
	}
	
	public void setTelfCell(String telfCell) {
		this.telfCell = telfCell;
	}
	
	public String getTelfFixo() {
		return telfFixo;
	}
	
	public void setTelfFixo(String telfFixo) {
		this.telfFixo = telfFixo;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<PessoaVO> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Collection<PessoaVO> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	
	
	

}
