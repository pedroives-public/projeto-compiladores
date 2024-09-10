package io.compiler.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import io.compiler.exceptions.IsiSemanticException;
import io.compiler.parser.IsiLanguageLexer;
import io.compiler.parser.IsiLanguageParser;

public class MainClass {
	public static void main(String[] args) {
		try {
			IsiLanguageLexer lexer;
			IsiLanguageParser parser;
			
			lexer = new IsiLanguageLexer(CharStreams.fromFileName("input.isi"));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			parser = new IsiLanguageParser(tokenStream);
			
			parser.prog();
			System.out.println("Compilação realizada com sucesso!!");
			
			parser.generateCode();
			
		}
		catch(IsiSemanticException ex) {
			System.err.println("Semantic error - "+ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("ERROR "+ex.getMessage());
		}
		
	}

}
