package devandroid.brandao.appgaseta.apoio;

public class UtilGasEta {

    //public void metodoEstatico(){}

    //public static void metodoNaoEstatico(){}

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70; //Cálculo do Preço ideal
        String mensagemDeRetorno;

        //Teste lógico para saber qual combustível escolher.
        if(etanol<=precoIdeal){
            mensagemDeRetorno = "Abasteça com Etanol"; // Se preço do Etanol for menor ou igual ao preço ideal escolhe ETANOL
        }else{
            mensagemDeRetorno = "Abasteça com Gasolina"; // Se o preço do Etanol for maior que o preço ideal escolhe GASOLINA
        }

        return mensagemDeRetorno; // Chamada para retornar o resultado
    }

    public static String mensagem(){
        return "Seja Bem-Vindo...";
    }
}
