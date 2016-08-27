package com.neub.car;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


/**
 *
 * @author NAHID
 */
public class GameFrame {
    
    public GameFrame() {
		
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		
		JFrame carFrame = new JFrame();
		CarLogic carLogic = new CarLogic();
		
		Thread th = new Thread(carLogic);
		th.start();
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
		}
		carFrame.addKeyListener(carLogic);
		carFrame.add(carLogic);		
		carFrame.setTitle("Car Game");
		carFrame.setSize((int)width - 400,(int)height - 200);
		carFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//carj.setResizable(false);
		carFrame.setVisible(true);
		carFrame.setBackground(Color.GRAY);
		carFrame.setLocationRelativeTo(null);
		
	
		
	}
}
