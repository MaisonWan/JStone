/**
 * 
 */
package com.domker.stone;

import java.io.StringReader;

import com.domker.stone.lexer.Lexer;
import com.domker.stone.lexer.Token;

/**
 * @author Maison
 *
 */
public class Stone {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		String code = "while i < 10 {\n\tsum = sum + i\n\ti = i + 1\n}";
		Lexer l = new Lexer(new StringReader(code));
		Token token;
		while((token = l.read()) != Token.EOF) {
			System.out.println("=> " + token.getText());
		}
		System.out.println("End");
	}

}
