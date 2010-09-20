import zio

agent = zio.Agent("/dev/ttyUSB0")
spi = zio.SPI(agent) # <1>
gpio = zio.GPIO(agent) # <2>
ss_pin = 4

freq = spi.config(100,
                  zio.SPI.CPOL_IDLE_LOW,
                  zio.SPI.CPHASE_LEAD_EDGE,
                  zio.SPI.ENDIAN_MSB_FIRST) # <3>

gpio.write_output_pin(ss_pin, 1) # <4>

try:
    addr = 0x2
    read = spi.write_read([ 0x03, addr, 0x00, 0x00 ]) # <5>
finally:
    gpio.write_output_pin(ss_pin, 0) # <4>

print "EEPROM has 0x%02X%02X at address 0x%04X" % (read[2], read[3], addr)
