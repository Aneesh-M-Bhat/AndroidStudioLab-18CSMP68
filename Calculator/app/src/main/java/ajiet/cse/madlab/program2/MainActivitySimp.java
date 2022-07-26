package ajiet.cse.madlab.program2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivitySimp extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_simp);
        tv= (TextView) findViewById(R.id.txtRes);
        Toast.makeText(this, "Enter the Expression to be evaluated", Toast.LENGTH_SHORT).show();
    }
    public void clear(View V){
        tv.setText("");
    }
    public void changeEditText(View V){
        Button btn = (Button)findViewById(V.getId());
        tv.setText(tv.getText()+btn.getText().toString());
    }
    public void calc(View V){
        String str = tv.getText().toString();
        Pattern p = Pattern.compile("[-+*/]");
        Matcher m = p.matcher(str);
        m.find();
        int op = str.indexOf(m.group(0));
        int num1 = Integer.parseInt(str.substring(0,op));
        int num2 = Integer.parseInt(str.substring(op+1));
        int res = 0;
        switch(str.charAt(op)){
            case '+':res=num1+num2;break;
            case '-':res=num1-num2;break;
            case '*':res=num1*num2;break;
            case '/':if(num2!=0)res=num1/num2;break;
        }
        tv.setText(res+"");
    }
}