import javax.xml.transform.Source;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaunchClassForName {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("Demo");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    }
}
class Demo{
    static{
        System.out.println("Static block");
    }
    {
        System.out.println("Instance loading: Non static");
    }
}