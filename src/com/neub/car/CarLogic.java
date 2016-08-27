package com.neub.car;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Shakil Ahmed Munna 
 * @author Md Mahadi Hasan Nahid
 * 
 * North East University Bangladesh (NEUB)
 * nahid@neub.edu.bd 
 * @version 1.0
 * 
 */

public class CarLogic extends JPanel implements KeyListener, Runnable {

	Image img;
	Image img2;
	Image road;
	Image bich;
	Image att;
	Image att2;

	// Random max min

	int max = 298;
	int min = 200;

	// score

	int score = 0;

	Random random = new Random();
	int xx = random.nextInt(max - min + 1) + min;
	Random random2 = new Random();
	int xxx = random2.nextInt(max - min + 1) + min;

	public int y1 = 0;

	int imgx1 = 0;
	int imgy1 = -190;
	int imgx2 = 0;
	int imgy2 = 15;
	int imgx3 = 0;
	int imgy3 = 300;
	int imgx4 = 0;
	int imgy4 = 600;

	private Image dbImage;
	private Graphics dbg;
	private int y2 = -160;
	// private int y3 = -290;
	// private int y4 = -470;
	private int y5 = -420;
	int yDirection, xDirection;
	private int carx = 190;
	private int cary = 400;

	int w = 42;
	int h = 100;

	boolean Finised = false;

