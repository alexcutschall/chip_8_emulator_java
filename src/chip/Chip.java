package chip;

public class Chip {
	
	// Before coding anything, you want to know a little bit about the Chip 8 program
	// These steps are based on the how the wikipedia page goes down the line
	// Step 1) Figure out how much memory it has
	// Step 2) Figure out how many registers it has
	// Step 3) Setting up the Stack interface
	// Step 4) Setting up the Delay Timer
	// Step 5) Setting up Input
	// Step 6) Initialize Display
	// Step 7) Create an init function that sets all the variables up
	// Step 8) Create a run function
				// This step is broken up into several sections documented
				// in the run function
	// Step 9) Setting up Display
	    // Setting up a ChipFrame class that extends JFrame
	    // TODO: Study JFrame. What is it?
		// TODO: Study JPanel. What is it?
	// Step 10) Creating multiple threads
		// First Thread: To Update the Chip
		// Second Thread: To Update the Frame and keep it "steady"
	
	// Memory:
	//  4096 (0x1000) memory locations, each of which are 8 byte
	//  In this tutorial, it will be using more memory than it actually has
	
	// Registers:
	//  The Chip-8 has 16, 8 byte data registers named V0 - VF
	//  Last register is the "carry flag"
	//  TODO: Find out what a carry flag is
	
	// Address Register (I):
	// TODO: What is a Address Register?
	//  The address register, which is named I, is 16 bits wide 
	//  and is used with several opcodes that involve memory operations.
	
	// Stack:
	//  The stack is only used to store return addresses when subroutines are called. 
	//  The original 1802 version allocated 48 bytes for up to 24 levels of nesting 
	//  Modern implementations normally have at least 16 levels. --> What we are using
	
	// Timers:
	//CHIP-8 has two timers. 
	//They both count down at 60 hertz, until they reach 0.

	//Delay timer: 
		// This timer is intended to be used for timing the events of games. 
		// Its value can be set and read.
	//Sound timer: 
		// This timer is used for sound effects. 
		// When its value is nonzero, a beeping sound is made.
	
	// Input:
	//	Input is done with a hex keyboard that has 16 keys which range from 0 to F. 
	//	The '8', '4', '6', and '2' keys are typically used for directional input. 
	//	Three opcodes are used to detect input. 
	//	One skips an instruction if a specific key is pressed, 
	//	Another does the same if a specific key is not pressed. 
	//	The third waits for a key press, and then stores it in one of the 
	//	data registers.
	
	// Display:
	//  Using 0 for black and 1 for white.
	//  Easier to use for collision detection
	//  It is 64 x 32 
	
	// Other Definitions:
	//  Program Counter (PC): Where each program will start (0x200 or 512 for this)
	//    
	
	
	
	private char[] memory;
	private char[] V;
	private char I;
	private char pc;
	
	private char stack[];
	private int stackPointer;
	
	private int delayTimer;
	private int soundTimer;
	
	private byte[] keys;
	
	private byte[] display;

	public void init() {
		
		memory = new char[4096];
		V = new char[16];
		I = 0x0; // For addresses, you use this format
		pc = 0x200;
		
		// It can call 16 subroutines and if another is called it crashes
		stack = new char[16];
		stackPointer = 0;
		
		delayTimer = 0;
		soundTimer = 0;
		
		keys = new byte[16];
		
		// TODO: What's up with this syntax?
		display = new byte[64 * 32]; // Use a scaled up version of this
		//  This sets several pixels to white
		//  display[1] = 1;
		//  display[52] = 1;
		//  display[96] = 1;
	}
	
	public void run() {
		// Step 1) Fetch an Opcode
		//   Opcode consists of a 16 byte value
		//   Since our memory is only 8 byte, we will have to merge two
		//   memory slots into one
		char opcode = (char)((memory[pc] << 8) | memory[pc +1]);
		//  System.out.println(Integer.toHexString(opcode)); This results in 0
		// Step 2) Decode the Opcode
		
		// This switch statement is just checking the very first byte, so if it's 8
		// and it results in 0x8000, then it will execute
		switch(opcode & 0xF000) {
		
		case 0x8000: //contains more data in last nibble
			// This statement is checking that last statement so the opposite of
			// the first one 
			switch (opcode & 0x000F) {
			
			// 8XY0 meaning if the this switch statement equals 0 it will equal this
			// Sets VX to the value of VY.
			case 0x0000:
				default:
					System.err.println("Unsupported opcode");
					System.exit(0);
					break;
			}
			
			break;
			
			default:
				System.err.println("Unsupported opcode");
				System.exit(0);
		}
		// Step 3) Execute the Opcode
	}
	
	public byte[] getDisplay() {
		return display;
	}

}
