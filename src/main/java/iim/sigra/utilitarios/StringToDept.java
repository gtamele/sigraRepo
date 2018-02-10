package iim.sigra.utilitarios;


import org.springframework.core.convert.converter.Converter;

import iim.sigra.model.departamento.DepartamentoVO;


public class StringToDept implements Converter<String, DepartamentoVO>  {


		
	@Override
	public DepartamentoVO convert(String str) {
		
		DepartamentoVO obj = new DepartamentoVO();
		
		//((obj.getSelfId()==Long.parseLong(str))|| (obj.getDesignacao().equalsIgnoreCase(str))? obj : obj  );
		
		return  obj;
	}

}
