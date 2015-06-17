#!/bin/sh
WORKING_HOME="$(cd "$(dirname "$0")"/../; pwd)"
echo WORKING_HOME=$WORKING_HOME
PID_FILE="$WORKING_HOME/wave.pid"
if [ -f $PID_FILE ]
	then
		pid=`cat $PID_FILE`
		if [ ! -z pid ]
			then
				echo process $pid will be shutdown
				kill $pid
				rm "$PID_FILE"
		else
			echo nothing found
		fi
	else
		echo file {$PID_FILE} does not exist.
fi