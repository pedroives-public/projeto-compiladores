package io.compiler.ast;

public class CommandAtribuicao extends AbstractCommand{

	private String id;
	private String expr;
	private boolean isIncrementDecrement = false;
	
	public CommandAtribuicao(String id, String expr) {
		this.id = id;
		this.expr = expr;
	}
	
    public void setIncrementDecrement(boolean isIncDec) {
        this.isIncrementDecrement = isIncDec;
    }
    
    public String generateJavaCode() {
        if (isIncrementDecrement) {
            return "	" + expr + ";\n";
        }
        return "	" + id + " = " + expr + ";\n";
    }
}
