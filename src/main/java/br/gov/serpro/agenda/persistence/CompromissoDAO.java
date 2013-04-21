package br.gov.serpro.agenda.persistence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.agenda.domain.Compromisso;

@PersistenceController
public class CompromissoDAO extends JPACrud<Compromisso, Long> {

	private static final long serialVersionUID = 1L;

	public Compromisso findByNome(String nomeCompromisso) {
		Query query = getEntityManager().createQuery(
				"select c from Compromisso c where c.nomeCompromisso = :nomeCompromisso");
		query.setParameter("nomeCompromisso", nomeCompromisso);

		Compromisso compromisso;

		try {
			compromisso = (Compromisso) query.getSingleResult();
		} catch (NoResultException exception) {
			compromisso = null;
		}

		return compromisso;
	}
}
