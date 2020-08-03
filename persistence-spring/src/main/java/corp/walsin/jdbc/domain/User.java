package corp.walsin.jdbc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 6829049682887130900L;

	private String unid;
	private String name;
	private String gender;
	private Date birthday;

	public Integer getAge() {
		if (birthday == null)
			return -1;
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		int yearBirth = birth.get(Calendar.YEAR);
		int monthBirth = birth.get(Calendar.MONTH);
		int dayBirth = birth.get(Calendar.DAY_OF_MONTH);
		int yearNow = now.get(Calendar.YEAR);
		int monthNow = now.get(Calendar.MONTH);
		int dayNow = now.get(Calendar.DAY_OF_MONTH);

		if (now.before(birth)) {
			return 0;
		} else {
			int age = yearNow - yearBirth;
			if (monthNow > monthBirth) {
				return age;
			} else if (monthNow == monthBirth) {
				return (dayNow < dayBirth) ? age - 1 : age;
			} else {
				return age - 1;
			}
		}
	}
}
