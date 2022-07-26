package ajiet.cse.madlab.program5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistryOwner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }
    public void callSave(View view){
        Button btn = (Button)findViewById(view.getId());
        String phone = editText.getText().toString();
        if(phone.isEmpty()){
            Toast.makeText(MainActivity.this, "Please Enter The Phone Number!", Toast.LENGTH_SHORT).show();
            Log.d("Activity","Error");
        }
        else {
            Intent intent;
            if(btn.getText().equals("CALL")){
                String s = "tel:" + phone;
                 intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(s));
            }else{
                 intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
            }
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            else {
                Toast.makeText(MainActivity.this, "There Is No App That Support's This Action!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void addText (View view){
        Button btn = (Button)findViewById(view.getId());
        editText.setText(editText.getText() + btn.getText().toString());
    }
    public void delete (View view) {editText.setText("");}
}