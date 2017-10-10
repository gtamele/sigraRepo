package iim.sigra.model.pessoa.usuario;

import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioVO;

public class UsuarioVO {

	protected long selfId;
	protected TipoUsuarioVO tipoUser;
	protected boolean isActivo;

	
	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public TipoUsuarioVO getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(TipoUsuarioVO tipoUser) {
		this.tipoUser = tipoUser;
	}

	public boolean isActivo() {
		return isActivo;
	}

	public void setActivo(boolean isActivo) {
		this.isActivo = isActivo;
	}

}
