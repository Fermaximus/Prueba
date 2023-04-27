import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Paquete[] v=new Paquete[7];
        Paquete p;
        ArrayList <Paquete> array=new ArrayList<>();
        int i=0,peso=0,npaquetes=0;
        float suma=0;
        boolean factible=true,solParcial[] = new boolean[v.length];
        int[][] matriz=new int[npaquetes][peso];


        Comparator<Paquete> comValor=new Comparator<Paquete>(){
            public int compare(Paquete p1,Paquete p2){
                if (p1.getValor() > p2.getValor()) return 1;
                else if (p1.getValor() < p2.getValor()) return -1;
                else return 0;
            }
        };

        Comparator<Paquete> comPeso=new Comparator<Paquete>(){
            public int compare(Paquete p1,Paquete p2){
                if (p1.getValor() > p2.getValor()) return 1;
                else if (p1.getValor() < p2.getValor()) return -1;
                else return 0;
            }
        };

        Comparator<Paquete> comValorR=new Comparator<Paquete>(){
            public int compare(Paquete p1,Paquete p2){
                if (p1.valorRelativo() < p2.valorRelativo()) return 1;
                else if (p1.valorRelativo() > p2.valorRelativo()) return -1;
                else return 0;
            }
        };

        for ( i = 0; i < v.length; i++) {
            System.out.println("Peso y valor");
            v[i]=new Paquete(s.nextDouble(),s.nextDouble(),i+1);
        }

        System.out.println(Arrays.toString(v));

        Arrays.sort(v,comPeso);
        while (i<v.length && !solucion(suma,1000) && factible){
            p=solucion(v,i);
            if (factibilidad(suma,p,1000)){
                solParcial[i]=true;
                suma += p.getPeso();
                i++;
            }else factible=false;
        }
        mostrarSolucionA(v,solParcial);
        Arrays.sort(v,comPeso.reversed());
        for (i=0;i<v.length && !solucion(suma,1000);i++){
            p=solucion(v,i);
            if (factibilidad(suma,p,1000)){
                solParcial[i]=true;
                suma += p.getPeso();
            }
        }
        mostrarSolucionB(v,solParcial);
        mostrarSolucionC(v,solParcial);
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

    public static void mostrarSolucionA(Paquete[] v,boolean[] solParcial){
        int c=0;
        for (int i = 0; i < v.length; i++) {
            if (solParcial[i]){
                System.out.println(v[i]);
                c++;
            }
        }
        System.out.println("Numero total de paquetes transportados: "+c);
    }

    public static void mostrarSolucionB(Paquete[] v,boolean[] solParcial){
        float valor=0;
        for (int i = 0; i < v.length; i++) {
            if (solParcial[i]){
                System.out.println(v[i]);
                valor+=v[i].getValor();
            }
        }
        System.out.println("Valor total paquetes: "+valor);
    }

    public static void mostrarSolucionC(Paquete[] v,boolean[] solParcial){
        float peso=0;
        for (int i = 0; i < v.length; i++) {
            if (solParcial[i]){
                System.out.println(v[i]);
                peso+=v[i].getPeso();
            }
        }
        System.out.println("Peso total paquetes: "+peso);
    }

    public void matriz(int peso,int npaquetes){
        for (int i = 0; i < npaquetes; i++) {
            for (int j = 0; j < peso; j++) {
//                if(i*j==0)
            }
        }
    }
}
