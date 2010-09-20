import com.zilogic.zio.*;

class Switch {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0");
	GPIO gpio = new GPIO(agent);
	int switchPin = 0; // <1>
	
	while (true) {
	    int state;

	    state = gpio.readInputPin(switchPin); // <2>
	    if (state == 1) {
		System.out.println("Switch Off");
	    } else {
		System.out.println("Switch On");
	    }

	    Thread.sleep(500);
	}
    }
}
