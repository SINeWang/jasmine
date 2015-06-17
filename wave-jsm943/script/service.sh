#!/bin/sh

PWD=$(cd "$(dirname "$0")"; pwd)
echo PWD="$PWD"
BEGIN_TIME=$(date +%s)
ACTION=$1
chmod +x "$PWD/bin/find-java.sh"
chmod +x "$PWD/bin/start.sh"
chmod +x "$PWD/bin/stop.sh"
chmod +x "$PWD/bin/status.sh"
if [ -z "$1" ] ; then
    echo "ERROR: Please specify an action: start|stop|restart|status"
    exit -1
else
    CMD="$PWD/bin/$ACTION".sh
    if [ -x "$CMD" ] ; then
        echo "About to Run \`$CMD'"
        echo "$ACTION:------BEGIN------"
        $CMD
        echo "$ACTION:-------END-------"
        END_TIME=$(date +%s)
        DURATION=$[$END_TIME-$BEGIN_TIME]
        sleep 1
        if [ -f "pash.pid" ]; then
            if [ ! -z `cat pash.pid` ] ; then
                    echo "Server $ACTION OK in $DURATION seconds".
                    exit 0
                else
                    echo "Server $ACTION ERROR in $DURATION seconds".
                    exit -2

            fi
            echo "Server $ACTION executed in $DURATION seconds".
            exit -3
        fi
    else
        echo "ERROR: CANNOT find EXECUTABLE script $CMD"
        exit -4
    fi
fi