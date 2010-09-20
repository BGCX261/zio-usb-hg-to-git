#!/bin/sh

if [ $1 == "python" ]; then
    sed -e "s/# <\([0-9]\+\)>/<\1>/"
elif [ $1 == "java" ]; then
    sed -e "s/\/\/ <\([0-9]\+\)>/<\1>/" 
else
    cat
fi