	public CarLogic() {

		ImageIcon carimg = new ImageIcon("src/img/mycar.png");
		ImageIcon carimg2 = new ImageIcon("src/img/1.png");
		ImageIcon Road = new ImageIcon("src/img/2.png");
		ImageIcon Bich = new ImageIcon("src/img/3.png");
		ImageIcon Att = new ImageIcon("src/img/4.png");
		ImageIcon Att2 = new ImageIcon("src/img/5.png");

		img = carimg.getImage();
		img2 = carimg2.getImage();
		road = Road.getImage();
		bich = Bich.getImage();
		att = Att.getImage();
		att2 = Att2.getImage();

	} // CarFunction

	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);

	} // paint end

	public void score() {

		if (!Finised) {
			if (y2 + h == 460 || y5 + h == 460) {

				score++;
			//	System.out.println("Score " + score + " xx : " + xx + "xxx" + xxx);

			}
		}

		Rectangle carsects = new Rectangle(xx, y2, w - 5, h);
		Rectangle mycarsects = new Rectangle(carx, cary, w, h);

		Rectangle carsects2 = new Rectangle(xxx, y5, w - 5, h);

		if (carsects.intersects(mycarsects)) {

			Finised = true;
			//System.out.println(" Game Over 1");
		}

		if (carsects2.intersects(mycarsects)) {

			Finised = true;
			//System.out.println(" Game Over 2");
		}

	}

	/*
	 * public void movebar1() { y1 += 1; if (y1 + h == 515) { y1 = -80; } }
	 */

	public void movebar2() {
		y2 += 1;
		if (y2 == 515) {
			Random random = new Random();
			int newxx = random.nextInt(max - min + 1) + min;
			y2 = -80;
			xx = newxx;
		}
	}

	/*
	 * public void movebar3() { y3 += 1; if (y3 == 515) {
	 * 
	 * 
	 * } }
	 * 
	 * public void movebar4() { y4 += 1; if (y4 == 515) { y4 = -80; } }
	 */

	public void movebar5() {
		y5 += 2;
		if (y5 >= 515) {
			// y5 = -80;

			Random random2 = new Random();
			int newxxx = random2.nextInt(max - min + 1) + min;

			y5 = -80;

			xxx = newxxx;
		}
	}

	public void movesidepic() {

		imgy1 += 1;

		if (imgy1 == 510) {
			imgy1 = -290;
		}

	}

	public void movesidepic2() {

		imgy2 += 1;

		if (imgy2 == 510) {
			imgy2 = -290;
		}

	}

	public void movesidepic3() {

		imgy3 += 1;

		if (imgy3 == 510) {
			imgy3 = -290;
		}

	}

	public void movesidepic4() {

		imgy4 += 1;

		if (imgy4 == 510) {
			imgy4 = -290;
		}

	}

	public void paintComponent(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(200, y1, 20, 80);

		g.fillRect(200, y2, 20, 80);

		// g.fillRect(200, y3, 20, 80);

		// g.fillRect(200, y4, 20, 80);

		// g.fillRect(200, y5, 20, 80);

		/*
		 * g.fillRect(40, y5, 10, 100);
		 * 
		 * g.fillRect(340, y5, 10, 100);
		 */

		// background fixed image

		g.drawImage(img2, 0, 0, 180, 300, this);
		g.drawImage(road, 191, 0, 170, 310, this);
		g.drawImage(bich, 372, 0, 15, 541, this);

		// side image

		g.drawImage(img2, imgx1, imgy1, 190, 310, this);
		g.drawImage(img2, imgx2, imgy2, 190, 310, this);

		g.drawImage(img2, imgx3, imgy3, 190, 310, this);
		g.drawImage(img2, imgx4, imgy4, 190, 310, this);

		// Road

		g.drawImage(road, 191, imgy1, 190, 310, this);
		g.drawImage(road, 191, imgy2, 190, 310, this);
		g.drawImage(road, 191, imgy3, 190, 310, this);

		// bich image

		g.drawImage(bich, 372, imgy1, 15, 541, this);
		g.drawImage(bich, 372, imgy2, 15, 541, this);
		g.drawImage(bich, 372, imgy3, 15, 541, this);

		// my car image
		if (!Finised) {
			g.drawImage(img, carx, cary, w, h, this);
		}

		// attract car image

		g.drawImage(att, xx, y2, w - 5, h, this);
		g.drawImage(att2, xxx, y5, w - 5, h, this);

		// Display Score

		g.setFont(new Font("Arial", Font.BOLD, 16));
		// g.setColor(new Color(255, 20, 147)); //
		g.setColor(Color.orange);

		g.drawString("Score : " + score, 480, 222);

		if (Finised) {
			g.setFont(new Font("Arial", Font.BOLD, 19));

			g.setColor(new Color(255, 20, 147));

			g.drawString("Game Over ", 467, 255);
			
			g.drawImage(img ,490 ,290 , 56, 120, this);

		}

		repaint();

	} // paintComponent

	@Override
	public void run() {

		try {

			while (true) {

				move();

				// movebar1();
				movebar2();
				// movebar3();
				// movebar4();
				movebar5();

				movesidepic();
				movesidepic2();
				movesidepic3();
				movesidepic4();

				score();

				Thread.sleep(4);

			}

		} catch (Exception e) {
			System.out.println("Error");
		}

	} // run end

	// ==============================================

	public void move() {

		carx += xDirection;
		cary += yDirection;

		if (carx <= 189) {
			carx = 190;
		} else {
			carx += -5;
		}
		if (carx >= 314) {
			carx = 315;
		} else {
			carx += 5;
			// System.out.println(carx);

		}
		if (cary <= 0) {
			cary = 0;
		} else {
			cary += -5;
		}
		if (cary >= 440) {
			cary = 440;
		} else {
			cary += 5;
		}

		// ================================

		// =================================

	}

	public void setXdir(int xDir) {
		xDirection = xDir;
	}

	public void setYdir(int yDir) {
		yDirection = yDir;
	}

	// =====================================================

	@Override
	public void keyPressed(KeyEvent e) {

		int KeyCode = e.getKeyCode();

		if (KeyCode == e.VK_RIGHT) {

			setXdir(+1);

		}

		if (KeyCode == e.VK_LEFT) {

			setXdir(-1);

		}

		if (KeyCode == e.VK_UP) {

			setYdir(-1);

		}
		if (KeyCode == e.VK_DOWN) {

			setYdir(+1);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int Keycode = e.getKeyCode();

		if (Keycode == e.VK_LEFT) {
			setXdir(0);
		}

		if (Keycode == e.VK_RIGHT) {
			setXdir(0);
		}

		if (Keycode == e.VK_UP) {
			setYdir(0);
		}
		if (Keycode == e.VK_DOWN) {
			setYdir(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

} // Carfunctiom end
