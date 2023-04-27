import java.util.Arrays;
import java.util.Comparator;

public class CasoA {
    public static void voraz(Paquete[] v,int cap){
        int i;
        float suma;
        Paquete p;
        boolean factible, solParcial[] =new boolean[v.length];

        ordenacion(v);

        i=0;
        suma=0;
        factible=true;
        while (i<v.length && !solucion(suma,cap) && factible){
            p=solucion(v,i);
            if (factibilidad(suma,p,cap)){
                solParcial[i]=true;
                suma += p.getPeso();
                i++;
            }else factible=false;
        }

        mostrarSolucion(v,solParcial);
    }
    public static void ordenacion(Paquete[] v){
        Comparator<Paquete> comPeso=Comparator.comparing(Paquete::getPeso);
        Arrays.sort(v,comPeso);
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
        int c=0;
        for (int i = 0; i < v.length; i++) {
            if (solParcial[i]){
                System.out.println(v[i]);
                c++;
            }
        }
        System.out.println("Numero total de paquetes transportados: "+c);
    }
}
