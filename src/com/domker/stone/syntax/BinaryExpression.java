/**
 * 
 */
package com.domker.stone.syntax;

import java.util.Iterator;
import java.util.List;

/**
 * �����﷨���е��ӽڵ㣬������ֵ����ֵ������������ӽڵ�
 * 
 * @author Maison
 *
 */
public class BinaryExpression extends ASTList {

	public BinaryExpression(List<ASTree> list) {
		super(list);
	}

	/**
	 * ������ֵ
	 * 
	 * @return
	 */
	public ASTree left() {
		return child(0);
	}

	/**
	 * ���ز�����
	 * 
	 * @return
	 */
	public String operator() {
		return ((ASTLeaf)child(1)).token().getText();
	}
	
	/**
	 * ������ֵ
	 * 
	 * @return
	 */
	public ASTree right() {
		return child(2);
	}
	
}
