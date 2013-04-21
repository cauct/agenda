package br.gov.serpro.agenda.business;

import java.util.Calendar;
import java.util.Date;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.agenda.domain.Compromisso;
import br.gov.serpro.agenda.persistence.CompromissoDAO;

@BusinessController
public class CompromissoBC extends DelegateCrud<Compromisso, Long, CompromissoDAO> {

	private static final long serialVersionUID = 1L;

	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			for (int i = 0; i < 15; i++) {
				Compromisso compromisso = new Compromisso();
				compromisso.setNomeCompromisso("comp" + i);
				compromisso.setDataVencimento(new Date());
				compromisso.setDataPagamento(new Date());
				insert(compromisso);
			}
		}
	}
}
