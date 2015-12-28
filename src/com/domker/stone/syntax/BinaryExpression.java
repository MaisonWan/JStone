/**
 * 
 */
package com.domker.stone.syntax;

import java.util.Iterator;
import java.util.List;

/**
 * 抽象语法树中的子节点，具有左值，右值和运算符三种子节点
 * 
 * @author Maison
 *
 */
public class BinaryExpression extends ASTList {

	public BinaryExpression(List<ASTree> list) {
		super(list);
	}

	/**
	 * 返回左值
	 * 
	 * @return
	 */
	public ASTree left() {
		return child(0);
	}

	/**
	 * 返回操作符
	 * 
	 * @return
	 */
	public String operator() {
		return ((ASTLeaf)child(1)).token().getText();
	}
	
	/**
	 * 返回右值
	 * 
	 * @return
	 */
	public ASTree right() {
		return child(2);
	}
	
}
