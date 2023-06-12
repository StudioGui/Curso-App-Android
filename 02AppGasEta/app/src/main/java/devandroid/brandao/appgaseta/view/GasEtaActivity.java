package devandroid.brandao.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.brandao.appgaseta.R;
import devandroid.brandao.appgaseta.apoio.UtilGasEta;
import devandroid.brandao.appgaseta.controller.CombustivelController;
import devandroid.brandao.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String resolucao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("*Campo Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOk = false;

                }

                if (TextUtils.isEmpty(editEtanol.getText())){
                    editEtanol.setError("*Campo Obrigatório");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }
            if(isDadosOk) {

                precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                resolucao = UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol);
                txtResultado.setText(resolucao);

                btnSalvar.setEnabled(true);

            }
            else{
            Toast.makeText(GasEtaActivity.this, "Digite os campos obrigatórios",Toast.LENGTH_LONG).show();
                btnSalvar.setEnabled(false);
            }

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                controller = new CombustivelController(GasEtaActivity.this);

                combustivelEtanol = new Combustivel();
                combustivelGasolina = new Combustivel();

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelGasolina.setResolucao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol.setResolucao(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                controller.Salvar(combustivelGasolina);
                controller.Salvar(combustivelEtanol);



            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editEtanol.setText("");
                editGasolina.setText("");
                txtResultado.setText("RESULTADO");
                btnSalvar.setEnabled(false);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        Toast.makeText(GasEtaActivity.this, UtilGasEta.mensagem(), Toast.LENGTH_LONG).show();

    }
}
