package mian;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** * 
 * @author Evgeny
 *	This class objects parse strings to string arrays that can be used for 
 *	send queries mysql db
 *
 *	NEED TO FINISH ADDPARSE!
 */
public class Parser implements CommandsParser {
	private String addRegex = "";
	private String deleteRegex = "^delete_(item|town|shipping) +\\%[0-9]+\\%$";
	private String showRegex = "^show_(items|towns|shippings)$";
	private Matcher matcher = null;
	private Pattern pattern = null;	
	
	private boolean flag = false;
	private String[] commands;
	private String str = null;
	
	@Override
	public String[] parse(String str) {
		commands = null;
		flag = false;
		if (str == null || str.isEmpty()) return commands;
		this.str = str;
		this.str = str.trim();
		showParse();
		if	(flag) return commands;
		deleteParse();
		if	(flag) return commands;
		
		return commands;
	}
	
	private void showParse() {
		pattern = Pattern.compile(showRegex);
		matcher = pattern.matcher(str);
		if (matcher.find()) {
			commands = new String[1];
			commands[0] = str;
			flag = true;
		}
	}
	
	private void deleteParse() {
		pattern = Pattern.compile(deleteRegex);
		matcher = pattern.matcher(str);
		if (matcher.find()) {
			str = str.replaceAll("%", "");
			commands = str.split("\\s+");
			flag = true;
		}
	}
	
	// need to finish this next time
	private void addParse() {
		
	}
	
	
}