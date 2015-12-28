package com.domker.stone.lexer;

/**
 * 整形字面量
 * 
 * @author Maison
 *
 */
public class NumberToken extends Token {
	private int value;

	protected NumberToken(int line, int v) {
		super(line);
		this.value = v;
	}

	@Override
	public boolean isNumber() {
		return true;
	}

	@Override
	public int getNumber() {
		return this.value;
	}

	@Override
	public String getText() {
		return Integer.toString(value);
	}
}
