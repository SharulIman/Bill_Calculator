package sg.edu.rp.c346.id22018526.billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText amt;
    EditText pack;
    ToggleButton SVS;
    ToggleButton GST;
    EditText dis;
    RadioGroup radPay;
    Button splitBtn;
    Button resetBtn;
    TextView billDisplay;
    TextView eachPayDisplay;
    Button calc;
    double sum = 0;
    double packnum = 0;

    int gstcheck = 0;
    int svscheck = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        amt = findViewById(R.id.amtInput);
        pack = findViewById(R.id.numPacksInput);
        SVS = findViewById(R.id.togSVS);
        GST = findViewById(R.id.togGST);
        radPay = findViewById(R.id.radioPayment);
        dis = findViewById(R.id.disInput);
        splitBtn = findViewById(R.id.btnSplit);
        resetBtn = findViewById(R.id.btnReset);
        billDisplay = findViewById(R.id.billText);
        eachPayDisplay = findViewById(R.id.eachPayText);
        calc = findViewById(R.id.calcbtn);


        amt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amt.getText().toString();

            }
        });
        pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pack.getText().toString();

            }
        });
        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis.getText().toString();

            }
        });

        splitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                packnum = Double.parseDouble(pack.getText().toString());
                double splitsum = sum / packnum;
                int checkRadioId = radPay.getCheckedRadioButtonId();
                if (checkRadioId == R.id.radioCash) {
                    eachPayDisplay.setText("Each pays $" + splitsum + " in cash. ");
                } else if (checkRadioId == R.id.radioPayNow) {
                    eachPayDisplay.setText("Each pays $" + splitsum + " via Paynow to 9462 7236");
                }

            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = 0;
                packnum = 0;
                billDisplay.setText("");
                eachPayDisplay.setText("");

            }
        });
        SVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SVS.isChecked()) {
                    svscheck = 1;
                } else {
                    svscheck = 0;
                }
            }
        });
        GST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GST.isChecked()) {
                    gstcheck = 1;
                } else {
                    gstcheck = 0;
                }
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amtnum = Double.parseDouble(amt.getText().toString());
                double disnum = Double.parseDouble(dis.getText().toString());
                sum = amtnum * (100 - disnum) / 100;
                if (gstcheck == 1) {
                    sum = sum * 107 / 100;
                }
                if (svscheck == 1) {
                    sum = sum * 110 / 100;

                }

                billDisplay.setText("The amount that needs to be paid in total is $" + sum);

            }
        });


    }
}