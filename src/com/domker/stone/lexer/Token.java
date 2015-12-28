package com.domker.stone.lexer;

import com.domker.stone.StoneException;

/**
 * �ִʵ����ͻ��ֻ࣬�����֣��ַ����Ͳ���������
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
	 * �Ƿ��Ǳ�ʶ��
	 * 
	 * @return
	 */
	public boolean isIdentifier() {
		return false;
	}

	/**
	 * �Ƿ�������
	 * 
	 * @return
	 */
	public boolean isNumber() {
		return false;
	}

	/**
	 * �Ƿ����ַ���
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
