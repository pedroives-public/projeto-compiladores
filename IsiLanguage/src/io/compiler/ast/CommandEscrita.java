package io.compiler.ast;

public class CommandEscrita extends AbstractCommand {

	private String id;
	
	public CommandEscrita(String id) {
		this.id = id;
	}
	@Override
	public String generateJavaCode() {
	    // Check if the id starts and ends with double quotes, indicating a string literal
	    if (this.id.startsWith("\"") && this.id.endsWith("\"")) {
	        return String.format("    System.out.println(%s);\n", this.id);
	    } else {
	        return String.format("    System.out.println(%s);\n", this.id);
	    }
	}

	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}
	

}
