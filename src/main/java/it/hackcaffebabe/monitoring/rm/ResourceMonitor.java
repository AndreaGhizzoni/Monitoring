package it.hackcaffebabe.monitoring.rm;

/**
 * Simple Resource Monitor for desktop applications.This is a graphical tool to
 * keep monitored the amount of heap memory used and free.To instance the most
 * basic resource monitor just call:
 * <pre>{@code
 * ResourceMonitor r = new ResourceMonitor();
 * }</pre>
 * ResourceMonitor extends {@link Thread} class, so you need to start it:
 * <pre>{@code
 * r.run();
 * }</pre>
 *  
 * @author Andrea Ghizzoni. More info at andrea.ghz@gmail.com
 * @version 1.1
 */
public final class ResourceMonitor extends Thread
{
	/** The default sleep time of monitor */
	public static final int DEFAULT_SLEEP_TIME = 1000;
	protected int sleepTime = DEFAULT_SLEEP_TIME;
	protected boolean frameAlwaysOnTop = false;

	/**
	 * Instance a Resource monitor with a sleep time given and a flag for his
     * frame.
	 * @param sleepTime int the sleep time of this thread.
	 * @param frameAlwaysOnTop boolean if you want that the frame will be always
     *                         on top.
	 */
	public ResourceMonitor(int sleepTime, boolean frameAlwaysOnTop){
		if(sleepTime > 0)
			this.sleepTime = sleepTime;
		this.frameAlwaysOnTop = frameAlwaysOnTop;
	}

	/**
     * Instance a simple Resource Monitor that use the standard update time to
     * update the statistics.
     */
	public ResourceMonitor(){}

//==============================================================================
// OVERRIDE
//==============================================================================
	@Override
	public void run(){
		ResourceMonitorFrame frame = new ResourceMonitorFrame();
		frame.setAlwaysOnTop( this.frameAlwaysOnTop );

		String max, tot, free;
		String maxP = "-max heap size %15d MB";
		String totP = "-total memory  %15d MB";
		String freeP = "-free heap     %15d KB";

        int k = 1024;
        int m = k * k;
		while( true ) {
			max = String.format( maxP, (Runtime.getRuntime().maxMemory() / m) );
			tot = String.format( totP, (Runtime.getRuntime().totalMemory() / m) );
			free = String.format( freeP, (Runtime.getRuntime().freeMemory() / k) );

			frame.pnl.update( max, tot, free );
			try {
				if(frame.isVisible())
					Thread.sleep( sleepTime );
				else break;
			} catch(InterruptedException e) {}
		}
	}
}
