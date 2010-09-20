import zio

def input_changed(event): # <1>
    global switch_pin

    if event.pin != switch_pin: # <2>
        return
    if event.value:
        print "Switch Off"
    else:
        print "Switch On"

agent = zio.Agent("/dev/ttyUSB0")
gpio = zio.GPIO(agent)
switch_pin = 0
gpio.add_change_handler(input_changed) # <3>

agent.wait_for_events() # <4>
