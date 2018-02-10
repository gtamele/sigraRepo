package iim.sigra.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioVO;
import iim.sigra.model.pessoa.PessoaVO;


@Entity
@Table(name = "USUARIO")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class UsuarioVO {
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected long selfId;
	
	protected String nome;
	
	@Column(unique=true)
	protected String userName;
	
	protected String password;
	@Transient
	protected String passwordConfirmacao;
	protected String email;
	protected boolean statusUsuarioActivo;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipoUsuario")
	protected TipoUsuarioVO tipoUsuario;


	public long getSelfId() {
		return selfId;
	}


	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmacao() {
		return passwordConfirmacao;
	}


	public void setPasswordConfirmacao(String passwordConfirmacao) {
		this.passwordConfirmacao = passwordConfirmacao;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean isStatusUsuarioActivo() {
		return statusUsuarioActivo;
	}


	public void setStatusUsuarioActivo(boolean statusUsuarioActivo) {
		this.statusUsuarioActivo = statusUsuarioActivo;
	}


	public TipoUsuarioVO getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(TipoUsuarioVO tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	
	
	

}
