package com.vikrant.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class viewStub extends AppCompatActivity {
ViewStub viewStub;
Button button,button2,button3;
EditText editText;
ListView listView;
    ArrayAdapter adapter;
    private String products[] = {"Apple", "Banana","Pinapple", "Orange", "Papaya", "Melon",
            "Grapes", "Water Melon","Lychee", "Guava", "Mango", "Kivi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
        viewStub=findViewById(R.id.stubview);
        button=findViewById(R.id.hide);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        button2=findViewById(R.id.show);
        button3=findViewById(R.id.nextactivity);
        listView=findViewById(R.id.listview);
        editText=findViewById(R.id.edittext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub.setVisibility(View.GONE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewStub.setVisibility(View.VISIBLE);
            }
        });

         adapter=new ArrayAdapter(this,R.layout.listitem,R.id.item,products);
        listView.setAdapter(adapter);
        textchange();
    }
    public void textchange()
    {
      editText.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              Toast.makeText(getApplicationContext(),"before text change",Toast.LENGTH_LONG).show();
          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              adapter.getFilter().filter(charSequence);

          }

          @Override
          public void afterTextChanged(Editable editable) {
              Toast.makeText(getApplicationContext(),"After text change",Toast.LENGTH_LONG).show();
          }
      });
    }
}
