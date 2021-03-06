package it.hackcaffebabe.monitoring.logger;

/**
 * Enumerator to describe the level of log message.
 * @author Andrea Ghizzoni. More info at andrea.ghz@gmail.com
 * @version 1.0
 */
public enum Tag
{
	/** Default tag for Information log*/
	INFO,
	/** Default tag for Debugging log*/
	DEBUG,
	/** Default tag for Errors log*/
	ERRORS,
	/** Default tag for Warning log*/
	WARNING,
	/** Default tag for Fatal Error log*/
	PANIC,
	/** Default tag for Verbose log*/
	VERBOSE;
}
