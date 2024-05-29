

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	public Menu() {
		setOpaque(false);
		setBounds(0, 0, 268, 800);
	}
	
	@Override
	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		GradientPaint g1 = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
		g2.setPaint(g1);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintChildren(g);
	}
	
	

}
