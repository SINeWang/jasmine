#!/bin/sh
clear
echo Starting
echo PATH="$PATH"
WORKING_HOME="$(cd "$(dirname "$0")"/../; pwd)"
PID_FILE="$WORKING_HOME/wave.pid"
echo WORKING_HOME=$WORKING_HOME
echo "***********"
JAVA=`$WORKING_HOME/bin/find-java.sh 2>/dev/null`
if [ "$JAVA"x == x ]
	then
		echo cannot find runnable binary java file, exit
		exit -1
	else
		echo JAVA="$JAVA"
fi
$JAVA -version
echo "***********"
for file in $WORKING_HOME/lib/*.jar
	do
		if [ -f $file ]
		then 
			CLASSPATH=$CLASSPATH:$file
		else
			echo ignore $file
		fi
done
echo loading wave.conf
. "$WORKING_HOME/conf/wave.conf"
cd "$WORKING_HOME/conf"
PWD=`pwd`
echo PWD=$PWD
echo "***********"
echo WAVE_MAIN_CLASS="$WAVE_MAIN_CLASS"
echo WAVE_MAIN_ARGS="$WAVE_MAIN_ARGS"
CMD="$JAVA -Xms4g -Xmx4g -XX:PermSize=128m -XX:MaxPermSize=320m -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:-OmitStackTraceInFastThrow -Djava.net.preferIPv4Stack=true -cp $CLASSPATH $WAVE_MAIN_CLASS $WAVE_MAIN_ARGS"
echo CMD=$CMD
nohup $CMD >/dev/null 2>&1 &
echo $!>$PID_FILE
echo "***********"
echo process id [`cat $PID_FILE`]
#stty echo

