package io.compiler.ast;

import java.util.ArrayList;

public class CommandLoopWhile extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> cmdList;

    public CommandLoopWhile(String condition, ArrayList<AbstractCommand> cmdList) {
        this.condition = condition;
        this.cmdList = cmdList;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("    while (" + condition + ") {\n");
        for (AbstractCommand cmd : cmdList) {
            str.append("    " + cmd.generateJavaCode());
        }
        str.append("    }\n");
        return str.toString();
    }

    
    @Override
	public String toString() {
		return String.format("CommandLoopWhile [condition=%s, cmdList=%s]", this.condition, this.cmdList);
	}
}