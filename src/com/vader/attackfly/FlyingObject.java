package com.vader.attackfly;


import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected int x;    //x����
	protected int y;    //y����
	protected int width;    //�߿��
	protected int height;   //����
	
	
	protected BufferedImage image;   //ͼƬ
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	// ��ײ���
	public boolean collision(FlyingObject f) {
		boolean b = true;
		if(f.y > this.y + this.image.getHeight()) {
			b =  false;
		}else if(f.x < this.x){
			b = false;
		}else if(f.x + f.image.getWidth() > this.x + this.image.getWidth()){
			b = false;
		}else if(f.y + f.image.getHeight() < this.y){
			b = false;
		}
		return b;
//		return this.x<x && x<this.x+image.getWidth() && this.y<y && y<this.y+image.getHeight();
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	//	���� ���ڳ���Ķ���Ӧ���Ƴ�
	public abstract boolean outOfBounds();

	//	�ƶ�
	public abstract void step();
		
}
