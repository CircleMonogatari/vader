package com.vader.attackfly;

import java.util.Random;

public class Enemy extends FlyingObject {
	private int speed = 5; // �ٶ�
	private int score = 1; // ��������
	private int bulletType; // �ӵ�����
	private int life; // ��
	private boolean boos = false;

	public boolean isBoos() {
		return boos;
	}

	public void setBoos(boolean boos) {
		this.boos = boos;
	}

	/** ��ȡ���� */
	public int getScore() {
		return this.score;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getBulletType() {
		return bulletType;
	}

	public void setBulletType(int bulletType) {
		this.bulletType = bulletType;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public int subLife(int life) {
		this.life-=life;
		return this.life;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/** //Խ�紦�� */
	@Override
	public boolean outOfBounds() {
		return y > this.height;
	}

	/** �ƶ� */
	@Override
	public void step() {
		
		//Boss�������ƶ���ʽ
		if (this.boos == true) {
			if (this.y > 200) {
				speed = -1;
			} else if (this.y - 1 < 0) {
				Random random = new Random();
				int type = random.nextInt(3); // [0,100)
				 speed = type;
			}

		}
		
		y += speed;		

	}
}
