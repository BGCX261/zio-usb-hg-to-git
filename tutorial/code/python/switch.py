import zio
import time

agent = zio.Agent("/dev/ttyUSB0")
gpio = zio.GPIO(agent)
switch_pin = 0 # <1>

while True:
    state = gpio.read_input_pin(switch_pin) # <2>
    if state:
        print "Switch Off"
    else:
	print "Switch On"

    time.sleep(0.5)
