package br.gov.serpro.agenda.business;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.agenda.domain.Compromisso;
import br.gov.serpro.agenda.domain.CompromissoConfig;
import br.gov.serpro.agenda.exception.CompromissoDuplicadoException;
import br.gov.serpro.agenda.exception.ValorInvalidoException;
import br.gov.serpro.agenda.persistence.CompromissoDAO;

@BusinessController
public class CompromissoBC extends DelegateCrud<Compromisso, Long, CompromissoDAO> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CompromissoConfig config;

	@Override
	public void insert(Compromisso compromisso) {
		validaValor(compromisso);
		
		if (getDelegate().findByNome(compromisso.getNomeCompromisso()) != null) {
			throw new CompromissoDuplicadoException();
		}

		super.insert(compromisso);
	}

	@Override
	public void update(Compromisso compromisso) {
		validaValor(compromisso);
		
		Compromisso persistido = getDelegate().findByNome(compromisso.getNomeCompromisso());
		if (persistido != null && !persistido.getId().equals(compromisso.getId())) {
			throw new CompromissoDuplicadoException();
		}

		super.update(compromisso);
	}

	private void validaValor(Compromisso compromisso) {
		if (compromisso.getValorCompromisso().doubleValue() <= config.getValorMinimo()) {
			throw new ValorInvalidoException(config.getValorMinimo());
		}
	}
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			Calendar calendar = Calendar.getInstance();

			Compromisso compromissoOk = new Compromisso();
			compromissoOk.setNomeCompromisso("Compromisso pago no prazo");
			compromissoOk.setValorCompromisso(new BigDecimal(100.00));
			calendar.set(2013, 0, 10);
			compromissoOk.setDataVencimento(calendar.getTime());
			calendar.set(2013, 0, 9);
			compromissoOk.setDataPagamento(calendar.getTime());
			insert(compromissoOk);

			Compromisso compromissoAtrasdo = new Compromisso();
			compromissoAtrasdo.setNomeCompromisso("Compromisso atrasado");
			compromissoAtrasdo.setValorCompromisso(new BigDecimal(900.00));
			calendar.set(2013, 3, 15);
			compromissoAtrasdo.setDataVencimento(calendar.getTime());
			calendar.set(2013, 3, 19);
			compromissoAtrasdo.setDataPagamento(calendar.getTime());
			insert(compromissoAtrasdo);

			Compromisso compromissoEsquecido = new Compromisso();
			compromissoEsquecido.setNomeCompromisso("Esqueci de pagar");
			compromissoEsquecido.setValorCompromisso(new BigDecimal(16.00));
			calendar.set(2013, 0, 2);
			compromissoEsquecido.setDataVencimento(calendar.getTime());
			insert(compromissoEsquecido);

			Compromisso compromissoAVencer = new Compromisso();
			compromissoAVencer.setNomeCompromisso("Compromisso à vencer");
			compromissoAVencer.setValorCompromisso(new BigDecimal(99.99));
			calendar.set(2020, 0, 1);
			compromissoAVencer.setDataVencimento(calendar.getTime());
			insert(compromissoAVencer);
		}
	}
}
