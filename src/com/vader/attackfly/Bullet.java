package com.vader.attackfly;



/**
 * ��ͨ�ӵ�
 * @author Xmas
 */
public class Bullet extends FlyingObject{
	private int speed = 3; //�ӵ��ٶ�
	private int type = 0;
	
	
	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Խ��
	@Override
	public boolean outOfBounds( ) {
		// TODO Auto-generated method stub
		return y<-height;
	}

	//���з�ʽ ��ֱ����
	@Override
	public void step() {
		// TODO Auto-generated method stub
		y-=speed;
	}
}