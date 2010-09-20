import zio
import sys

agent = zio.Agent("/dev/ttyUSB0")
i2c = zio.I2C(agent) # <1>
dev = 0x20 # <2>

i2c.config(100) # <3>
try:
    i2c.write(dev, [0xFF]) # <4>
    data = i2c.read(dev, 1) # <5>
except I2CNoAckException, e:
    print e
    sys.exit(1)

print "IO Expander Input: 0x%02X" % data[0];
