#!/bin/sh
clear
echo PATH="$PATH"
WORKING_HOME="$(cd "$(dirname "$0")"/../; pwd)"
PID_FILE="$WORKING_HOME/wave.pid"
PID_COUNT=$(ps -ef | grep $(cat ${PID_FILE}) | grep -v grep | wc -l)
if [[ "$PID_COUNT" = "1" ]]
    exit 0
then
    exit -5
fi

