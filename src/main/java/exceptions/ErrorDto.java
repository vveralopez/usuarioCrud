package exceptions;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ErrorDto {
	String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	} 
	
}
