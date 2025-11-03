import javax.naming.InitialContext;
import java.io.*;
import java.util.*;

public class Main {
public static void main(String[] args) throws Exception {
    /* doit permettre de tester les services
     scenario de test :
     une conversion avec bonne saisie et une avec saisie erronee
     */

	try {
		InitialContext ctx = new InitialContext();		
        conversionTaux.session.ConversionTauxItf cti = (conversionTaux.session.ConversionTauxItf) ctx.lookup("ConversionTauxJNDI");
        // ConversionTauxItf bean = (ConversionTauxItf) ctx.lookup("java:global/conversionTauxServeur/ConversionTauxBean");

        System.out.println(cti.convertir("euros","dollars", 10.5));

        System.out.println(cti.convertir("euro", "Dollars", 10.5));
        
        System.out.println(cti.creerCompte("arafa", "1234"));
        // System.out.println(cti.creerCompte("arafa", "1234")); 
    }
	catch (Exception ex) {
		System.err.println("erreur dans le client prbl nommage");
		ex.printStackTrace();
	}
}
}
