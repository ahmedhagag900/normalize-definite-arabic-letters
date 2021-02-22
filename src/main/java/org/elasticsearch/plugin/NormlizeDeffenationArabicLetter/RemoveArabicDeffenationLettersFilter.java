package org.elasticsearch.plugin.NormlizeDeffenationArabicLetter;


import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

public final class RemoveArabicDeffenationLettersFilter extends TokenFilter  {


    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private static final char ALEF = '\u0627';
    private static final char LAM = '\u0644';
    private static final char WAW = '\u0648';
    private static final char BEH = '\u0628';
    private static final char TEH = '\u062A';
    private static final char KAF = '\u0643';
    private static final char FEH = '\u0641';
    private static final char[][] definite_article = {
            new char[]{FEH, ALEF, LAM},
            new char[]{KAF, ALEF, LAM},
            new char[]{BEH, ALEF, LAM},
            new char[]{WAW, ALEF, LAM},
            new char[]{TEH, ALEF, LAM},
            new char[]{ALEF, LAM}
        };
    
    public RemoveArabicDeffenationLettersFilter(Version matchVersion, TokenStream input) {
        super(input);
    }
    

    
    @Override
    public boolean incrementToken() throws IOException {
    	if(input.incrementToken()) {
    		//get the token buffer and it's length 
    		char[] term=termAtt.buffer();
    		int bufferLength=termAtt.length();
    		
    		//iterate through the definite letters of arabic language
    		for(int i=0;i<definite_article.length;++i) {
    			char[] comp=new char[Math.min(definite_article[i].length,bufferLength)];
    			
    			//get the prefix of the token
    			for(int j=0;j<definite_article[i].length && j<bufferLength;++j) {
    				comp[j]=term[j];
    			}
    			
    			//check if it's a definite letter 
    			if(EqualPrefixTerm(definite_article[i],comp.length) && bufferLength-comp.length>2) {
    				char[] newTerm=GetSubCharArray(comp.length, bufferLength-1);
    				SetTermBuffer(term,newTerm);
    				termAtt.setLength(newTerm.length);
    				return true;
    			}
    		}
    		return true;
    	}else {
    		return false;
    	}
    }
    
    //check if the inserted term is equal to the prefix of the token
    private boolean EqualPrefixTerm(char[] arr,int length) {
    	if(arr.length!=length)
    		return false;
    	for(int i=0;i<arr.length;++i) {
    		if(arr[i]!=termAtt.charAt(i))
    			return false;
    	}
    	return true;
    }
    
    private char[] GetSubCharArray(int start,int end) {
    	char[]res=new char[(end-start)+1];
    	int idx=0;
    	for(int i=start;i<=end;++i)
    		res[idx++]=termAtt.charAt(i);
    	return res;
    }
    
    
    private void SetTermBuffer(char[] original,char[] target) {
    	for(int i=0;i<target.length;++i) {
    		original[i]=target[i];
    	}
    }
    
}
