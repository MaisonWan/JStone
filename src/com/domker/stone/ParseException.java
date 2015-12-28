package com.domker.stone;

import java.io.IOException;

import com.domker.stone.lexer.Token;

/**
 * 分词过程中解析的错误异常
 * 
 * @author Maison
 *
 */
public class ParseException extends Exception {

	public ParseException(Token t) {
		this("", t);
	}

	public ParseException(String msg, Token t) {
		super("syntas error around " + location(t) + ". " + msg);
	}

	public ParseException(String msg) {
		super(msg);
	}

	public ParseException(IOException e) {
		super(e);
	}

	/**
	 * 根据token定位行数
	 * 
	 * @param t
	 * @return
	 */
	public static String location(Token t) {
		if (t == Token.EOF) {
			return "the last line";
		}
		return "\"" + t.getText() + "\" + at line " + t.getLineNumber();
	}
}
