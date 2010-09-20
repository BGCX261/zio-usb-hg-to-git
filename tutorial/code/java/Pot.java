import com.zilogic.zio.*; // <1>

class Pot {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0");
	Sensor sensor = new Sensor(agent); // <1>
	int potPin = 0; // <2>
	
	while (true) {
	    double value = sensor.readPin(potPin); // <3>

	    String msg = String.format("Sensor Value: %1.2f", value);
	    System.out.println(msg);

	    Thread.sleep(500);
	}
    }
}
