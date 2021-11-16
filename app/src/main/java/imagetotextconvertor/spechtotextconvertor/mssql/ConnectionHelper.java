package imagetotextconvertor.spechtotextconvertor.mssql;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionHelper {
    Connection con;
    String userName,pass,ip,port,database;

    @SuppressLint("NewApi")
    public  Connection connection(){
        ip="192.168.1.82";
        database="rupesh_DB";
        userName="sa";
        pass="8833";
        port="1433";


        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        Connection connection=null;
        String connectionUrl=null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionUrl= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "databasename="+ database+";user="+userName+";password="+pass+";";
            connection= DriverManager.getConnection(connectionUrl);


        }catch (Exception e){
            Log.e("tag", String.valueOf(e));
        }

        return connection;
    }

}
