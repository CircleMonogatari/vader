package com.vader.attackfly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class run extends Frame {
	public static final int WIDTH = 400; // ����
	public static final int HEIGHT = 654; // ����

	// ���� ����
	private int windows_X = this.getWidth() / 2;
	private int windows_Y = this.getHeight() / 2;

	/** ��Ϸ�ĵ�ǰ״̬: START RUNNING PAUSE GAME_OVER */
	private int state;
	private static final int MENU = 0;
	private static final int START = 1;
	private static final int RUNNING = 2;
	private static final int PAUSE = 3;
	private static final int GAME_OVER = 4;

	private int score = 0; // �÷�
	private Timer timer; // ��ʱ��
	private int intervel = 40; // ʱ����(����)

	// ��Դ����
	public static BufferedImage background; // ����
	public static BufferedImage start; // ��ʼ
	public static BufferedImage pause; // ��ͣ
	public static BufferedImage gameover; // ����

	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;

	public static BufferedImage hero0;
	public static BufferedImage hero1;

	public static BufferedImage boss1;
	public static BufferedImage boss2;
	public static BufferedImage boss3;
	public static BufferedImage boss4;

	public static BufferedImage fj1;
	public static BufferedImage fj2;
	public static BufferedImage fj3;
	public static BufferedImage fj4;
	public static BufferedImage fj5;

	// ����
	private List<Hero> heros = new ArrayList<Hero>();
	// ������
	private List<FlyingObject> enemys = new ArrayList<FlyingObject>();
	// �ӵ�
	private List<Bullet> bullets = new ArrayList<Bullet>();

	public boolean space;

	static {
		try {
			background = ImageIO.read(new File("images/background.jpg"));
			start = ImageIO.read(new File("images/start.png"));
			pause = ImageIO.read(new File("images/pause.png"));
			gameover = ImageIO.read(new File("images/gameover.png"));

			hero0 = ImageIO.read(new File("images/1p.png"));
			hero1 = ImageIO.read(new File("images/2p.png"));

			boss1 = ImageIO.read(new File("images/boss1.png"));
			boss2 = ImageIO.read(new File("images/boss2.png"));
			boss3 = ImageIO.read(new File("images/boss3.png"));
			boss4 = ImageIO.read(new File("images/boss4.png"));
			fj1 = ImageIO.read(new File("images/fj1.png"));
			fj2 = ImageIO.read(new File("images/fj2.png"));
			fj3 = ImageIO.read(new File("images/fj3.png"));
			fj4 = ImageIO.read(new File("images/fj4.png"));
			fj5 = ImageIO.read(new File("images/fj5.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ; ��ʼ����������
	 */
	public void initgame() {
		this.setTitle("һ���ɻ�");
		this.setVisible(true);
		this.setSize(this.background.getWidth(), this.background.getHeight());
		this.setLocation(500, 100);
		this.state = 0;
		this.windows_X = this.getWidth() / 2;
		this.windows_Y = this.getHeight() / 2;

		// ��ʼ�����
		Hero h1 = new Hero(windows_X - this.hero0.getHeight() / 2, this.getHeight() - 100);
		h1.setImage(this.hero0);

		Hero h2 = new Hero(0, 0);
		h2.setImage(this.hero1);

		this.heros.add(h1);
		this.heros.add(h2);

		addKeyListener(new KeyMonitor()); // ��������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	// ����������
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println(e.getKeyCode());
			PressKey(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println(e.getKeyCode());
			ReleasedKey(e);
		}
	}

	/*
	 * ������Ϸ*
	 */
	public void rungame() {

		timer = new Timer(); // �����̿���
		timer.schedule(new TimerTask() {
			@Override
			public void run() {

				// ��д��Ϸ����
				runtask();
				repaint(); // �ػ棬����paint()����
			}

		}, intervel, intervel);
	}

	// �������̰���
	public void PressKey(KeyEvent e) {

		System.out.println("����: " + e.getKeyChar());
		System.out.println("feiji: " + heros.get(0).up);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			space = true;
			break;
		case KeyEvent.VK_UP:
			this.heros.get(0).setup(true);
			break;
		case KeyEvent.VK_DOWN:
			this.heros.get(0).setdown(true);
			break;
		case KeyEvent.VK_LEFT:
			this.heros.get(0).setleft(true);
			break;
		case KeyEvent.VK_RIGHT:
			this.heros.get(0).setright(true);
			break;
		case KeyEvent.VK_W:
			this.heros.get(1).up = true;
			break;
		case KeyEvent.VK_S:
			this.heros.get(1).down = true;
			break;
		case KeyEvent.VK_A:
			this.heros.get(1).left = true;
			break;
		case KeyEvent.VK_D:
			this.heros.get(1).right = true;
			break;
		}
	}

	public void ReleasedKey(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.heros.get(0).up = false;
			break;
		case KeyEvent.VK_DOWN:
			this.heros.get(0).down = false;
			break;
		case KeyEvent.VK_LEFT:
			this.heros.get(0).left = false;
			break;
		case KeyEvent.VK_RIGHT:
			this.heros.get(0).right = false;
			break;
		case KeyEvent.VK_W:
			this.heros.get(1).up = false;
			break;
		case KeyEvent.VK_S:
			this.heros.get(1).down = false;
			break;
		case KeyEvent.VK_A:
			this.heros.get(1).left = false;
			break;
		case KeyEvent.VK_D:
			this.heros.get(1).right = false;
			break;
		}
	}

	public void runtask() {
		// System.out.print("runtask \n");
		// ״̬�л�
		switch (this.state) {
		case MENU:
			if (this.space) {
				this.space = false;
				this.state = START;
			}
			break;
		case START:
			// ��ʼ�� ��Ϸ״̬

			this.heros.get(0).addlife();
			this.heros.get(0).addlife();
			this.heros.get(0).addlife();
			this.space = false;
			this.state = RUNNING;

			break;

		case RUNNING:
			// �ո���ͣ
			if (this.space) {
				this.space = false;
				this.state = PAUSE;
			}

			// �ж������Ƿ�Ϊ0
			int life = 0;
			for (int i = 0; i < heros.size(); i++) {
				life += heros.get(i).getLife();
			}
			if (life <= 0) {
				this.state = GAME_OVER;
			}

			// ���ɻ���
			createEnemy();

			// �����ƶ�
			objectstep();

			break;

		case PAUSE: // ��ͣ״̬
			if (this.space) {
				this.space = false;
				this.state = RUNNING;
			}
			break;
		case GAME_OVER: // ��Ϸ��ֹ״̬
			if (this.space) {
				this.space = false;
				this.state = MENU;
			}
			break;
		}
	}

	int flyEnteredIndex = 0; // �������볡����

	private void createEnemy() {
		flyEnteredIndex++;
		if (flyEnteredIndex % 40 == 0) { // 400��������һ��������--10*40
			FlyingObject obj = nextOne(); // �������һ��������
			this.enemys.add(obj);
		}
	}

	private FlyingObject nextOne() {
		Random random = new Random();
		int type = random.nextInt(20); // [0,20)

		Enemy e = new Enemy();
		if (type < 4) {
			
			e.setImage(this.fj1);
			e.setBulletType(0);
			e.setLife(3);
			
		} else if (type < 9) {
			
			e.setImage(this.fj2);
			e.setBulletType(0);
			e.setLife(4);
			
		} else if (type < 13) {
			
			e.setImage(this.fj3);
			e.setBulletType(1);
			e.setLife(4);
			
		} else if (type < 16) {
			
			e.setImage(this.fj4);
			e.setBulletType(2);
			e.setLife(10);
			
		} else if (type < 19) {
			
			e.setImage(this.fj5);
			e.setBulletType(3);
			e.setLife(10);
			
		} else if (type == 19) {
			
			SetBoss(e);
		}
		return e;
	}

	private void SetBoss(Enemy e) {
		e.setBulletType(10);
	}

	// objectstep �����ƶ�
	public void objectstep() {
		for (int i = 0; i < heros.size(); i++) {
			heros.get(i).step();
		}

		// �ӵ��ƶ�
		for (int i = 0; i < this.bullets.size(); i++) {
			bullets.get(i).step();
		}

		// �������ƶ�
		for (int i = 0; i < enemys.size(); i++) {
			enemys.get(i).step();
		}
	}

	/**
	 * �軭���еĶ���
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // ������ͼ
		paintHero(g); // ��Ӣ�ۻ�
		paintBullets(g); // ���ӵ�
		paintFlyingObjects(g); // ��������
		paintScore(g); // ������
		paintState(g); // ����Ϸ״̬
	}

	/** ��Ӣ�ۻ� */
	public void paintHero(Graphics g) {
		for (int i = 0; i < heros.size(); i++) {
			Hero hero = heros.get(i);
			if (hero.getLife() != 0) {
				g.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
			}

		}
	}

	/** ���ӵ� */
	public void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			g.drawImage(b.getImage(), b.getX() - b.getWidth() / 2, b.getY(), null);
		}
	}

	/** �������� */
	public void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < enemys.size(); i++) {
			FlyingObject f = enemys.get(i);
			g.drawImage(f.getImage(), f.getX(), f.getY(), null);
		}
	}

	/** ������ */
	public void paintScore(Graphics g) {
		int x = 10; // x����
		int y = 60; // y����
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 22); // ����
		g.setColor(new Color(0xFF0000));
		g.setFont(font); // ��������
		g.drawString("SCORE:" + score, x, y); // ������

		for (int i = 0; i < heros.size(); i++) {
			y = y + 20; // y������20
			g.drawString(String.valueOf(i + 1) + "P LIFE:" + heros.get(i).getLife(), x, y); // ����
		}
	}

	/** ����Ϸ״̬ */
	public void paintState(Graphics g) {
		switch (this.state) {
		case MENU:
			paintMenu(g);
			break;
		case START: // ����״̬
			g.drawImage(start, 10, 10, null);
			break;
		case PAUSE: // ��ͣ״̬
			g.drawImage(pause, windows_X - pause.getWidth() / 2, windows_Y, null);
			break;
		case GAME_OVER: // ��Ϸ��ֹ״̬
			g.drawImage(gameover, windows_X - gameover.getWidth() / 2, windows_Y, null);
			break;
		}
	}

	/**
	 * ���˵� �Ʒְ�
	 */
	class Scorecard {
		private String body;
		public int x, y;

		public void setbody(String body) {
			this.body = body;
		}

		public String getBody() {
			return body;
		}
	}

	public List<Scorecard> scorecards = new ArrayList<Scorecard>();;

	public void setscorecards() {
		for (int i = 0; i < 5; i++) {
			Scorecard s = new Scorecard();
			s.setbody("ս��");
			s.x = windows_X - 80;
			s.y = windows_Y - 70 + (i * 40);
			scorecards.add(s);
		}
	}

	public void paintMenu(Graphics g) {
		if (scorecards.size() == 0) {
			System.out.print("��ȡ�Ʒְ�");
			setscorecards();
		}
		g.setColor(Color.black);
		g.fillRoundRect(windows_X - 100, windows_Y - 100, 200, 200, 60, 40);// Ϳһ��Բ�Ǿ��ο�
		g.setColor(Color.red);

		for (int i = 0; i < scorecards.size(); i++) {
			Scorecard s = scorecards.get(i);
			g.drawString(s.getBody(), s.x, s.y);
		}
	}

	/**
	 * ˫����
	 */
	private Image offScreenImage = null;

	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(this.getWidth(), this.getHeight());
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public static void main(String[] args) {
		run r = new run();
		r.initgame();
		r.rungame();
		System.out.print("exit");

	}
}
