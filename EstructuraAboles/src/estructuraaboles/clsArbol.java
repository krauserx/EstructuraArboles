/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuraaboles;

import javax.swing.JOptionPane;

/**
 *
 * @author kraus
 */
public class clsArbol {
    
        static int cont;
    static double promedio;
    static double contadorPromedio;
    static double Total;

    public void menu() {
        int x;
        x = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                               Digite Opcion deseada:
                                                                1-Ingresar Datos
                                                                2-Impresion PreOrden
                                                                3-impresion in Orden
                                                                4-Impresion PostOrden
                                                                5-Retornar Arbol Derecho
                                                                6-Convertir Arbol en cola y mostrarla inversa
                                                                7-Promedio General del Arbol
                                                                8-Modificar Raiz"""));

        if (x == 1) {
            insertar();
            menu();
        }
        if (x == 2) {
            imprimirPre();
            menu();
        }
        if (x == 3) {
            imprimirEntre();
            menu();

        }
        if (x == 4) {
            imprimirPost();
            menu();
        }
        if (x == 5) {
            RetornoSubArbolDerecho();
            menu();
        }
        if (x == 6) {
            MostrarNumeroInvertidosEnCola();
            menu();
        }
        if (x == 7) {

            promedio();
            menu();
        }
        if (x == 8) {
            ModificarRaiz();
            menu();
        }
        if (x == 9) {

        }

    }

    class Cola {

        int info;
        Cola sig;
    }

    private Cola raizCola, fondoCola;

    class repetidos {

        int info;
        repetidos sig;
    }
    private repetidos raizRep;

    boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void valoresRep(int valor) {

        repetidos reco;
        reco = raizRep;

        while (reco != null) {
            if (valor == reco.info) {
                JOptionPane.showMessageDialog(null, "Numero: [" + reco.info + "] Repetido Digite otro");
                insertar();
            }
            reco = reco.sig;

        }

        repetidos nuevo;
        nuevo = new repetidos();
        nuevo.info = valor;
        if (raiz == null) {
            nuevo.sig = null;
            raizRep = nuevo;
        } else {
            nuevo.sig = raizRep;
        }
        raizRep = nuevo;

    }

    class arbol {

        int infor;
        arbol izq, der;

    }
    private arbol raiz;

    public clsArbol() {
        raiz = null;
    }

    public void insertar() {
        int insertar;
        insertar = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor a Insertar"));

      
        valoresRep(insertar);
        
        InsertarNumerosACola(insertar);

        arbol nuevo;
        nuevo = new arbol();
        nuevo.infor = insertar;
        nuevo.izq = null;
        nuevo.der = null;
        if (raiz == null) {
            raiz = nuevo;

        } else {
            arbol anterior = null, reco;
            reco = raiz;
            while (reco != null) {
                anterior = reco;

                if (insertar < reco.infor) {
                    reco = reco.izq;
                } else {
                    reco = reco.der;
                }
            }
            if (insertar < anterior.infor) {
                anterior.izq = nuevo;
            } else {
                anterior.der = nuevo;
            }

        }
        promedio = promedio + insertar;
        contadorPromedio++;
        cont++;

    }

    private void imprimirPre(arbol reco) {
        if (reco != null) {
            System.out.println(reco.infor + "");
            imprimirPre(reco.izq);
            imprimirPre(reco.der);
        }
    }

    public void imprimirPre() {
        imprimirPre(raiz);
        System.out.println();
    }

    private void imprimirEntre(arbol reco) {
        if (reco != null) {
            imprimirEntre(reco.izq);
            System.out.println(reco.infor + "");
            imprimirEntre(reco.der);
        }
    }

    public void imprimirEntre() {
        imprimirEntre(raiz);
        System.out.println();
    }

    private void imprimirPost(arbol reco) {
        if (reco != null) {
            imprimirPost(reco.izq);
            imprimirPost(reco.der);
            System.out.println(reco.infor + "");

        }
    }

    public void imprimirPost() {
        imprimirPost(raiz);
        System.out.println();
    }

    public void RetornoSubArbolDerecho(arbol reco) {
        if (reco != null) {
            imprimirPost(reco.der);
            System.out.println(reco.infor + "");
        }
    }

    public void RetornoSubArbolDerecho() {
        RetornoSubArbolDerecho(raiz);
        System.out.println();
    }

    public void InsertarNumerosACola(int NumeroCola) {

        Cola nuevo;
        nuevo = new Cola();
        nuevo.info = NumeroCola;
        nuevo.sig = null;
        if (vacia()) {
            raizCola = nuevo;
            fondoCola = nuevo;
        } else {
            fondoCola.sig = nuevo;
            fondoCola = nuevo;
        }

    }

    public void MostrarNumeroInvertidosEnCola() {

        int array[];
        array = new int[cont];
        int n = 0;

        Cola reco = raizCola;
        while (reco != null) {

            array[n] = reco.info;

            reco = reco.sig;
            n++;

        }
        Cola reco2 = raizCola;
        int temp = 0;
        for (temp = array.length - 1; temp >= 0; temp--) {

            reco2.info = array[temp];
            reco2 = reco2.sig;
        }

        while (reco2 != null) {
            System.out.print(reco2.info + "-");
            reco = reco.sig;
        }

        Cola recoCola = raizCola;

        System.out.println("Cola Invertida");
        while (recoCola != null) {
            System.out.print(recoCola.info + "-");
            recoCola = recoCola.sig;
        }
        System.out.println();

    }

    public void promedio() {
        Total = promedio / cont;
        System.out.println("El promedio del arbol es: " + Total);
    }

    public void ModificarRaiz() {
        int NuevaRaiz;
        NuevaRaiz = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Nueva Raiz"));

        raiz.infor = NuevaRaiz;
    }

    
    
    
}
