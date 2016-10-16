#!/usr/bin/python
import Adafruit_DHT
import RPi.GPIO as GPIO
import datetime
import time

def read():
  sensorIn = Adafruit_DHT.DHT11;
  pinInside = 11;

  GPIO.setmode(GPIO.BCM);

  GPIO.setup(pinInside, GPIO.IN, pull_up_down = GPIO.PUD_UP);

  humidityInside, temperatureInside = Adafruit_DHT.read_retry(sensorIn, pinInside);
  GPIO.cleanup();

  ts = time.time();
  now = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S');
  
  message = now +" Temp = {0:0.0f}* | Humidity = {1:0.0f}%".format(temperatureInside,humidityInside);

  return message;

message = read();
target = open('/home/pi/fungo/TempAndHumidity.txt', 'w+')
target.write(message)
target.close()
print(message)
