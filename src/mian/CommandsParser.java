package mian;

@FunctionalInterface
public interface CommandsParser {
	String[] parse(String str);
}
