package Productos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	public Menu() {
		setOpaque(false);
		setPreferredSize(new Dimension(313, 803));
		setLayout(null);
	}
	
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		GradientPaint g1 = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
		g2.setPaint(g1);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
		super.paintChildren(g);
	}
}
