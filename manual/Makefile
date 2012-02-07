small_images =  pwm-signal.png \
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

large_images = frc10.png frc14.png zio-blocks.png h-bridge.png

tutorial_images = led.png switch.png io-expander.png pot.png led-brightness.png spi-eeprom.png

images = $(tutorial_images) $(large_images) 

code = 

$(small_images): EXPORT_WIDTH=1024
$(large_images): EXPORT_WIDTH=2048

manual.pdf: STYLE_CLASS = document
manual.pdf: $(images) $(code)

tutorial.pdf: STYLE_CLASS = document
tutorial.pdf: $(tutorial_images)

clean:
	rm -f $(images) *.pdf

include $(STYLE_DIR)/Makefile.rules

