package br.gov.serpro.agenda.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;


@ApplicationException(rollback = true)
public class ValorInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorInvalidoException(Double valorMinimo) {
		super("O valor deve ser maior que " + valorMinimo.longValue());
	}
}
