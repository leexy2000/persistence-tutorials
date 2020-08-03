package corp.walsin.orm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import lombok.Data;

@Data
public class User2 implements Serializable {
	private static final long serialVersionUID = 5663396988341628904L;

	private String unid;
	private String name;
	private String gender;
	private Date birthday;
	private Integer age = -1;

	public void setAge() {
		if (birthday == null)
			return;
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		int yearBirth = birth.get(Calendar.YEAR);
		int monthBirth = birth.get(Calendar.MONTH);
		int dayBirth = birth.get(Calendar.DAY_OF_MONTH);
		int yearNow = now.get(Calendar.YEAR);
		int monthNow = now.get(Calendar.MONTH);
		int dayNow = now.get(Calendar.DAY_OF_MONTH);

		if (now.before(birth)) {
			this.age = 0;
		} else {
			int age = yearNow - yearBirth;
			if (monthNow > monthBirth) {
				this.age = age;
			} else if (monthNow == monthBirth) {
				this.age = (dayNow < dayBirth) ? age - 1 : age;
			} else {
				this.age = age - 1;
			}
		}
	}

	public Integer getAge() {
		if (age == -1)
			this.setAge();
		return age;
	}
}
