import com.zilogic.zio.*; // <1>

class LED {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0"); // <2>
	GPIO gpio = new GPIO(agent); // <3>
	int ledPin = 0; // <4>
	
	while (true) {
	    gpio.writeOutputPin(ledPin, 1); // <5>
	    Thread.sleep(1000);
	    
	    gpio.writeOutputPin(ledPin, 0); // <5>
	    Thread.sleep(1000);
	}
    }
}
