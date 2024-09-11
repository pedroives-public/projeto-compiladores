package io.compiler.ast;

import io.compiler.datastructures.IsiVariable;
import io.compiler.exceptions.IsiSemanticException;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private IsiVariable var;
	
	public CommandLeitura (String id, IsiVariable var) {
		this.id = id;
		this.var = var;
	}
	@Override
	public String generateJavaCode() {
		return String.format("    %s = %s;\n", this.id, getOperationCode());
	}
	
	private String getOperationCode() throws IsiSemanticException {
		switch (this.var.getType()) {
		case IsiVariable.INT:
			return "_key.nextInt()";
			
		case IsiVariable.DOUBLE:
			return "_key.nextDouble()";
		
		case IsiVariable.TEXT:
			return "_key.nextLine()";
			
		case IsiVariable.CHAR:
			return "_key.next(\".\").charAt(0)";
			
		case IsiVariable.BOOLEAN:
			throw new IsiSemanticException("Not possible read boolean variable");
		
		default:
			throw new RuntimeException("Type not defined");
			
	}
	}

}
