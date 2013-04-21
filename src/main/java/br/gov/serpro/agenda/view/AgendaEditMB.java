package br.gov.serpro.agenda.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.agenda.business.AgendaBC;
import br.gov.serpro.agenda.domain.Compromisso;

@ViewController
@PreviousView("/agenda_list.xhtml")
public class AgendaEditMB extends AbstractEditPageBean<Compromisso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendaBC bc;

	@Override
	@Transactional
	public String delete() {
		bc.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		bc.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		bc.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(bc.load(getId()));
	}
}
