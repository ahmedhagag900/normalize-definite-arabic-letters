package org.elasticsearch.plugin.NormlizeDeffenationArabicLetter;

import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.env.Environment;
import org.apache.lucene.util.Version;

public class RemoveArabicDeffenationLettersFilterFactory extends AbstractTokenFilterFactory {


    @Inject 
    public RemoveArabicDeffenationLettersFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    	super(indexSettings, name, settings);
        
    }

    @Override 
    public TokenStream create(TokenStream tokenStream) {
        return new RemoveArabicDeffenationLettersFilter(Version.LATEST, tokenStream);
    }

}
