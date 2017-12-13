package cn.edu.gdmec.android.androidspinner;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        spinner = (Spinner)findViewById(R.id.spinner);
       /* adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,getDataResource());
       // adapter = ArrayAdapter.createFromResource(this,);
        spinner.setAdapter(adapter);*/
       //加载xml的方式
        adapter = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }
    public List<String> getDataResource(){
        List<String> list = new ArrayList<String>();
        list.add("上海");
        list.add("广州");
        list.add("北京");
        list.add("南京");
        list.add("成都");
        list.add("长沙");
        return list;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = spinner.getItemAtPosition(position).toString();
        Toast.makeText(this,"您选择的是"+item,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
