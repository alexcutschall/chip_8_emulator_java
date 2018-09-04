package emulator;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import chip.Chip;

// TODO: What is graphics?

public class ChipPanel extends JPanel {

	Chip chip;
	
	public ChipPanel (Chip chip) {
		this.chip = chip;
	}
	
	public void paint(Graphics g) {
		byte[] display = chip.getDisplay();
		for(int i = 0; i < display.length; i++) {
			if (display[i] == 0) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.WHITE);
			}
			
			// TODO: What is this math???
			// Since there are 64 pixels across, you want to make sure that it
			// never hits that
			int x = (i % 64);
			int y = (int)Math.floor(i / 64);
			
			g.fillRect(x * 10, y * 10, 10, 10);
		}
	}
}
