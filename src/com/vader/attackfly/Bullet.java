package com.vader.attackfly;



/**
 * ��ͨ�ӵ�
 * @author Xmas
 */
public class Bullet extends FlyingObject{
	private int speed = 15; //�ӵ��ٶ�
	private int type = 0;
	private int fire = 1;
	
	
	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	public int getFire() {
		return fire;
	}


	public void setFire(int fire) {
		this.fire = fire;
	}


	//Խ��
	@Override
	public boolean outOfBounds( ) {
		// TODO Auto-generated method stub
		return ((y < 0) || (y > this.height) || (x < 0) || (x > this.width));

	}

	//���з�ʽ ��ֱ����
	@Override
	public void step() {
		// TODO Auto-generated method stub
		y-=speed;
	}
}
