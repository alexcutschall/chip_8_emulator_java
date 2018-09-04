package emulator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import chip.Chip;

//  TODO: Research JFrame
//  TODO: Research getInsets
//  TODO: Study all of this

public class ChipFrame extends JFrame {
	
	ChipPanel panel;
	
	public ChipFrame(Chip chip) {
		setPreferredSize(new Dimension(640, 320));
		pack();
		setPreferredSize(new Dimension(640 + getInsets().left + getInsets().right,
						320 + getInsets().top + getInsets().bottom));
		panel = new ChipPanel(chip);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Chip 8 Emulator");
		pack();
		setVisible(true);
	}

}
