/**
 * 
 */
package com.domker.stone.syntax;

import com.domker.stone.lexer.Token;

/**
 * Ҷ�ӽڵ�
 * 
 * @author Maison
 *
 */
public class NumberLiteral extends ASTLeaf {

	public NumberLiteral(Token token) {
		super(token);
	}

	/**
	 * ���ظýڵ��ֵ
	 * 
	 * @return
	 */
	public int value() {
		return token.getNumber();
	}
}
