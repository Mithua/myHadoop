#!/usr/bin/env python

import sys

# input comes from STDIN (standard input)
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()
    # split the line into words
    fields = line.split(",")
    age = fields[2]
    numFriends = fields[3]
      #--- output tuples [Age, FriendsNumber] in tab-delimited format--- 
    print '%s\t%s' % ( age,numFriends )


