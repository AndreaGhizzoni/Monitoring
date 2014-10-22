# Generic Monitoring library for Desktop applications:
[![Version](http://img.shields.io/badge/version-1.0.4-blue.svg?)](https://github.com/AndreaGhizzoni/Monitoring/releases/tag/v1.0.4) [![License](http://img.shields.io/badge/license-MIT-blue.svg)](http://opensource.org/licenses/MIT) ![Status](http://img.shields.io/badge/build-STABLE-green.svg) 
[![Dependecies](http://img.shields.io/badge/dependency-Java 8-red.svg?)](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

## Before to start...
Add the ready-to-use jars (main and docs) files from *build/libs* to your class path. 
Check out the documents in jar to have all the information about this library.

## How to use ResourceMonitor:
To instance the most basic resource monitor just call:

    ResourceMonitor r = new ResourceMonitor();

Otherwise there is a constructor to specify the updating rate and if the corrispondig frame will be always on top.

    ResourceMonitor r = new ResourceMonitor(500, true);

ResourceMonitor extends Thread class, so you need to start it:
    
    r.run();

## How to use Logger:
Here is the logger initialization:
    
    Logger l = Logger.getInstance();

Now, where you need, you can call:
    
    l.write( Tag.DEBUG, "some message" );

to write a DEBUG string on Standard out.
When you put your code in production, you can set this Logger to exclude DEBUG log:

    l.disableTag( Tag.DEBUG );

and change the out stream on File (for example):
    
    l.setPrintStream(new PrintStream(new File("path/to/file.log")));

## How to use InfoCollecter:
InfoCollecter is a final class, so could be use directly like this:

    FileWriter fw = new FileWriter( new File( "test.json" ) );
    InfoCollecter.collect( fw );