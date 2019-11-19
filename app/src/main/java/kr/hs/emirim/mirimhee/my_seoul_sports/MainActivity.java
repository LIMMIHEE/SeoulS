package kr.hs.emirim.mirimhee.my_seoul_sports;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private EditText Seachtext;
    private ImageButton SearchimgButton;

    private RecyclerView REcycleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Seachtext =(EditText) findViewById(R.id.seach_text);
        SearchimgButton = (ImageButton) findViewById(R.id.SearchButton);

        REcycleView = (RecyclerView) findViewById(R.id.recyclerView);

    }
}
