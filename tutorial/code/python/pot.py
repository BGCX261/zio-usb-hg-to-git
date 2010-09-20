import zio
import time

agent = zio.Agent("/dev/ttyUSB0")
sensor = zio.Sensor(agent) # <1>
pot_pin = 0 # <2>

while True:
    value = sensor.read_pin(pot_pin) # <3>
    print "Sensor Value: %1.2f" % value

    time.sleep(0.5)
