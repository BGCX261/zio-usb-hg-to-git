import zio
import time

agent = zio.Agent("/dev/ttyUSB0")
adc = zio.ADC(agent) # <1>
pot_pin = 0 # <2>

while True:
    value = adc.read_pin(pot_pin) # <3>
    print "ADC Value: %1.2f" % value

    time.sleep(0.5)
