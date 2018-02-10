package iim.sigra.utilitarios;

import org.springframework.core.convert.converter.Converter;

import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;

public class StringToTipoDoc implements Converter<String, TipoDocIdentificacaoVO> {

	@Override
	public TipoDocIdentificacaoVO convert(String str) {
		
		TipoDocIdentificacaoVO tipoDoc = new TipoDocIdentificacaoVO();
		
		return tipoDoc;
	}

}


