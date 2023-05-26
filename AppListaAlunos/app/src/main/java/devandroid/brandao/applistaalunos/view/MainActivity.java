package devandroid.brandao.applistaalunos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.brandao.applistaalunos.R;
import devandroid.brandao.applistaalunos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outrapessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("Guilherme");
        pessoa.setSobreNome("Brandão");
        pessoa.setCursoDesejado("App Android");
        pessoa.setTelefoneContato("11999999999");

        outrapessoa = new Pessoa();

        outrapessoa.setPrimeiroNome("Solange");
        outrapessoa.setSobreNome("Valenzuela");
        outrapessoa.setCursoDesejado("Java");
        outrapessoa.setTelefoneContato("1188888888");

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();


        dadosOutraPessoa = "Primeiro Nome: ";
        dadosOutraPessoa += outrapessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outrapessoa.getSobreNome();
        dadosOutraPessoa += " Curso Desejado: ";
        dadosOutraPessoa += outrapessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de Contato: ";
        dadosOutraPessoa += outrapessoa.getTelefoneContato();

        int parada = 0;
    }


}