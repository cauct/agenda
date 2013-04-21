package br.gov.serpro.agenda.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.agenda.domain.Compromisso;
import br.gov.serpro.agenda.persistence.AgendaDAO;

@BusinessController
public class AgendaBC extends DelegateCrud<Compromisso, Long, AgendaDAO> {

	private static final long serialVersionUID = 1L;

	@Startup
	@Transactional
	public void load() {
		Compromisso compromisso;

		compromisso = new Compromisso();
		compromisso.setNomeCompromisso("comp1");
		insert(compromisso);

		compromisso = new Compromisso();
		compromisso.setNomeCompromisso("comp2");
		insert(compromisso);

		compromisso = new Compromisso();
		compromisso.setNomeCompromisso("comp3");
		insert(compromisso);

		compromisso = new Compromisso();
		compromisso.setNomeCompromisso("comp4");
		insert(compromisso);
	}
}
