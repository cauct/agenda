package br.gov.serpro.agenda.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.serpro.agenda.business.AgendaBC;
import br.gov.serpro.agenda.domain.Compromisso;

@ViewController
@NextView("/agenda_edit.xhtml")
@PreviousView("/agenda_list.xhtml")
public class AgendaListMB extends AbstractListPageBean<Compromisso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendaBC agendaBC;

	@Override
	protected List<Compromisso> handleResultList() {
		return agendaBC.findAll();
	}

	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				agendaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
}
