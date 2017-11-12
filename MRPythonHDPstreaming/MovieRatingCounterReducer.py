#!/usr/bin/env python

import sys

currentRating = 0
totalCount = 0
rating = 0


# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()

    # parse the input we got from mapper.py
    rating, count = line.split('\t')

    # convert count (currently a string) to int
    try:
        rating = int(rating)
	count = int(count)

    except ValueError:
        # count was not a number, so silently
        # ignore/discard this line
        continue

    # this IF-switch only works because Hadoop sorts map output
    # by key (here: word) before it is passed to the reducer
    if currentRating == rating:        
	totalCount += count
    else:
        if currentRating:
            # write result to STDOUT
            print '%s\t%s' % ( currentRating,totalCount )
        currentRating = rating
        totalCount = count
	

# do not forget to output the last word if needed!
if currentRating == rating:
     print '%s\t%s' % ( currentRating, totalCount )