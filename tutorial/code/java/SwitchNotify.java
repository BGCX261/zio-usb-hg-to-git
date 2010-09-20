import com.zilogic.zio.*;

class SwitchNotify {
    public static void main(String args[]) 
	throws ProtocolException, InterruptedException {

	Agent agent = new Agent("/dev/ttyUSB0");
	GPIO gpio = new GPIO(agent);

	GPIOChangeListener listener = new GPIOChangeListener() {
		public void inputChanged(GPIOChangeEvent event) { // <1>
		    int switchPin = 0;
		    
		    if (event.getPin() != switchPin) // <2>
			return;

		    if (event.getValue() == 1)
			System.out.println("Switch Off");
		    else
			System.out.println("Switch On");
		}
	    };

	gpio.addChangeListener(listener); // <3>
	agent.waitForEvents(); // <4>
    }
}
