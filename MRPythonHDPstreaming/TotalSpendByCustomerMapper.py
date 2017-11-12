#!/usr/bin/env python

import sys

# input comes from STDIN (standard input)
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()
    # split the line into [ Rating, Count ]
    fields = line.split(",")
    customerId = int(fields[0])
    money = fields[2]
      #--- output tuples [ Rating, Count ] in tab-delimited format--- 
    print '%d\t%s' % ( customerId,money )