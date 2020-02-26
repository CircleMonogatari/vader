package com.vader.attackfly;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {

	private int bulletType; // �ӵ�����
	private int life; // ��
	private int speed; // �ٶ�
	private int attackspeed = 10;

	public boolean up, down, left, right = false;
	public boolean fire, boom = false;

	

	public BufferedImage zd1;
	public BufferedImage zd2;
	public BufferedImage zd3;
	public BufferedImage zd4;

	public boolean isFire() {
		return fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}
	
	public int getAttackspeed() {
		return attackspeed;
	}

	public void setAttackspeed(int attackspeed) {
		this.attackspeed = attackspeed;
	}

	public BufferedImage getZd1() {
		return zd1;
	}

	public void setZd1(BufferedImage zd1) {
		this.zd1 = zd1;
	}

	public BufferedImage getZd2() {
		return zd2;
	}

	public void setZd2(BufferedImage zd2) {
		this.zd2 = zd2;
	}

	public BufferedImage getZd3() {
		return zd3;
	}

	public void setZd3(BufferedImage zd3) {
		this.zd3 = zd3;
	}

	public BufferedImage getZd4() {
		return zd4;
	}

	public void setZd4(BufferedImage zd4) {
		this.zd4 = zd4;
	}

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
		life = 0; // ��ʼ3����
		bulletType = 0; // ��ʼ����Ϊ0
		speed = 10;
		this.x = x;
		this.y = y;
	}

	// �����ӵ�����
	public void setBullrtType(int type) {
		this.bulletType = type;
	}

	// ��������
	public void addlife() {
		this.life++;
	}

	// ����
	public void subtractLife() {
		this.life--;
	}

	// ��ȡ��ǰ����
	public int getLife() {
		return this.life;
	}

	/**
	 * �����ӵ�
	 */
	public Bullet attack() {
		
		if (this.fire == false) {
			return null;
		}
		
		Bullet b = new Bullet(this.x + this.getImage().getWidth()/2, this.y);
		b.setHeight(this.height);
		b.setWidth(this.width);
		switch (this.bulletType) {
		
		case 0:
			b.setImage(zd1);
			
			break;
		case 1:
			b.setImage(zd2);
			break;
		case 2:
			b.setImage(zd3);
			break;
		case 3:
			b.setImage(zd4);
			break;
		}
		return b;
	}

	/**
	 * ʹ��ը��
	 */
	public boolean Boom() {
		return this.boom;
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

		if (this.life == 0) {
			return;
		}

		if (this.up == true) {
			if (this.y < 0)
				return;
			this.y = this.y - speed;

		}
		if (this.down == true) {
			if (this.y > (this.getHeight() - this.getImage().getHeight()))
				return;
			this.y = this.y + speed;

		}
		if (this.left == true) {
			if (this.x < 0)
				return;
			this.x = this.x - speed;

		}
		if (this.right == true) {
			if (this.x > this.getWidth() - this.getImage().getWidth())
				return;
			this.x = this.x + speed;

		}
	}



}
