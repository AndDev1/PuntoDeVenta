#!/bin/sh
# startDemo.sh
#
# Copyright (c) 2003-2004 Stand By Soft, Ltd. All rights reserved.
#
# This software is the proprietary information of Stand By Soft, Ltd.
# Use is subject to license terms.

LOCALCLASSPATH="$CLASSPATH"
LOCALCLASSPATH="lib":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/jdatepicker.jar":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/jdatepicker-i18n.jar":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/jdatepicker-binding.jar":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/jdatepicker-demo.jar":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/looks-2.1.1.jar":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/binding.jar":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/jlfgr-1_0.jar":"$LOCALCLASSPATH"
LOCALCLASSPATH="lib/quaqua.jar":"$LOCALCLASSPATH"

java -cp $LOCALCLASSPATH com.standbysoft.demo.date.Main