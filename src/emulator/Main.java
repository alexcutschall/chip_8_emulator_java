package emulator;

import chip.Chip;

// TODO: What is a thread?

public class Main extends Thread {
	
	private Chip chip8;
	
	public Main() {
		chip8 = new Chip();
		chip8.init();
		chip8.loadProgram("./pong2.c8");
		ChipFrame frame = new ChipFrame(chip8);
	}
	
	public void run() {
		
	}
	
	public static void main(String args[]) {
		Main main = new Main();
		main.start();

	}
}
