package com.app.keval_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView tvAtmAmount, tv100, tv200, tv500, tv2000, tvMinNote;
    Button btnWithdraw;
    EditText edtWithdrawAmount;
    int[] noteCounter;
    int[] notes;
    RecyclerView rvView;
    listAdapter listAdapter;
    ArrayList<String> mList = new ArrayList<>();
    int note100 = 20, note200 = 20, note500 = 20, note2000 = 20, totaAtmMoney = 50000, amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAtmAmount = findViewById(R.id.tvAtmAmount);
        tv100 = findViewById(R.id.tv100);
        tv200 = findViewById(R.id.tv200);
        tv500 = findViewById(R.id.tv500);
        tv2000 = findViewById(R.id.tv2000);
        btnWithdraw = findViewById(R.id.btnWithdraw);
        edtWithdrawAmount = findViewById(R.id.edtWithdrawAmount);
        tvMinNote = findViewById(R.id.tvMinNote);
        rvView = findViewById(R.id.rvView);

        tv100.setText(String.valueOf(note100));
        tv200.setText(String.valueOf(note200));
        tv500.setText(String.valueOf(note500));
        tv2000.setText(String.valueOf(note2000));
        tvAtmAmount.setText(String.valueOf(totaAtmMoney));

        listAdapter = new listAdapter(mList);
        rvView.setHasFixedSize(true);
        rvView.setLayoutManager(new LinearLayoutManager(this));
        rvView.setAdapter(listAdapter);
        getData();

    }

    private void getData() {

        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Integer.parseInt(edtWithdrawAmount.getText().toString());
                if (edtWithdrawAmount.getText().toString().isEmpty() || totaAtmMoney < 0 || amount > totaAtmMoney) {
                    Toast.makeText(MainActivity.this, "Some things want wrong", Toast.LENGTH_SHORT).show();

                } else {
                  //  totaAtmMoney = totaAtmMoney - amount;
                    notes = new int[]{2000, 500, 200, 100};
                    noteCounter = new int[4];
                    for (int i = 0; i < 4; i++) {
                        if (amount >= notes[i]) {
                            noteCounter[i] = amount / notes[i];
                            amount = amount % notes[i];
                        }
                    }

                    note2000 = note2000 - noteCounter[0];
                    note500 = note500 - noteCounter[1];
                    note200 = note200 - noteCounter[2];
                    note100 = note100 - noteCounter[3];

                    tvAtmAmount.setText(String.valueOf(totaAtmMoney));
                    tv100.setText(String.valueOf(note100));
                    tv200.setText(String.valueOf(note200));
                    tv500.setText(String.valueOf(note500));
                    tv2000.setText(String.valueOf(note2000));

                    tvMinNote.setText(notes[0] + " :" + noteCounter[0] + "\n" + notes[1] + " :" + noteCounter[1] + "\n" + notes[2] + " :" + noteCounter[2] + "\n" + notes[3] + " :" + noteCounter[3]);
                    String list = notes[0] + " :" + noteCounter[0] + "\n" + notes[1] + " :" + noteCounter[1] + "\n" + notes[2] + " :" + noteCounter[2] + "\n" + notes[3] + " :" + noteCounter[3];

                    mList.add(list);
                    listAdapter.notifyDataSetChanged();

                }
            }
        });
    }


}