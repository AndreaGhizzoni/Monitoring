# Generic Monitoring library for Desktop applications:
All the projects listed below have the docs inside the jar.

## How to use ResourceMonitor:
To instance the most basic resource monitor just call:
```sh
ResourceMonitor r = new ResourceMonitor();
```
Otherwise there is a constructor to specify the updating rate and if the corrispondig frame will be always on top.
```sh
ResourceMonitor r = new ResourceMonitor(500, true);
```
ResourceMonitor extends Thread class, so you need to start it:
```sh
r.run();
```

## How to use Logger:
Here is the logger initialization:
```sh
Logger l = Logger.getInstance();
```
Now, where you need, you can call:
```sh
l.write( Tag.DEBUG, "some message" );
```
to write a DEBUG string on Standard out.

When you put your code in production, you can set this Logger to exclude DEBUG log:
```sh
l.disableTag( Tag.DEBUG );
```
and change the out stream on File (for example):
```sh
l.setPrintStream(new PrintStream(new File("path/to/file.log")));
```


## How to use InfoCollecter:
InfoCollecter is a final class, so could be use directly like this:
```sh
FileWriter fw = new FileWriter( new File( "test.json" ) );
InfoCollecter.collect( fw );
```