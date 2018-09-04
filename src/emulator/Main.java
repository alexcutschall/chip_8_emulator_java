package emulator;

import chip.Chip;

// TODO: What is a thread?

public class Main extends Thread {
	
	private Chip chip8;
	private ChipFrame frame;
	
	public Main() {
		chip8 = new Chip();
		chip8.init();
		chip8.loadProgram("./pong2.c8");
		frame = new ChipFrame(chip8);
	}
	
	public void run() {
		// Chip8 runs at 60hz
		while(true) {
			chip8.run();
			if (chip8.needsRedraw()) {
				frame.repaint();
				chip8.removeDrawFlag();
			}
			// This is 16 milliseconds
			try {
				Thread.sleep(16);
			} catch(InterruptedException e) {
				// Unthrown exception error
			}
		}
	}
	
	public static void main(String args[]) {
		Main main = new Main();
		main.start();

	}
}
