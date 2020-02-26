package com.vader.attackfly;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	
	private int bulletType;   //�ӵ�����
	private int life;   //��
	private int speed; // �ٶ�
	
	public boolean up, down, left, right = false;
	
	
	public void setup(boolean b) {
		this.up = b;
	}
	public void setdown(boolean b) {
		this.down = b;
	}
	public void setleft(boolean b) {
		this.left = b;
	}
	public void setright(boolean b) {
		this.right = b;
	}
	
	/** ��ʼ������ */
	public Hero(int x, int y) {
		life = 0;   //��ʼ3����
		bulletType = 0;   //��ʼ����Ϊ0
		speed = 10;
		this.x = x;
		this.y = y;
	}
	
	//�����ӵ�����
	public void setBullrtType(int type) {
		this.bulletType = type;
	}
	
	//��������
	public void addlife() {
		this.life++;
	}
	
	//����
	public void subtractLife() {
		this.life--;
	}
	
	//��ȡ��ǰ����
	public int getLife() {
		return this.life;
	}
		
	/**
	 * �����ӵ�
	 */
	public Bullet attack() {
		switch (this.bulletType) {
		case 1:
			return null;
		default:
			Bullet b = new Bullet(this.x + this.width/2, this.y);
			return b;
		}
	}
	
	
	/** Խ�紦�� */
	@Override
	public boolean outOfBounds() {
		return false;  
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
//		System.out.println("up "+ this.up);
//		System.out.println("down "+ this.down);
//		System.out.println("left "+ this.left);
//		System.out.println("right "+ this.right);
		
		if(this.life == 0) {
			return;
		}
		
		if(this.up == true) {
			this.y = this.y - speed;
		}
		if(this.down  == true) {
			this.y = this.y + speed;
		}
		if(this.left  == true) {
			this.x = this.x - speed;
		}
		if(this.right  == true) {
			this.x = this.x + speed;
		}
	}
	
}
