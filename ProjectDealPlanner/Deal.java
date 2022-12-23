import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
// класс Дело
public class Deal {
    private int id; // устанавливается автоматически. Изначально есть файл id со значением 0
    private String name;
    private Date createDate; // Дата создания устанавливается автоматически см. setCreateDate(...)

    private String details;

    public Deal(int id, String name, Date createDate, Date makeDate, String details) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.details = details;
    }

  public Deal(){
        this.createDate = new Date();
  }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) throws ParseException {
        this.createDate = stringToDate(createDate);
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String info) {
        this.details = info;
    }


    public static Date stringToDate(String myDate) throws ParseException {
        // if(myDate.matches("\\d-\\d-\\d")){
            //     throw new IllegalArgumentException();
            // }
        DateFormat format = new SimpleDateFormat("DD-MM-YYYY", Locale.ENGLISH);
        Date date = format.parse(myDate);
        return date;
    }


}
