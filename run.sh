#!/bin/bash

javac Simulation.java
java Simulation scenario.txt
rm aircrafts/*.class
rm weather/*.class
rm avajutils/*.class
rm Simulation.class