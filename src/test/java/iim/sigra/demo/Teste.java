package iim.sigra.demo;

import java.util.ArrayList;
import java.util.List;

import iim.sigra.model.especialidade.EspecialidadeDAO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.matricula.MatriculaDAO;
import iim.sigra.model.matricula.MatriculaVO;
import iim.sigra.model.pagamento.PagamentoVO;
import iim.sigra.model.pessoa.PessoaVO;
import iim.sigra.model.pessoa.estudante.EstudanteDAO;
import iim.sigra.model.pessoa.estudante.EstudanteVO;
import iim.sigra.model.processo.ProcessoVO;
import iim.sigra.model.usuario.UsuarioVO;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		
		ArrayList<EstudanteVO> estudantes = new ArrayList<EstudanteVO>();
		EstudanteVO estudante = new EstudanteVO();
		EstudanteDAO estuDao = new EstudanteDAO();
		
	//	estudante = estuDao.getEstudanteById(2, new UsuarioVO());
		
	//	estudante.setApelido("Tembe");
		
	//	estudante = estuDao.getEstudanteByApelido(estudante, new UsuarioVO());
		
	//	estudantes = estuDao.allEstudanteByApelido(estudante, new UsuarioVO());
		
		
	//	estudante.setNome("usko");
	//	estudantes = estuDao.estudanteByNome(estudante, new UsuarioVO());
		
		//	System.out.println("Estudantes "+estudantes);
		
		EspecialidadeVO esp = new EspecialidadeVO();
		
		EspecialidadeDAO espDao = new EspecialidadeDAO();
				
		
	//	esp = espDao.getEspecialidadeById(3, new UsuarioVO());
		
		
		Object obj = new Object();
		MatriculaDAO matDao = new MatriculaDAO();
		
	//	obj = matDao.getAllForMatriculaComprovativo(9, new UsuarioVO());
		
		//MatriculaVO matr = (MatriculaVO) obj;
		
	//	System.out.println(obj);
	//	System.out.println(matr);
		
		MatriculaVO matricula = null;
		ProcessoVO proc = null;
		EstudanteVO est = null;
		EspecialidadeVO espec = null;
		PagamentoVO pag = null;
		
		List<?> lista = matDao.getAllForMatriCompr(4, new UsuarioVO());
		
		for (int i = 0; i < lista.size(); i++) {
			
			Object[] row = (Object[]) lista.get(i);
			
			matricula = (MatriculaVO) row[0];
			proc = (ProcessoVO) row[1];
			est = (EstudanteVO) row[2];
			espec = (EspecialidadeVO) row[3];
			pag = (PagamentoVO) row[4];
		}
		
		System.out.println("Matricula "+matricula);
		System.out.println("Processo "+proc);
		System.out.println("Estudante "+est);
		System.out.println("Especilaidade "+espec);
		System.out.println("Pagamento "+pag);
	}

}
