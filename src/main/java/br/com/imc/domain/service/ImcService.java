package br.com.imc.domain.service;

import br.com.imc.domain.model.Imc;
import br.com.imc.domain.model.ImcSituationEnum;
import org.springframework.stereotype.Service;

@Service
public class ImcService {


    public String situation(Imc imc) {
        double imcResult = calculate(imc);
        ImcSituationEnum enumSituation = ImcSituationEnum.getEnumByValue(imcResult);
        String mesage = "";
        switch (enumSituation){

            case MUITO_ABAIXO_DO_PESO:
                mesage = ("Magreza Grave: \n Insuficiência Cardíaca \n Anemia Grave \n Engraquecimento do Sist.Imune");
                break;
            case ABAIXO_DO_PESO:
                mesage = ("Magreza Leve: \n Problemas de Saúde Ligados a Desnutrição");
                break;
            case PESO_NORMAL:
                mesage = ("Eutrófico: \n Saudável");
                break;
            case ACIMA_DO_PESO:
                mesage = ("Sobrepeso: \n Fadiga \n Varizes \n Má Circulação");
                break;
            case OBESIDADE_I:
                mesage = ("Obesidade I: \n Diabétes \n Infarto \n Angina \n Aterosclerose");
                break;
            case OBESIDADE_II:
                mesage = ("Obesidade II: \n Falta de Ar \n Apneia do Sono");
                break;
            case OBESIDADE_III:
                mesage = ("Obesidade III: \n Refluxo \n Infarto \n AVC \n Dificuldade para Locomoção");
        };

        return String.format("Imc Result: %.2f - %s \n %s" ,imcResult, enumSituation.name(),mesage);
    }


    public String diagnosis(Imc imc) {
        double imcActual = calculate(imc);
        double weightDiference = 0;
        String situation = situation(imc);
        if(imcActual > 25){
            weightDiference = (imcActual - 25.1) * Math.pow(imc.getHeight(), 2) ;
            return String.format("%s \n São necessários a perda de %.2f Kg para o imc ideal!",situation, weightDiference);
        }else {
            weightDiference = (25 - imcActual) * Math.pow(imc.getHeight(), 2);
            return String.format("%s \n São necessários o ganho de %.2f Kg para o imc ideal!",situation, weightDiference);
        }
    }

    public Double calculate(Imc imc) {
        Double imcResult = imc.getWeight()/(Math.pow(imc.getHeight(),2));
        return imcResult;
    }


}
