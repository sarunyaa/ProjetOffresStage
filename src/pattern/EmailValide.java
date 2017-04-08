package pattern;

import java.util.regex.Pattern;

public class EmailValide {

	private Pattern pattern;
	private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	//"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.A-Za-z]{2,})$";

	public EmailValide(){
		pattern = Pattern.compile(EMAIL_PATTERN);

	}

	public boolean validate(final String email){
		return pattern.matcher(email).matches();
	}

}
