package devandroid.brandao.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.brandao.appgaseta.model.Pessoa;
import devandroid.brandao.appgaseta.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listavip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listavip = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Salvo: "+pessoa.toString());

        listavip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listavip.putString("sobreNome", pessoa.getSobreNome());
        listavip.putString("nomeCurso", pessoa.getCursoDesejado());
        listavip.putString("telefoneContato", pessoa.getTelefoneContato());
        listavip.apply();

    }

    public Pessoa buscar(Pessoa pessoa){

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome","NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome","NA"));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso","NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato","NA"));

        return pessoa;
    }
    public void limpar(){

        listavip.clear();
        listavip.apply();

    }

}
