package io.compiler.ast;

public class CommandEscrita extends AbstractCommand {

	private String id;
	
	public CommandEscrita(String id) {
		this.id = id;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return String.format("    System.out.println(%s);\n", this.id);
	}
	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}
	

}
