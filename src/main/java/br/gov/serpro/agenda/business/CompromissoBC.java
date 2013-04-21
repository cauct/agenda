package br.gov.serpro.agenda.business;

import java.util.Calendar;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.agenda.domain.Compromisso;
import br.gov.serpro.agenda.exception.CompromissoDuplicadoException;
import br.gov.serpro.agenda.persistence.CompromissoDAO;

@BusinessController
public class CompromissoBC extends DelegateCrud<Compromisso, Long, CompromissoDAO> {

	private static final long serialVersionUID = 1L;

	@Override
	public void insert(Compromisso compromisso) {
		if (getDelegate().findByNome(compromisso.getNomeCompromisso()) != null) {
			throw new CompromissoDuplicadoException();
		}

		super.insert(compromisso);
	}
	
	@Override
	public void update(Compromisso compromisso) {
		Compromisso persistido = getDelegate().findByNome(compromisso.getNomeCompromisso());
		
		if (!persistido.getId().equals(compromisso.getId())) {
			throw new CompromissoDuplicadoException();
		}
		
		super.update(compromisso);
	}
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			Calendar calendar = Calendar.getInstance();

			Compromisso compromissoOk = new Compromisso();
			compromissoOk.setNomeCompromisso("Compromisso pago no prazo");
			calendar.set(2013, 0, 10);
			compromissoOk.setDataVencimento(calendar.getTime());
			calendar.set(2013, 0, 9);
			compromissoOk.setDataPagamento(calendar.getTime());
			insert(compromissoOk);

			Compromisso compromissoAtrasdo = new Compromisso();
			compromissoAtrasdo.setNomeCompromisso("Compromisso atrasado");
			calendar.set(2013, 3, 15);
			compromissoAtrasdo.setDataVencimento(calendar.getTime());
			calendar.set(2013, 3, 19);
			compromissoAtrasdo.setDataPagamento(calendar.getTime());
			insert(compromissoAtrasdo);

			Compromisso compromissoEsquecido = new Compromisso();
			compromissoEsquecido.setNomeCompromisso("Esqueci de pagar");
			calendar.set(2013, 0, 2);
			compromissoEsquecido.setDataVencimento(calendar.getTime());
			insert(compromissoEsquecido);

			Compromisso compromissoAVencer = new Compromisso();
			compromissoAVencer.setNomeCompromisso("Compromisso à vencer");
			calendar.set(2020, 0, 1);
			compromissoAVencer.setDataVencimento(calendar.getTime());
			insert(compromissoAVencer);
		}
	}
}
