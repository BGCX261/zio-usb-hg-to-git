import zio
import time

agent = zio.Agent("/dev/ttyUSB0")
pwm = zio.PWM(agent) # <1>
pins = [0] # <2>

pwm.set_freq(pins, 2) # <3>
pwm.set_duty(pins, 0) # <4>
pwm.start(pins) # <5>

while (1):
    for i in range(0, 100, 3):
        pwm.set_duty(pins, i)
        time.sleep(0.01)
