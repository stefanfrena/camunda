#!/usr/bin/python

target = open('/home/pi/fungo/TempAndHumidity.txt', 'r')
entry = target.read()
target.close()

log = open('/home/pi/fungo/logs/fungo.log', 'r')
loglines = log.read()
log.close()
print(entry)
print(loglines)
