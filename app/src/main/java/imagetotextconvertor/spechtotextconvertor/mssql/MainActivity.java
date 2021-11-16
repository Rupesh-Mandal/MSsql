package imagetotextconvertor.spechtotextconvertor.mssql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {


    Button button;
    TextView textView,textView2;

    Connection connect;
    String connectionResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromSql();
            }
        });


    }

    public void getDataFromSql(){


        new LongOperation().execute();

    }
    private final class LongOperation extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            Log.e("tag"," String.valueOf(rs)");


            try {

                ConnectionHelper connectionHelper=new ConnectionHelper();
                connect=connectionHelper.connection();

                if (connect!=null){
                    String query="Select * from employee;";
                    Statement st=connect.createStatement();
                    ResultSet rs = st.executeQuery(query);

                    Log.e("tag", String.valueOf(rs));
//                    while (rs.next()){
//                        textView.setText(rs.getString(1));
//                        textView2.setText(rs.getString(2));
//                    }

                }else {
                    Log.e("tag","null");
                }


            }catch (Exception e){
                Log.e("tag", String.valueOf(e));
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }
}