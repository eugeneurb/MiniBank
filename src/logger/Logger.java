package logger;

public interface Logger {

    void log(LogLevel level, Class clazz, String message);
    void debug (final String message);
    void info (final String message);
    void warn (final String message);
    void error (final String message);
    void fatal (final String message);
}
