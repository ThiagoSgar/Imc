package br.com.imc.domain.model;

public enum ImcSituationEnum {

    MUITO_ABAIXO_DO_PESO(0,17),
    ABAIXO_DO_PESO(17,18.49),
    PESO_NORMAL(18.5,24.9),
    ACIMA_DO_PESO(25,29.9),
    OBESIDADE_I(30,34.9),
    OBESIDADE_II(35,39.9),
    OBESIDADE_III(40,100);

    private double value;
    private final double low;
    private final double high;


    private ImcSituationEnum(double value){
        this.low = value;
        this.high = value;
    }
    private ImcSituationEnum(double low, double high) {
        this.low = low;
        this.high = high;
    }

    public double getValue(){
        return value;
    }

    public static ImcSituationEnum getEnumByValue(double value){
        var teste = ImcSituationEnum.values();
        var t = teste[0];
        for(ImcSituationEnum imc : teste){
            if(value >= imc.low && value <= imc.high){
                return imc;
            }
        }
        return null;
    }
}
