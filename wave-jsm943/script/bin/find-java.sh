#!/bin/sh
if [ -x "`which java`" ]; then
                JAVA="`which java`"
    else
        if [ "$JAVA_HOME"x == x ]; then
            JAVA="$JAVA_HOME/jre/bin/java"
        else
            exit
        fi
fi
echo "$JAVA"