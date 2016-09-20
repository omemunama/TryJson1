package nursulaeman.tryjson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_name = (TextView)findViewById(R.id.tv_name_nine);
        TextView tv_city = (TextView)findViewById(R.id.tv_city_nine);
        TextView tv_province = (TextView)findViewById(R.id.tv_province_nine);

        //create new JSON Object

        //this code for declare json object

        JSONObject student_json = new JSONObject();
        JSONObject address_json = new JSONObject();

        try {

            student_json.put("name", "Nur Sulaeman");
            address_json.put("city", "Bandung");
            address_json.put("province", "West Java");
            student_json.put("address", address_json);

            //this for handle set value to text view

            tv_name.setText(student_json.getString("name"));

            JSONObject jo_address = (JSONObject) student_json.get("address");
            tv_city.setText(jo_address.getString("city"));
            tv_province.setText(jo_address.getString("province"));

        } catch (JSONException e) {
            Log.i("info", String.valueOf(e));
        }

    }

}
