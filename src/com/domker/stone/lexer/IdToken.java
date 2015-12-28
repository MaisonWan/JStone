package com.domker.stone.lexer;

/**
 * ±êÊ¶·û
 * 
 * @author Maison
 *
 */
public class IdToken extends Token {
	private String text;
	
	protected IdToken(int line, String id) {
		super(line);
		this.text = id;
	}

	@Override
	public boolean isIdentifier() {
		return true;
	}

	@Override
	public String getText() {
		return this.text;
	}
	
}
