package org.elasticsearch.plugin.NormlizeDeffenationArabicLetter;



import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



public class RemoveArabicDeffenationLettersPlugin extends Plugin implements AnalysisPlugin {
    
	
	
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
		// TODO Auto-generated method stub
		//Map<String, AnalysisProvider<TokenFilterFactory>> res= new HashMap<>();
		return Collections.singletonMap("Normalize_definite_arabic_letters",RemoveArabicDeffenationLettersFilterFactory::new);
	//	return res;
	}

}
