package com.vader.attackfly;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class run extends JFrame {
	public static final int WIDTH = 400; // ����
	public static final int HEIGHT = 654; // ����
	/** ��Ϸ�ĵ�ǰ״̬: START RUNNING PAUSE GAME_OVER */
	private int state;
	private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;
	
	private int score = 0; // �÷�
	private Timer timer; // ��ʱ��
	private int intervel = 1000 / 100; // ʱ����(����)
	
	//��Դ����
	public static BufferedImage background;  //����
	public static BufferedImage start;		//��ʼ
	public static BufferedImage pause;		//��ͣ
	public static BufferedImage gameover;	//����
	
	public static BufferedImage airplane;
	public static BufferedImage bee;		
	public static BufferedImage bullet;	
	
	public static BufferedImage hero0;
	public static BufferedImage hero1;

	
	//����
	
	//�л�
	
	//�ӵ�
	
	//����
	
	/*
	 * ��ʼ����������
	 * */
	public void initgame() {
		this.setTitle("һ���ɻ�");
		this.setVisible(true);
		this.setSize(this.WIDTH, this.HEIGHT);
		this.setLocation(300,300);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}
		});
		
		//����ͼƬ
		
		//��������
	}
	
	/*
	 * ������Ϸ*
	 */
	public void rungame() {
		
		timer = new Timer(); // �����̿���
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				int a = 1;
				//��д��Ϸ����
				System.out.print(a++);
				
				repaint(); // �ػ棬����paint()����
			}

		}, intervel, intervel);
	}
	
	
	/**
	 * �軭���еĶ���
	 */
	@Override
	public void paint(Graphics g) {
		
		
	}
	
	public static void main(String[] args) {
		run r = new run();
		r.initgame();
		r.rungame();
		System.out.print("exit");
		
	}
}
