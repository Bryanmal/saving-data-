package com.example.deloitte.savingdata;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {
    EditText inputId;
    TextView tvTitle, tvYear, tvCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        inputId=findViewById(R.id.inputId);
        tvTitle=findViewById(R.id.textTitle);
        tvYear=findViewById(R.id.textYear);
        tvCategory=findViewById(R.id.textCategory);
    }

    public void search(View view) {
        String id=inputId.getText().toString().trim();
        if (id.isEmpty())
        {
            return;
        }
        Database db=new Database(this);
        Cursor movie=db.getOneItem(id);
        if (movie.moveToFirst())
        {
          //display
          //id, title, year, category
            tvTitle.setText(movie.getString(1));
            tvYear.setText(movie.getString(2));
            tvCategory.setText(movie.getString(3));
        }else
            {
                tvTitle.setText("");
                tvYear.setText("");
                tvCategory.setText("");
                Toast.makeText(this, "No record found", Toast.LENGTH_SHORT).show();
            }

    }

    public void delete(View view) {
        String id=inputId.getText().toString().trim();
        if (id.isEmpty())
        {
            return;
        }
        Database db=new Database(this);
        db.deleteData(id);
    }
}
