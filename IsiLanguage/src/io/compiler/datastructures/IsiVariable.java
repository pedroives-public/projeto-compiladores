package io.compiler.datastructures;

public class IsiVariable extends IsiSymbol {
	
	public static final int INT = 0;
	public static final int TEXT = 1;
	public static final int DOUBLE = 2;
	public static final int BOOLEAN = 3;
	public static final int CHAR = 4;
	
	private int type;
	private String value;
	
	public IsiVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
	
	public String generateJavaCode() {
       return String.format("    %s %s;\n", typeCode(), super.name);
	}
	
	private String typeCode() {
		switch (this.type) {
			case INT: 
				return "int";
				
			case TEXT:	
				return "String";
			
			case DOUBLE: 
				return "double";
			
			case BOOLEAN: 
				return "boolean";
				
			case CHAR:
				return "char";
			
			default: 
				throw new RuntimeException("Type not defined");
		}
	}
	
	public static String getIsiType(int type) {
		switch (type) {
			case INT: 
				return "integer";
				
			case TEXT:	
				return "text";
			
			case DOUBLE: 
				return "double";
			
			case BOOLEAN: 
				return "boolean";
				
			case CHAR:
				return "char";
			
			default: 
				throw new RuntimeException("Type not defined");
		}
	}
	
	private boolean used = false; // Add this line

    // Getter and Setter for 'used'
    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}
