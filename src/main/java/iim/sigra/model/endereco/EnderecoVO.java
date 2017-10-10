package iim.sigra.model.endereco;

public class EnderecoVO {

	protected long selfId;
	protected String nomeRuaAvenida;
	protected int numeroRuaAvenida;
	protected String bairro;
	protected int andar;
	protected int numeroCasa;
	protected String telfCell;
	protected String telfFixo;
	
	
	

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public String getNomeRuaAvenida() {
		return nomeRuaAvenida;
	}

	public void setNomeRuaAvenida(String nomeRuaAvenida) {
		this.nomeRuaAvenida = nomeRuaAvenida;
	}

	public int getNumeroRuaAvenida() {
		return numeroRuaAvenida;
	}

	public void setNumeroRuaAvenida(int numeroRuaAvenida) {
		this.numeroRuaAvenida = numeroRuaAvenida;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
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

}
