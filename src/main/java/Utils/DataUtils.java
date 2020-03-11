package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

	public static Date ObterDataComDiferencaDias(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
	}
	
	public static String ObterDataFormadata(Date data) {
		DateFormat fomate = new SimpleDateFormat("dd/MM/YYYY");
		return fomate.format(data);
	}// quando o método é static não é necessario instanciar "new"
}
