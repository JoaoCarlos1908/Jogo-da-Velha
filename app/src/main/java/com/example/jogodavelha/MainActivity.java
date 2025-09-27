package com.example.jogodavelha;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button[] btn = new Button[10];
    private TextView text_jogador;
    private Boolean jogador = true;//true = X ; false = O

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            iniciarComponentes();

            for (int x = 1; x < 10; x++) {
                int finalX = x;
                btn[x].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (jogador) {
                            btn[finalX].setText("X");
                            jogador = false;
                            text_jogador.setText("O");
                        } else {
                            btn[finalX].setText("O");
                            jogador = true;
                            text_jogador.setText("X");
                        }
                        checkGanhador();
                        btn[finalX].setEnabled(false);
                    }

                });
            }

            btn[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int x = 1; x < 10; x++) {
                        btn[x].setText("");
                        btn[x].setEnabled(true);
                        btn[x].setBackgroundColor(Color.parseColor("#666666"));
                    }
                }
            });

            return insets;
        });
    }

    public void iniciarComponentes() {
        btn[0] = findViewById(R.id.bt_recomecar);
        btn[1] = findViewById(R.id.bt01);
        btn[2] = findViewById(R.id.bt02);
        btn[3] = findViewById(R.id.bt03);
        btn[4] = findViewById(R.id.bt04);
        btn[5] = findViewById(R.id.bt05);
        btn[6] = findViewById(R.id.bt06);
        btn[7] = findViewById(R.id.bt07);
        btn[8] = findViewById(R.id.bt08);
        btn[9] = findViewById(R.id.bt09);
        text_jogador = findViewById(R.id.text_jogador);
    }

    private Boolean checarLinha(Button b1, Button b2, Button b3) {

        String t1 = b1.getText().toString();
        String t2 = b2.getText().toString();
        String t3 = b3.getText().toString();

        return !t1.isEmpty() && t1.equals(t2) && t2.equals(t3);
    }

    private void checkGanhador() {
        if (checarLinha(btn[1], btn[2], btn[3])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false); // trava o botão (fica visualmente desativado)
            }
            btn[1].setBackgroundColor(Color.GREEN);
            btn[2].setBackgroundColor(Color.GREEN);
            btn[3].setBackgroundColor(Color.GREEN);
        }
        if (checarLinha(btn[4], btn[5], btn[6])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false);
            }
            btn[4].setBackgroundColor(Color.GREEN);
            btn[5].setBackgroundColor(Color.GREEN);
            btn[6].setBackgroundColor(Color.GREEN);
        }
        if (checarLinha(btn[7], btn[8], btn[9])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false);
            }
            btn[7].setBackgroundColor(Color.GREEN);
            btn[8].setBackgroundColor(Color.GREEN);
            btn[9].setBackgroundColor(Color.GREEN);
        }
        if (checarLinha(btn[1], btn[4], btn[7])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false);
            }
            btn[1].setBackgroundColor(Color.GREEN);
            btn[4].setBackgroundColor(Color.GREEN);
            btn[7].setBackgroundColor(Color.GREEN);
        }
        if (checarLinha(btn[2], btn[5], btn[8])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false);
            }
            btn[2].setBackgroundColor(Color.GREEN);
            btn[5].setBackgroundColor(Color.GREEN);
            btn[8].setBackgroundColor(Color.GREEN);
        }
        if (checarLinha(btn[3], btn[6], btn[9])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false);
            }
            btn[3].setBackgroundColor(Color.GREEN);
            btn[6].setBackgroundColor(Color.GREEN);
            btn[9].setBackgroundColor(Color.GREEN);
        }
        if (checarLinha(btn[1], btn[5], btn[9])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false);
            }
            btn[1].setBackgroundColor(Color.GREEN);
            btn[5].setBackgroundColor(Color.GREEN);
            btn[9].setBackgroundColor(Color.GREEN);
        }
        if (checarLinha(btn[3], btn[5], btn[7])) {
            for (int x = 1; x < 10; x++) {
                btn[x].setBackgroundColor(Color.RED);
                btn[x].setEnabled(false);
            }
            btn[3].setBackgroundColor(Color.GREEN);
            btn[5].setBackgroundColor(Color.GREEN);
            btn[7].setBackgroundColor(Color.GREEN);
        }

    }
}