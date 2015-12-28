package com.domker.stone.lexer;

/**
 * ×Ö·û´®×ÖÃæÁ¿
 * 
 * @author Maison
 *
 */
public class StringToken extends Token {
	private String literal;
	
	protected StringToken(int line, String str) {
		super(line);
		this.literal = str;
	}

	@Override
	public boolean isString() {
		return true;
	}

	@Override
	public String getText() {
		return literal;
	}
	
}
