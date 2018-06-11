// Button.java
package cella;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Button extends MouseAdapter {
	int x, y, w, h;
	String ph, val;
	boolean mouseDown;
	Color LIGHTGRAY = new Color(200, 200, 200);
	public Button(int xt, int yt, int wt, int ht, String pht, String valt) {
		x = xt;
		y = yt;
		w = wt;
		h = ht;
		ph = pht;
		val = valt;
		mouseDown = false;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				System.out.println(me);
			}
		});
	}

	public void draw(Graphics g, Point mouse) {
		if (contains(mouse)) {
			g.setColor(Color.GRAY);
		} else {
			g.setColor(LIGHTGRAY);
		}
		g.fillRect(x, y, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, w, h);
		g.drawString(ph, x + 5, y + h - 5);
	}

	private boolean contains(Point pos) {
		if (pos.x > x && pos.x < x + w && pos.y > y && pos.y < y + h) {
			return true;
		} else {
			return false;
		}
	}
	public boolean pressed(Point pos) {
		if (contains(pos) && mouseDown) {
			System.out.println("Pressed");
			return true; 
		}
		else return false;
	}
}
