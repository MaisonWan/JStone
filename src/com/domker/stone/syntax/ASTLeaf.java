package com.domker.stone.syntax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.domker.stone.lexer.Token;

/**
 * 抽象语法树的叶子节点
 * 
 * @author Maison
 *
 */
public class ASTLeaf extends ASTree {
	private static List<ASTree> empty = new ArrayList<ASTree>();

	protected Token token = null;

	public ASTLeaf(Token token) {
		this.token = token;
	}

	@Override
	public ASTree child(int i) {
		throw new IndexOutOfBoundsException("ASTLeaf has no child.");
	}

	@Override
	public int getChildrenSum() {
		// 叶子节点没有子节点
		return 0;
	}

	@Override
	public Iterator<ASTree> children() {
		return empty.iterator();
	}

	@Override
	public String toString() {
		return token.getText();
	}

	/**
	 * 得到位置行号
	 * 
	 * @return
	 */
	public String location() {
		return "at line " + token.getLineNumber();
	}

	public Token token() {
		return token;
	}

}
