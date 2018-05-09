package es.jvcorp.iTarea.web.components;

import java.util.Locale;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

@Import(library = {"tapestry5/bootstrap/js/collapse.js"},
		stylesheet={"tapestry5/bootstrap/css/bootstrap-theme.css", "context:css/iTarea.css"
			})
public class Layout {
	
	@Property
    @Parameter(required = true, defaultPrefix = "message")
    private String title;
    
    @Parameter(defaultPrefix = "literal")
    private Boolean showTitleInBody;
    
    public boolean getShowTitleInBody() {
    	
    	if (showTitleInBody == null) {
    		return true;
    	} else {
    		return showTitleInBody;
    	}
    	
    }
    
    @Property
    private String language;

    @Inject
    private Locale locale;

    @Inject
    private PersistentLocale persistentLocale;

    void onPrepareForRender() {
        language = locale.getLanguage();
    }
}
