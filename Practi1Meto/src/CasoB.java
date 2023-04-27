import java.util.Arrays;
import java.util.Comparator;

public class CasoB {
    public static void voraz(Paquete[] v,int cap){
        float suma;
        Paquete p;
        boolean solParcial[] =new boolean[v.length];

        ordenacion(v);

        suma=0;
        for (int i=0;i<v.length && !solucion(suma,cap);i++){
            p=solucion(v,i);
            if (factibilidad(suma,p,cap)){
                solParcial[i]=true;
                suma += p.getPeso();
            }
        }

        mostrarSolucion(v,solParcial);
    }

    public static void ordenacion(Paquete[] v){
        Comparator<Paquete> comPeso=Comparator.comparing(Paquete::valorRelativo);
        Arrays.sort(v,comPeso.reversed());
        System.out.println(Arrays.toString(v));
    }

    public static boolean solucion(float suma,int cap){
        return suma==cap;
    }

    public static Paquete solucion(Paquete[] v,int i){
        return v[i];
    }

    public static boolean factibilidad(float suma,Paquete p,int cap){
        return suma+p.getPeso()<=cap;
    }

    public static void mostrarSolucion(Paquete[] v,boolean[] solParcial){
        float valor=0;
        for (int i = 0; i < v.length; i++) {
            if (solParcial[i]){
                System.out.println(v[i]);
                valor+=v[i].getValor();
            }
        }
        System.out.println("Valor total paquetes: "+valor);
    }
}