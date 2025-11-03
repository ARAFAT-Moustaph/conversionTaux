package conversionTaux.session;

import jakarta.ejb.*;
import jakarta.persistence.*;
import conversionTaux.entity.*;
import conversionTaux.helper.*;
import conversionTaux.helper.ConversionTauxCste;

@Stateless (mappedName="ConversionTauxJNDI")
public class ConversionTauxBean implements ConversionTauxItf, ConversionTauxCste {
    @PersistenceContext(unitName="ConversionTauxPU")
    private EntityManager em;

    /*  Remonter de la BD en mémoire la valeur du taux correspondant à la paire (monnaieA, monnaieB)
        Retourner la string RESULTAT + montant * taux trouvé
     */
	public String convertir(String monnaieA, String monnaieB, double montant) {
		try {
			TypedQuery<Double> q = em.createQuery(
                "SELECT t.taux FROM TauxEntity t WHERE t.monnaieA = :mA AND t.monnaieB = :mB",
                Double.class);
            q.setParameter("mA", monnaieA);
            q.setParameter("mB", monnaieB);
            double taux = q.getSingleResult();
            double resultat = montant * taux;
            return CONVERSION_OK + " : " + resultat;

		}
		catch (NoResultException nre) {
            //  exception si la paire (monnaieA, monnaieB) n'est pas trouvée
			return NO_RESULTAT;
		}
		catch (NonUniqueResultException nure) {
            //  exception si plusieurs paires (monnaieA, monnaieB) sont trouvées
			// return RESULTAT_MULTIPLE;
			return MONNAIE_INCONNUE;
		}
	}

	
    @Override
    public String creerCompte(String login, String passwd) {
        try {
            TypedQuery<Long> q = em.createQuery(
                "SELECT COUNT(a) FROM AbonneEntity a WHERE a.login = :login", Long.class);
            q.setParameter("login", login);
            if (q.getSingleResult() > 0)
                return COMPTE_EXISTE;

            AbonneEntity abonne = new AbonneEntity(login, passwd);
            em.persist(abonne);
            return COMPTE_CREE;
        } catch (Exception e) {
            e.printStackTrace();
            return KO;
        }
    }

}