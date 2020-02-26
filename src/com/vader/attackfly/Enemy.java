package com.vader.attackfly;

public class Enemy extends FlyingObject {
	private int speed = 5; // �ٶ�
	private int score = 1; // ��������
	private int bulletType; // �ӵ�����
	private int life; // ��

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

	public void setScore(int score) {
		this.score = score;
	}

	/** //Խ�紦�� */
	@Override
	public boolean outOfBounds() {
		return y > run.HEIGHT;
	}

	/** �ƶ� */
	@Override
	public void step() {
		y += speed;
	}
}
