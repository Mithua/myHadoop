#!/usr/bin/env python

import sys

currentAge = 0
count = 0
age = 0
totalNoOfFriends = 0

# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()

    # parse the input we got from mapper.py
    age, friendsCount = line.split('\t')

    # convert count (currently a string) to int
    try:
        friendsCount = int(friendsCount)
	age = int(age)

    except ValueError:
        # count was not a number, so silently
        # ignore/discard this line
        continue

    # this IF-switch only works because Hadoop sorts map output
    # by key (here: word) before it is passed to the reducer
    if currentAge == age:
        totalNoOfFriends += friendsCount
	count += 1
    else:
        if currentAge:
            # write result to STDOUT
            print '%s\t%s' % (currentAge, str(totalNoOfFriends/count))
        currentAge = age
        totalNoOfFriends = friendsCount
	count = 1

# do not forget to output the last word if needed!
if currentAge == age:
     print '%s\t%s' % (currentAge, str(totalNoOfFriends/count))