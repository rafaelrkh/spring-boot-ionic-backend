package com.rafael.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.rafael.cursomc.domain.enums.TipoCliente;
import com.rafael.cursomc.dto.ClienteNewDTO;
import com.rafael.cursomc.resources.exceptions.FieldMessage;
import com.rafael.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if((objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCdTipoCliente())) && (BR.isValidCPF(objDto.getDsCpfCnpj()))){
			list.add(new FieldMessage("dsCpfCnpj", "CPF inválido!"));
		}
		
		if((objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCdTipoCliente())) && (BR.isValidCNPJ(objDto.getDsCpfCnpj()))){
			list.add(new FieldMessage("dsCpfCnpj", "CNPJ inválido!"));
		}
        
		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}


}