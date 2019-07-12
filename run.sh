#!/bin/bash

find * -name "*.java" > sources.txt
javac @sources.txt
java Simulation scenario.txt
rm aircrafts/*.class
rm weather/*.class
rm avajutils/*.class
rm Simulation.class