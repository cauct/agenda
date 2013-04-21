package br.gov.serpro.agenda.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;
import br.gov.frameworkdemoiselle.message.SeverityType;

@ApplicationException(severity = SeverityType.ERROR, rollback = true)
public class ValorInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorInvalidoException(Double valorMinimo) {
		super("O valor deve ser maior que " + valorMinimo.longValue());
	}
}
