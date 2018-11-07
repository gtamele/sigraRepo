package iim.sigra.model.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {

	
	@Id
	@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = " sigra.cliente_seq")
	@GeneratedValue( strategy = GenerationType.TABLE, generator = "SEQ_CLIENTE")
	@Column(name="id_cliente")
	protected int id;
	
	
	protected String numCliente;
	
	protected String name;
	
	protected String apelido;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	
}
