package com.domker.stone.syntax;

import com.domker.stone.lexer.Token;

/**
 * Ҷ�ӽڵ㣬��ʾ����
 * 
 * @author Maison
 *
 */
public class Name extends ASTLeaf {
	
	public Name(Token token) {
		super(token);
	}

	public String name() {
		return token.getText();
	}
}
