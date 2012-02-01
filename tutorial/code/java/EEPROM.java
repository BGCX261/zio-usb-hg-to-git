import com.zilogic.zio.*; // <1>

class EEPROM {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0");
	SPI spi = new SPI(agent); // <1>
	GPIO gpio = new GPIO(agent); // <2>
	int ssPin = 20;

	spi.config(100,
		   SPI.CPOL_IDLE_LOW,
		   SPI.CPHASE_LEAD_EDGE,
		   SPI.ENDIAN_MSB_FIRST); // <3>

	int[] wdata;
	int[] rdata;
	int addr = 0x2;

	gpio.writePin(ssPin, 1); // <4>
	
	try {
	    wdata = new int[] { 0x03, addr, 0x00, 0x00 };
	    rdata = spi.writeRead(wdata); // <5>
	} finally {
	    gpio.writePin(ssPin, 0); // <4>
	}

	String msg = String.format("EEPROM has 0x%02X%02X at address 0x%04X",
				   rdata[2], rdata[3], addr);
	System.out.println(msg);
	agent.close();
    }
}
