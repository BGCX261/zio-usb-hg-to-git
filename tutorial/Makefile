tutorial_images = led.png switch.png io-expander.png pot.png led-brightness.png spi-eeprom.png zio-blocks.png
fragments = intro.txt

EXPORT_WIDTH = 2048

java_code := $(wildcard code/java/*.java)
java_code := $(java_code:.java=.java.strip)

python_code := $(wildcard code/python/*.py)
python_code := $(python_code:.py=.py.strip)

java-tutorial.pdf: STYLE_CLASS = document
java-tutorial.pdf: $(tutorial_images) $(java_code) $(fragments)

python-tutorial.pdf: STYLE_CLASS = document
python-tutorial.pdf: $(tutorial_images) $(python_code) $(fragments)

%.py.strip: %.py
	filters/strip-comment.sh python < $< > $@

%.java.strip: %.java
	filters/strip-comment.sh java < $< > $@

clean:
	rm -f $(images) *.pdf
	rm -f $(tutorial_images)

	find . -name "*.class" -delete
	find . -name "*.strip" -delete

include $(STYLE_DIR)/Makefile.rules