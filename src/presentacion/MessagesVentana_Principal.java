package presentacion;

import java.beans.Beans;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessagesVentana_Principal {
	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	private MessagesVentana_Principal() {
		// do not instantiate
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// Bundle access
	//
	////////////////////////////////////////////////////////////////////////////
	private static final String BUNDLE_NAME = "presentacion.messagesVentana_Principal"; //$NON-NLS-1$
	private static ResourceBundle RESOURCE_BUNDLE = loadBundle();
	private static ResourceBundle loadBundle() {
		return ResourceBundle.getBundle(BUNDLE_NAME);
	}
	////////////////////////////////////////////////////////////////////////////
	//
	// Strings access
	//
	////////////////////////////////////////////////////////////////////////////
	public static String getString(String key) {
		try {
			ResourceBundle bundle = Beans.isDesignTime() ? loadBundle() : RESOURCE_BUNDLE;
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return "!" + key + "!";
		}
	}
	private static Locale getLocale(String appIdioma){
		Locale locale=new Locale("es");
		if (appIdioma.equals("ingles"))
			locale = new Locale("en");
		if (appIdioma.equals("espaniol"))
			locale = new Locale("es");
		return locale;
	}
	public static void setIdioma(String idioma){
		RESOURCE_BUNDLE= ResourceBundle.getBundle(BUNDLE_NAME, getLocale(idioma));
	}
}
