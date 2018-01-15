package yannick.veron.mytodolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by verony on 15/01/2018.
 */
public class TodoActivity extends Activity implements
        AdapterView.OnClickListener {
    private Button btnValider;
    private Button btnEmpty;

    private TextView viewText;
    private EditText editText;

    private ListView lvMyListView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        Singleton.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);
        btnValider = (Button) findViewById(R.id.submit);
        btnValider.setOnClickListener(this);

        btnEmpty = (Button) findViewById(R.id.emptyList);
        btnEmpty.setOnClickListener(this);

        viewText = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.textEdit);

        lvMyListView = (ListView)findViewById(R.id.listView);
        lvMyListView.setAdapter(new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, Singleton.getInstance().getData()));
        //lvMyListView.setOnItemClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            viewText.setText(editText.getText());
            Singleton.getInstance().setData(editText.getText().toString());
        } else if (v.getId() == R.id.emptyList) {
            viewText.setText("");
            Toast.makeText(getApplicationContext(), Singleton.getInstance().getData().toString(), Toast.LENGTH_SHORT).show();
        }else if(v.getId()==R.id.listView)
        {

        }
        else {
            Toast.makeText(getApplicationContext(), "Bouton cliqué", Toast.LENGTH_SHORT).show();
        }
    }
}
