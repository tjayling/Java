// javaGraphics.java
package cella;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


class javaGraphics extends JFrame {
	public static final int WIDTH = 640, HEIGHT = 480;
	javaGraphics() {
		setSize(WIDTH, HEIGHT);
		//setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		setTitle("Program innit");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new drawArea());
		setVisible(true);
	}
}

class drawArea extends JPanel implements ActionListener {
	private Timer timer = new Timer(5, this);
	private Button button;
	public static final int WIDTH = javaGraphics.WIDTH, HEIGHT = javaGraphics.HEIGHT;
	public static Point mouse, location;

	public drawArea() {
		button = new Button(100, 100, 50, 20, "Start", "start");
		timer.start();
	}

	@Override protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		mouse = getMouse();
		button.draw(g, mouse);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public Point getMouse() {
		try {
			location = getLocationOnScreen();
		} catch(Exception e) {
			location = new Point(1, 1);
		}
		Point m = MouseInfo.getPointerInfo().getLocation();
		return new Point(m.x - location.x, m.y - location.y);
	}
}


class mainC {
	public static void main(String[] args) {
		new javaGraphics();
	}
}
