import java.io.*;
import java.util.*;
import edu.stanford.nlp.io.*; 
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.trees.TreeCoreAnnotations.*;
import edu.stanford.nlp.util.*;

public class CustomLemmatizer {
    public static void main (String[] args) throws IOException {
		// Loading annotators.
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
		props.setProperty("threads", "8");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		// Reading in (possibly multi-line) string from standard input (to be called from Python, for instance).		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String line;
		StringBuilder processedText = new StringBuilder(); 
		while ( (line = reader.readLine())!= null) {			
			// Performing annotations.
			Annotation annotation = new Annotation(line);
			pipeline.annotate(annotation);
			// Extracting lemmas.
			List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
			for(CoreMap sentence: sentences) {    
		    	for(CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {       
					processedText.append(token.get(CoreAnnotations.LemmaAnnotation.class)).append(" ");
				}
			}
			processedText.append("\n");
		}
		System.out.println(processedText.toString());
    }
}
