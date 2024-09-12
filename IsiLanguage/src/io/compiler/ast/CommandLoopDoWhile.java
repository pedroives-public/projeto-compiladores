package io.compiler.ast;

import java.util.ArrayList;

public class CommandLoopDoWhile extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> cmdList;

    public CommandLoopDoWhile(String condition, ArrayList<AbstractCommand> cmdList) {
        this.condition = condition;
        this.cmdList = cmdList;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("    do {\n");
        for (AbstractCommand cmd : cmdList) {
            str.append("	" + cmd.generateJavaCode());
        }
        str.append("    } while (" + condition + ");\n");
        return str.toString();
    }

    @Override
    public String toString() {
        return String.format("CommandLoopDoWhile [condition=%s, cmdList=%s]", condition, cmdList);
    }
}