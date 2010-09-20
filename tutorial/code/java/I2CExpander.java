import com.zilogic.zio.*; // <1>

class I2CExpander {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0");
	I2C i2c = new I2C(agent); // <1>
	int dev = 0x20; // <2>
	int[] wdata = new int[] { 0xFF };
	int[] rdata;
	
	i2c.config(100); // <3>
	try {
	    i2c.write(dev, wdata); // <4>
	    rdata = i2c.read(dev, 1); // <5>
	} catch (I2CNoAckException e) {
	    System.out.println(e);
	    agent.close();
	    return;
	}

	String msg = String.format("IO Expander Input: 0x%02X", rdata[0]);
	System.out.println(msg);
	agent.close();
    }
}
