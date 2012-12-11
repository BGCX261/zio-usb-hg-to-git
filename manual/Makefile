small_images =  rj12.png \
		sensor0-port.png \
		sensor1-port.png \
		sensor2-port.png \
		sensor3-port.png \
		gpio0-port.png \
		gpio1-port.png \
		i2c-port.png \
		pwm-signal.png \
		pwm0-port.png \
		pwm1-port.png \
		spi0-port.png \
		spi1-port.png \
	       	led-series.png \
		relay.png \
		opto-coupler.png \
		cmos-ttl-input.png \
	       	comparator.png \
		voltage-bjt.png \
		voltage-mosfet.png \
	       	i2c-device.png \
		i2c-5v-tolerant-device.png \
	       	spi-device.png \
		spi-eeprom.png \
		spi-5v-tolerant-device.png \
		opto-coupler-input.png \
	       	ldr.png \
		voltage-sensor-3v.png \
		voltage-sensor-3v-internal.png \
	       	voltage-sensor-15v.png \
		transistor-buffer.png \
	       	temp-sensor.png \
		l298.png \
		pwm-motor.png \
		pwm-dac.png \
		port-pin-map.png

large_images = blocks.png h-bridge.png

tutorial_images = led.png switch.png io-expander.png pot.png led-brightness.png spi-eeprom.png

images = $(small_images) $(tutorial_images) $(large_images) 

code = 

VER-API = 1.3
VER-CPANEL = 1.3
REL-API  = 1
REL-CPANEL = 1
$(small_images): EXPORT_WIDTH=1024
$(large_images): EXPORT_WIDTH=2048

manual.pdf: STYLE_CLASS = document
manual.pdf: $(images) $(code)
manual.pdf: manual.txt

tutorial.pdf: STYLE_CLASS = document
tutorial.pdf: $(tutorial_images)

manual.txt : manual.in
	sed  -e "s/@VER-API@/$(VER-API)/g" \
	-e "s/@VER-CPANEL@/$(VER-CPANEL)/g" \
	-e "s/@REL-API@/$(REL-API)/g" \
	-e "s/@REL-CPANEL@/$(REL-CPANEL)/g" $< > $@
clean:
	rm -f $(images) *.pdf
	rm -f manual.txt

include $(STYLE_DIR)/Makefile.rules