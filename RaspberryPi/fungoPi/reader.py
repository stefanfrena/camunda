
#!/usr/bin/python
import Adafruit_DHT
import RPi.GPIO as GPIO


#read data from sensors
def read():
  sensorIn = Adafruit_DHT.DHT11;
  pinInside = 11;

  GPIO.setmode(GPIO.BCM);

  GPIO.setup(pinInside, GPIO.IN, pull_up_down = GPIO.PUD_UP);

  humidityInside, temperatureInside = Adafruit_DHT.read_retry(sensorIn, pinInside);
  GPIO.cleanup();
  message = "Temp = {0:0.0f}* | Humidity = {1:0.0f}%".format(temperatureInside,humidityInside);
  #message ="hallo";
  return message;

def main():
  print("mocked 9");

#main();
message = read();
print(message);
