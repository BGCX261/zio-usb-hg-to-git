import com.zilogic.zio.*; // <1>

class LED {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0"); // <2>
	GPIO gpio = new GPIO(agent); // <3>
	int ledPin = 12; // <4>
	
	while (true) {
	    gpio.writePin(ledPin, 1); // <5>
	    Thread.sleep(1000);
	    
	    gpio.writePin(ledPin, 0); // <5>
	    Thread.sleep(1000);
	}
    }
}
