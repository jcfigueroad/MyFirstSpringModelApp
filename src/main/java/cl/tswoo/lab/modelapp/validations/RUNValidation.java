package cl.tswoo.lab.modelapp.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cl.tswoo.lab.modelapp.models.Usuario;

@Component
public class RUNValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		
		ValidationUtils.rejectIfEmpty(errors, "run", null, "No puede ser vacio");
		
		if(!validarRUN(usuario.getRun()))
			errors.rejectValue("run", null, "RUN no valido");

	}

	private boolean validarRUN(String run) {
		boolean validacion = false;
	    try {
	        run =  run.toUpperCase();
	        run = run.replace(".", "");
	        run = run.replace("-", "");
	        int rutAux = Integer.parseInt(run.substring(0, run.length() - 1));

	        char dv = run.charAt(run.length() - 1);

	        int m = 0, s = 1;
	        for (; rutAux != 0; rutAux /= 10) {
	            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
	        }
	        if (dv == (char) (s != 0 ? s + 47 : 75)) {
	            validacion = true;
	        }

	    } 
	    catch (java.lang.NumberFormatException e) {
	    } 
	    catch (Exception e) {
	    }
	    return validacion;
	}

}
