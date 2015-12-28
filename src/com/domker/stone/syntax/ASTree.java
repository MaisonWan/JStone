package com.domker.stone.syntax;

import java.util.Iterator;

/**
 * 抽象语法树的抽象基类
 * 
 * @author Maison
 *
 */
public abstract class ASTree implements Iterable<ASTree> {
	/**
	 * 得到第i号的子节点
	 * 
	 * @param i
	 * @return
	 */
	public abstract ASTree child(int i);

	/**
	 * 返回子节点数量
	 * 
	 * @return
	 */
	public abstract int getChildrenSum();
	
	/**
	 * 返回定位代码行的信息
	 * 
	 * @return
	 */
	public abstract String location();
	
	/**
	 * 返回所有子节点的迭代器
	 * 
	 * @return
	 */
	public abstract Iterator<ASTree> children();

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<ASTree> iterator() {
		return children();
	}
}
