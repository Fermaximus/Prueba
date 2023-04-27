public class Paquete {
    private double peso;
    private double valor;
    private int num;

    public Paquete(double peso,double valor,int num){
        if (peso > 0) this.peso=peso;
        if (valor >0) this.valor=valor;
        if (num > 0) this.num=num;
    }

    public double getPeso() {
        return peso;
    }

    public double getValor() {
        return valor;
    }

    public double valorRelativo(){
        return valor/peso;
    }

    @Override
    public String toString() {
        return "Numero: "+num+", Peso: "+peso+", Valor: "+valor;
    }
}
