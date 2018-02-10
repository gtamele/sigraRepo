package iim.sigra.controller.login;

import java.util.ArrayList;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Messages;

import iim.sigra.model.login.LoginVO;
import iim.sigra.model.usuario.UsuarioDAO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;

@Controller
@RequestMapping(value="home")
public class LoginAction {
	
	
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login(LoginVO login, Model model){
		
		
		ArrayList<UsuarioVO> allUsuarios = new ArrayList<UsuarioVO>();
		UsuarioDAO dao = new UsuarioDAO();
	
		allUsuarios = dao.getAll();
		
		for (UsuarioVO user : allUsuarios) {
			
			if(user.getUserName().equals(login.getUser()) && user.getPassword().equals(login.getSenha()))
				
				return new ModelAndView("/menu/menu1");
			
		}
		
		return  new ModelAndView("/login/login","msg",Mensagens.FAILED_LOGIN);
		
	}
	
	
	@RequestMapping(value="/exit",method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView exit(){
		
		return new ModelAndView("/login/login");
		
	}

}
