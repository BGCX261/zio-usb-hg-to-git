import com.zilogic.zio.*; // <1>

class Pot {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0");
	ADC adc = new ADC(agent); // <1>
	int potPin = 0; // <2>
	
	while (true) {
	    double value = adc.readPin(potPin); // <3>

	    String msg = String.format("ADC Value: %1.2f", value);
	    System.out.println(msg);

	    Thread.sleep(500);
	}
    }
}
