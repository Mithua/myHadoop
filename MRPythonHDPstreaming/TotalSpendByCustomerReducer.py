#!/usr/bin/env python

import sys

currentCustomerId = 0
totalMoney = 0.0
customerId = 0

# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()

    # parse the input we got from mapper.py
    customerId, money = line.split('\t')

    # convert count (currently a string) to int
    try:
        customerId = int(customerId)
        money = float(money)
    except ValueError:
        # count was not a number, so silently
        # ignore/discard this line
        continue

    # this IF-switch only works because Hadoop sorts map output
    # by key (here: word) before it is passed to the reducer
    if currentCustomerId == customerId: 
	   totalMoney += money	        
    else:
        if currentCustomerId:
            # write result to STDOUT
            print '%d\t%s' % ( currentCustomerId,totalMoney )
        currentCustomerId = customerId
        totalMoney = money
	

# do not forget to output the last word if needed!
if currentCustomerId == customerId :
     print '%d\t%s' % ( currentCustomerId, totalMoney )