package com.example.macalculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> historique= new ArrayList<>();
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        historique = new ArrayList();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, historique);
        ListView hist = findViewById(R.id.hist_view);
        hist.setAdapter(adapter);

        //Lecture de l'historique
        FileInputStream fin = null;
        try {
            fin = openFileInput("listeCalcul.txt");
            InputStreamReader in = new InputStreamReader(fin);
            BufferedReader buffer = new BufferedReader(in);
            String ligne = "";

            while ( (ligne = buffer.readLine()) != null ) {
                historique.add(ligne);
            }
            adapter.notifyDataSetChanged();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Implémentation des boutons

        Button parentheseO = (Button) findViewById(R.id.open_p);
        parentheseO.setOnClickListener(this);

        Button parentheseF = (Button) findViewById(R.id.close_p);
        parentheseF.setOnClickListener(this);

        Button ACbtn = (Button) findViewById(R.id.all_clear_btn);
        ACbtn.setOnClickListener(this);

        Button DelBtn = (Button) findViewById(R.id.del_btn);
        DelBtn.setOnClickListener(this);

        Button Point = (Button) findViewById(R.id.comma_btn);
        Point.setOnClickListener(this);

        Button btn_0_Value = (Button) findViewById(R.id.zero_btn);
        btn_0_Value.setOnClickListener(this);

        Button btn_1_Value = (Button) findViewById(R.id.one_btn);
        btn_1_Value.setOnClickListener(this);

        Button btn_2_Value = (Button) findViewById(R.id.two_btn);
        btn_2_Value.setOnClickListener(this);

        Button btn_3_Value = (Button) findViewById(R.id.three_btn);
        btn_3_Value.setOnClickListener(this);

        Button btn_4_Value = (Button) findViewById(R.id.four_btn);
        btn_4_Value.setOnClickListener(this);

        Button btn_5_Value = (Button) findViewById(R.id.five_btn);
        btn_5_Value.setOnClickListener(this);

        Button btn_6_Value = (Button) findViewById(R.id.six_btn);
        btn_6_Value.setOnClickListener(this);

        Button btn_7_Value = (Button) findViewById(R.id.seven_btn);
        btn_7_Value.setOnClickListener(this);

        Button btn_8_Value = (Button) findViewById(R.id.eight_nbtn);
        btn_8_Value.setOnClickListener(this);

        Button btn_9_Value = (Button) findViewById(R.id.nine_btn);
        btn_9_Value.setOnClickListener(this);

        Button btn_plus_Value = (Button) findViewById(R.id.add_btn);
        btn_plus_Value.setOnClickListener(this);

        Button btn_moins_Value = (Button) findViewById(R.id.minus_btn);
        btn_moins_Value.setOnClickListener(this);

        Button btn_multi_Value = (Button) findViewById(R.id.multi_btn);
        btn_multi_Value.setOnClickListener(this);

        Button btn_div_Value = (Button) findViewById(R.id.div_btn);
        btn_div_Value.setOnClickListener(this);

        Button btn_equal_Value = (Button) findViewById(R.id.equal_btn);
        btn_equal_Value.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int len = 0;
        String lastChar = "";
        TextView DisplayTextView = findViewById(R.id.operation_view);
        TextView Resultat = findViewById(R.id.res_view);
        String Line = DisplayTextView.getText().toString();
        String operation = "";
        String res = "";


        switch (view.getId()) {

            case R.id.comma_btn:
                len = DisplayTextView.getText().length();
                if (len != 0) {
                    lastChar = Line.substring(len - 1, len);
                }
                if (Line.isEmpty()) {
                    Toast.makeText(this, "Choix invalide", Toast.LENGTH_SHORT).show();
                } else if (lastChar.equalsIgnoreCase(".")) {
                    Toast.makeText(this, "Il y a déjà une virgule", Toast.LENGTH_SHORT).show();
                } else {
                    DisplayTextView.append(".");
                }
                break;

            case R.id.all_clear_btn:

                if (Line.isEmpty()) {
                    Toast.makeText(this, "Champs de saisie vide ", Toast.LENGTH_SHORT).show();
                } else {
                    DisplayTextView.setText("");
                    Resultat.setText("");
                }
                break;

            case R.id.del_btn:
                if (Line.isEmpty()) {
                    Toast.makeText(this, "Champs de saisie vide ", Toast.LENGTH_SHORT).show();
                } else {
                    Line = Line.substring(0, Line.length() - 1);
                    DisplayTextView.setText(Line);
                    operation = DisplayTextView.getText().toString();
                    Expression expression0 = new Expression(operation);
                    res = String.valueOf(expression0.calculate());
                    Resultat.setText(res);
                }
                break;

            case R.id.zero_btn:
                DisplayTextView.append("0");
                operation = DisplayTextView.getText().toString();
                Expression expression0 = new Expression(operation);
                res = String.valueOf(expression0.calculate());
                Resultat.setText(res);
                break;

            case R.id.one_btn:
                DisplayTextView.append("1");
                operation = DisplayTextView.getText().toString();
                Expression expression1 = new Expression(operation);
                res = String.valueOf(expression1.calculate());
                Resultat.setText(res);
                break;

            case R.id.two_btn:
                DisplayTextView.append("2");
                operation = DisplayTextView.getText().toString();
                Expression expression2 = new Expression(operation);
                res = String.valueOf(expression2.calculate());
                Resultat.setText(res);
                break;

            case R.id.three_btn:
                DisplayTextView.append("3");
                operation = DisplayTextView.getText().toString();
                Expression expression3 = new Expression(operation);
                res = String.valueOf(expression3.calculate());
                Resultat.setText(res);
                break;

            case R.id.four_btn:
                DisplayTextView.append("4");
                operation = DisplayTextView.getText().toString();
                Expression expression4 = new Expression(operation);
                res = String.valueOf(expression4.calculate());
                Resultat.setText(res);
                break;

            case R.id.five_btn:
                DisplayTextView.append("5");
                operation = DisplayTextView.getText().toString();
                Expression expression5 = new Expression(operation);
                res = String.valueOf(expression5.calculate());
                Resultat.setText(res);
                break;

            case R.id.six_btn:
                DisplayTextView.append("6");
                operation = DisplayTextView.getText().toString();
                Expression expression6 = new Expression(operation);
                res = String.valueOf(expression6.calculate());
                Resultat.setText(res);
                break;

            case R.id.seven_btn:
                DisplayTextView.append("7");
                operation = DisplayTextView.getText().toString();
                Expression expression7 = new Expression(operation);
                res = String.valueOf(expression7.calculate());
                Resultat.setText(res);
                break;

            case R.id.eight_nbtn:
                DisplayTextView.append("8");
                operation = DisplayTextView.getText().toString();
                Expression expression8 = new Expression(operation);
                res = String.valueOf(expression8.calculate());
                Resultat.setText(res);
                break;

            case R.id.nine_btn:
                DisplayTextView.append("9");
                operation = DisplayTextView.getText().toString();
                Expression expression9 = new Expression(operation);
                res = String.valueOf(expression9.calculate());
                Resultat.setText(res);
                break;

            case R.id.add_btn:
                len = DisplayTextView.getText().length();
                if (len != 0) {
                    lastChar = Line.substring(len - 1, len);
                    if (len == 1 && lastChar.equalsIgnoreCase("-")) {
                        Toast.makeText(this, "Choix invalide ", Toast.LENGTH_SHORT).show();
                    } else if (lastChar.equalsIgnoreCase("/") || lastChar.equalsIgnoreCase("-") || lastChar.equalsIgnoreCase("*") || lastChar.equalsIgnoreCase("+")) {
                        String NewLine = Line.substring(0, len - 1);
                        DisplayTextView.setText(NewLine);
                        DisplayTextView.append("+");
                    } else {
                        DisplayTextView.append("+");
                    }
                } else {
                    Toast.makeText(this, "Choix invalide ", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.minus_btn:
                len = DisplayTextView.getText().length();
                if (len != 0) {
                    lastChar = Line.substring(len - 1, len);
                    if (lastChar.equalsIgnoreCase("/") || lastChar.equalsIgnoreCase("-") || lastChar.equalsIgnoreCase("*") || lastChar.equalsIgnoreCase("+")) {
                        String NewLine = Line.substring(0, len - 1);
                        DisplayTextView.setText(NewLine);
                        DisplayTextView.append("-");
                    } else {
                        DisplayTextView.append("-");
                    }
                } else {
                    DisplayTextView.append("-");
                }

                break;

            case R.id.multi_btn:
                len = DisplayTextView.getText().length();
                if (len != 0) {
                    lastChar = Line.substring(len - 1, len);
                    if (len == 1 && lastChar.equalsIgnoreCase("-")) {
                        Toast.makeText(this, "Choix invalide ", Toast.LENGTH_SHORT).show();
                    } else if (lastChar.equalsIgnoreCase("/") || lastChar.equalsIgnoreCase("-") || lastChar.equalsIgnoreCase("*") || lastChar.equalsIgnoreCase("+")) {
                        String NewLine = Line.substring(0, len - 1);
                        DisplayTextView.setText(NewLine);
                        DisplayTextView.append("*");
                    } else {
                        DisplayTextView.append("*");
                    }
                } else {
                    Toast.makeText(this, "Choix invalide ", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.div_btn:
                len = DisplayTextView.getText().length();
                if (len != 0) {
                    lastChar = Line.substring(len - 1, len);
                    if (len == 1 && lastChar.equalsIgnoreCase("-")) {
                        Toast.makeText(this, "Choix invalide ", Toast.LENGTH_SHORT).show();
                    } else if (lastChar.equalsIgnoreCase("/") || lastChar.equalsIgnoreCase("-") || lastChar.equalsIgnoreCase("*") || lastChar.equalsIgnoreCase("+")) {
                        String NewLine = Line.substring(0, len - 1);
                        DisplayTextView.setText(NewLine);
                        DisplayTextView.append("/");
                    } else {
                        DisplayTextView.append("/");
                    }
                } else {
                    Toast.makeText(this, "Choix invalide ", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.equal_btn:
                operation = DisplayTextView.getText().toString();
                Expression expression = new Expression(operation);
                res = String.valueOf(expression.calculate());
                historique.add(operation +" = "+ res);
                adapter.notifyDataSetChanged();
                try {
                    //Ecriture
                    FileOutputStream fout = openFileOutput("listeCalcul.txt", this.MODE_PRIVATE);
                    OutputStreamWriter out = new OutputStreamWriter(fout);
                    for (String c : historique) {
                        out.write(c+'\n');
                    }
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Resultat.setText("");
                DisplayTextView.setText(res);
                break;
            case R.id.open_p:
                DisplayTextView.append("(");
                break;

            case R.id.close_p:
                DisplayTextView.append(")");
                break;


        }

    }
}