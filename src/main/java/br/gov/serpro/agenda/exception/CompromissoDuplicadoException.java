package br.gov.serpro.agenda.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;
import br.gov.frameworkdemoiselle.message.SeverityType;

@ApplicationException(severity = SeverityType.ERROR, rollback = true)
public class CompromissoDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CompromissoDuplicadoException() {
		super("Nome duplicado");
	}
}
