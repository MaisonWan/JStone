package com.domker.stone.syntax;

import com.domker.stone.lexer.Token;

/**
 * 叶子节点，显示名称
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
