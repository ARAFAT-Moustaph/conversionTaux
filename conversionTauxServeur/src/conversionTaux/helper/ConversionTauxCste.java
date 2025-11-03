package conversionTaux.helper;

public interface ConversionTauxCste {
	//les msg retour
    String OK = "OK";
    String KO = "Erreur";
    String COMPTE_EXISTE = "Ce login existe déjà";
    String COMPTE_CREE = "Compte créé avec succès";
    String CONVERSION_OK = "Conversion effectuée avec succès";
    String MONNAIE_INCONNUE = "Monnaie inconnue";
    static final String RESULTAT       = "Le montant converti = ";
    static final String NO_RESULTAT     = "Erreur de saisie. Les valeurs demandées ne sont pas trouvées";
    static final String RESULTAT_MULTIPLE   = "Conflit de données. Les valeurs recherchées existent en plusieurs exemplaires";
}
