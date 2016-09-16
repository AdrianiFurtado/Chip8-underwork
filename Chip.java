
import java.util.Arrays;

public class Chip{

	private char opcode;
	private char[] memory;
	private char[] V;
	private char[] stack;
	private char I;
	
	private int sp;
	private int pc;

	public byte[] display;
	public byte[] keys;

	private int delay_timer;
	private int sound_timer;


	Font font = new Font();

	public void Init(){

		memory = new char[4096];
		V = new char[16];
		stack = new char[16];
		
		sp = 0;
		I = 0;
		pc = 0x200;
		opcode = 0;

		display = new byte[64 * 32];
		keys = new byte[16];
		
		delay_timer = 0;
		sound_timer = 0;
	
		//Load Fontset
		for(int i = 0; i < 80 ; i++)
			memory[i] = font.fontset[i];

	}

	private void ClearDisplay(byte[] display){

		Arrays.fill(display, (byte)0);

	}

	public void EmulateCycle(){
	
		//Fetch Opcode
		opcode = (char) ((memory[pc] << 8) | memory[pc + 1]);

		//Decode Opcode
		switch(opcode & 0xF000){

			case 0x0000:
				switch(opcode & 0x000F){

					case 0x0000:
						//Clear Screen
						ClearDisplay(display);
					break;

					
					case 0x000E:
						//Return From subroutine
						sp--;
						pc = (int)stack[sp];
					break;


					default:
						System.err.println("Unknown Opcode");

				}
			break;

			
			case 0x1000:
				//Jump to address NNN
				pc = opcode & 0x0FFF;
			break;
	
			
			case 0x2000:
		
				stack[sp] = (char)pc;
				sp++;
				pc = opcode & 0x0FFF;

			break;

			
			case 0x3000:                                
				//Skip instruction if VX == NN
				if(V[opcode & 0x0F00] == )

			break;

			
			case 0x4000:                                
			
			break;


			case 0x5000:                                
			
			break;


			case 0x6000:                                
			
			break;


			case 0x7000:                                
			
			break;

			
			case 0x8000:                                
			
			break;

			
			case 0x9000:                                
			
			break;

			
			case 0xA000:                                
			
			break;

			
			case 0xB000:                                
			
			break;

			
			case 0xC000:                                
			
			break;

			
			case 0xD000:                                
			                        
			break;

			
			case 0xE000:                                
			                        
			break;

			
			case 0xF000:                                
			                        
			break;
		}		
		
		//Execute Opcode



	}
}
