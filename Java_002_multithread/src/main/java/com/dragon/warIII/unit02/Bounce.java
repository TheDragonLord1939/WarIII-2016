package com.dragon.warIII.unit02;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows an animated bouncing ball.
 * @version 1.33 2007-05-17
 * @author Cay Horstmann
 */
public class Bounce {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * The frame with ball component and buttons
 */
class BounceFrame extends JFrame{
	
	private BallComponent comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	private static int count = 0;
	
	/**
	 * Constructs the frame with the component for showing the bouncing ball and Start and Close
	 */
	public BounceFrame() {
		setTitle("Bounce");
		
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel  = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});
		
		addButton(buttonPanel, "Close", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("closeThread==>"+Thread.currentThread().getName());;
				System.exit(0);
				
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		
	}
	
	/**
	 * Adds a button to a container.
	 * @param c the container
	 * @param title the button title
	 * @param listener the action listener for the button
	 */
	public void addButton(java.awt.Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	/**
	 * Adds a bouncing ball to the panel and makes it bounce 1000 times 
	 */
	public void addBall() {
			Ball ball = new Ball();
			count ++;
			comp.add(ball);
			Runnable r = new BallRunnable(ball, comp);
			Thread t = new Thread(r);
			System.out.println("addBallThread==>"+t.currentThread().getName());
			t.start();
	}
}

class BallRunnable implements Runnable{

	private Ball ball;
	private Component component;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;
	
	public BallRunnable(Ball aBall, Component aComponent) {
		ball = aBall;
		component = aComponent;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 1; i < STEPS; i++) {
				ball.move(component.getBounds());
				component.paint(component.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}























