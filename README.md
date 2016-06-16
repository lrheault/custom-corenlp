# custom-corenlp
Custom classes to use with the Stanford CoreNLP library.

These files are utility wrappers to use the Stanford CoreNLP library:

1) NLPProcessorCoNLL.java produces an output in CoNLL format that preserves the original line numbering of files when submitting a batch input.  More specifically, the output has an index comprising the original line number, a sentence index nested within the original line index, and a word index nested within sentences.  This may be useful for processing large numbers of files in which the original numbering of lines matters. 

Using this code requires substituting the file CoNLLOutputter.java in the CoreNLP 3.5.2 (2015-04-20) source code (i.e. decompiling CoreNLP, changing the file, and recompiling). 

The code was tested with version 3.5.2 (2015-04-20) of Stanford CoreNLP, which requires Java 8.  Further options may be available to produce a similar output in the latest version of CoreNLP.

2) CoNLLOutputter.java is the custom file to be replaced in the source directory before using the class described above.  

3) CustomLemmatizer.java is to build a class that sends the lemmatized version of a text processed using Standord CoreNLP via standard output.  The class can then be called from another language and used to import the lemmatized text.  The code was tested using Stanford CoreNLP v. 3.6.0 (2015-12-09).
