package com.vader.attackfly;

public class Enemy extends FlyingObject{
	private int speed = 3; //�ӵ��ٶ�
	private int score = 1;	//��������
	private int bulletType;   //�ӵ�����
	private int life;   //��
		
	/** ��ȡ���� */

	public int getScore() {  
		return this.score;
	}
	
	/** //Խ�紦�� */
	@Override
	public 	boolean outOfBounds() {   
		return y>run.HEIGHT;
	}

	/** �ƶ� */
	@Override
	public void step() {   
		y += speed;
	}
}
