package devandroid.brandao.appgaseta.controller;

import android.content.SharedPreferences;

import devandroid.brandao.appgaseta.model.Combustivel;
import devandroid.brandao.appgaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;


    //psfs
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity){
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();


    };

    public void Salvar(Combustivel combustivel){

        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", combustivel.getPrecoDoCombustivel().floatValue());
        dadosPreferences.putString("resolucao", combustivel.getResolucao());
        dadosPreferences.apply();
    }


}
