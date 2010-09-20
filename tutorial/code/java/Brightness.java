import com.zilogic.zio.*;

class Brightness {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0");
	PWM pwm = new PWM(agent); // <1>
	int ledPin = 0x1; // <2>

	pwm.setFreq(ledPin, 2); // <3>
	pwm.setDuty(ledPin, 0); // <4>
	pwm.start(ledPin); // <5>
	
	while (true) {
	    for (int i = 0; i < 100; i += 3) {
		pwm.setDuty(ledPin, i);
		Thread.sleep(10);
	    }
	}
    }
}
