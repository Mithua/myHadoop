#!/usr/bin/env python

import sys

# input comes from STDIN (standard input)
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()
    # split the line into [ Rating, Count ]
    fields = line.split("\t")
    rating = fields[2]
    value = 1
      #--- output tuples [ Rating, Count ] in tab-delimited format--- 
    print '%s\t%s' % ( rating,value )


