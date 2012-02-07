import zio # <1>
import time

agent = zio.Agent("/dev/ttyUSB0") # <2>
gpio = zio.GPIO(agent) # <3>
led_pin = 12 # <4>

while True:
    # Turn on the LED
    gpio.write_pin(led_pin, 1) # <5>
    time.sleep(1)

    # Turn off the LED
    gpio.write_pin(led_pin, 0) # <5>
    time.sleep(1)      
