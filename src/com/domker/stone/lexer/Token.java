package com.domker.stone.lexer;

import com.domker.stone.StoneException;

/**
 * 分词的类型基类，只有数字，字符串和操作符三个
 * @author Maison
 *
 */
public abstract class Token {
	public static final Token EOF = new Token(-1) {
	};
	public static final String EOL = "\\n";

	private int lineNumber = 0;

	protected Token(int line) {
		this.lineNumber = line;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * 是否是标识符
	 * 
	 * @return
	 */
	public boolean isIdentifier() {
		return false;
	}

	/**
	 * 是否是数字
	 * 
	 * @return
	 */
	public boolean isNumber() {
		return false;
	}

	/**
	 * 是否是字符串
	 * 
	 * @return
	 */
	public boolean isString() {
		return false;
	}

	public int getNumber() {
		throw new StoneException("not number token");
	}

	public String getText() {
		return "";
	}
}
