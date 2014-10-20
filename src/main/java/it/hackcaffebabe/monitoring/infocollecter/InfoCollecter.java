package it.hackcaffebabe.monitoring.infocollecter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;


/**
 * This class collect all the hardware/software/jvm specifications and produce a json file.
 * This is a final class, so it can be used only in this way:
 * <pre>{@code
 * FileWriter fw = new FileWriter( new File( "test.json" ) );
 * InfoCollecter.collect( fw );
 * }</pre>
 *  
 * @author Andrea Ghizzoni. More info at andrea.ghz@gmail.com
 * @version 1.0
 */
public final class InfoCollecter
{
	private InfoCollecter(){}

	/**
	 * This method collects data from {@link RuntimeMXBean} object and write a json file from the {@link FileWriter} given.
	 * @param fw {@link FileWriter} to write the data collected.
	 * @throws IllegalArgumentException if argument given is null.
	 * @throws IOException if there are errors while writing data.
	 */
	public static void collect(FileWriter fw) throws IllegalArgumentException, IOException{
		if(fw == null)
			throw new IllegalArgumentException( "File Writer given can not be null." );

		RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
		Map<String, String> systemProperties = runtimeBean.getSystemProperties();
		int c = systemProperties.size() - 1;
		String patternDef = "   \"%s\": \"%s\"%s\n";
		String patternNDef = "   \"%s\": \"\\n\"%s\n";
		fw.append( "{\n" );
		for(Map.Entry<String, String> entry: systemProperties.entrySet()) {
			if(entry.getKey().equals( "line.separator" )) {
				fw.append( String.format( patternNDef, entry.getKey(), (c-- == 0 ? "" : ",") ) );
			} else {
				fw.append( String.format( patternDef, entry.getKey(), entry.getValue(), (c-- == 0 ? "" : ",") ) );
			}
		}
		fw.append( "}" );
		fw.close();
	}
}
