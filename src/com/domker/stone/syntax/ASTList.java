package com.domker.stone.syntax;

import java.util.Iterator;
import java.util.List;

/**
 * ³éÏóÓï·¨Ê÷Ê÷Ö¦
 * 
 * @author Maison
 *
 */
public class ASTList extends ASTree {
	protected List<ASTree> children = null;

	public ASTList(List<ASTree> list) {
		super();
		this.children = list;
	}

	@Override
	public ASTree child(int i) {
		return children.get(i);
	}

	@Override
	public int getChildrenSum() {
		return children.size();
	}

	@Override
	public Iterator<ASTree> children() {
		return children.iterator();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('(');
		String sep = "";
		for (ASTree t : children) {
			builder.append(sep);
			sep = " ";
			builder.append(t.toString());
		}
		return builder.append(')').toString();
	}

	@Override
	public String location() {
		for (ASTree t : children) {
			String s = t.location();
			if (s != null) {
				return s;
			}
		}
		return null;
	}
}
