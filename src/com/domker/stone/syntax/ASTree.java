package com.domker.stone.syntax;

import java.util.Iterator;

/**
 * �����﷨���ĳ������
 * 
 * @author Maison
 *
 */
public abstract class ASTree implements Iterable<ASTree> {
	/**
	 * �õ���i�ŵ��ӽڵ�
	 * 
	 * @param i
	 * @return
	 */
	public abstract ASTree child(int i);

	/**
	 * �����ӽڵ�����
	 * 
	 * @return
	 */
	public abstract int getChildrenSum();
	
	/**
	 * ���ض�λ�����е���Ϣ
	 * 
	 * @return
	 */
	public abstract String location();
	
	/**
	 * ���������ӽڵ�ĵ�����
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
