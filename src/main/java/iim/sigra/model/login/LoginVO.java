package iim.sigra.model.login;

public class LoginVO {
	
	protected String user;
	protected String senha;
	
	
	public LoginVO(){}


	public LoginVO(String user, String senha) {
		this.user = user;
		this.senha = senha;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
	
	

}
