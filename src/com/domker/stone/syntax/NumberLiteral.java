/**
 * 
 */
package com.domker.stone.syntax;

import com.domker.stone.lexer.Token;

/**
 * 叶子节点
 * 
 * @author Maison
 *
 */
public class NumberLiteral extends ASTLeaf {

	public NumberLiteral(Token token) {
		super(token);
	}

	/**
	 * 返回该节点的值
	 * 
	 * @return
	 */
	public int value() {
		return token.getNumber();
	}
}
