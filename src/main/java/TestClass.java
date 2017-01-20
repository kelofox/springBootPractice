import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import com.test.springBoot.entity.Phone;

public class TestClass {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Locale locale = Locale.getDefault();
		String code = locale.CHINA.toString();
		System.out.println(code);
		Phone phone = new Phone();
		Field[] field = phone.getClass().getDeclaredFields();
		for(int i = 0;i<field.length;i++){
			String propName = field[i].getName();
			propName = propName.substring(0,1).toUpperCase()+propName.substring(1);
			String propType = field[i].getGenericType().toString();
			Method m = phone.getClass().getMethod("get"+propName);
			String value = (String) m.invoke(phone);
			System.out.println(propName);
			System.out.println(propType);
			System.out.println(value);
		}
	}
	
}
