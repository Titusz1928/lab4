package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void main(String[] args) throws IOException {
        BufferedReader flux_in= new BufferedReader(new FileReader("electronice.txt"));
        String linie;
        int n=0;
        while((linie=flux_in.readLine())!=null){
            n++;
        }
        flux_in.close();
        List<Echipament> echipamentList = new ArrayList<Echipament>();

        String den;
        int nri;
        float pre;
        String zon;
        Status sta;
        Tip tip;
        int ppi,dpm,pca;
        ModTip mti;
        int pto;
        Format frm;
        String tmo;
        int vpr,chd;
        SistemOp sop;

        BufferedReader flux_in1= new BufferedReader(new FileReader("electronice.txt"));
        for(int i=0;i<n;i++){
            linie=flux_in1.readLine();
            StringTokenizer st= new StringTokenizer(linie);
                den=st.nextToken().toString();
                nri=Integer.parseInt(st.nextToken().toString());
                pre=Float.parseFloat(st.nextToken().toString());
                zon=st.nextToken().toString();
                sta=Status.valueOf(st.nextToken().toString());
                tip=Tip.valueOf(st.nextToken().toString());
                switch (tip){

                    case Imprimant -> {
                        ppi=Integer.parseInt(st.nextToken().toString());
                        dpm=Integer.parseInt(st.nextToken().toString());
                        pca=Integer.parseInt(st.nextToken().toString());
                        mti=ModTip.valueOf(st.nextToken().toString());
                        Imprimante imp=new Imprimante(den,nri,pre,zon,sta,tip,ppi,dpm,pca,mti);
                        echipamentList.add(imp);
                    }
                    case Copiator -> {
                        pto=Integer.parseInt(st.nextToken().toString());
                        frm=Format.valueOf(st.nextToken().toString());
                        Copiatoare cop=new Copiatoare(den,nri,pre,zon,sta,tip,pto,frm);
                        echipamentList.add(cop);
                    }
                    case SistemDeCalcul -> {
                        tmo=st.nextToken().toString();
                        vpr=Integer.parseInt(st.nextToken().toString());
                        chd=Integer.parseInt(st.nextToken().toString());
                        sop=SistemOp.valueOf(st.nextToken().toString());
                        SistemeDeCalcul sca=new SistemeDeCalcul(den,nri,pre,zon,sta,tip,tmo,vpr,chd,sop);
                        echipamentList.add(sca);
                    }
                }
        }
        flux_in1.close();
        int UI=0;
        Scanner scan=new Scanner(System.in);
        do{
            System.out.println("0=exit");
            System.out.println("1=afisare echipamente");
            System.out.println("2=afisare imprimante");
            System.out.println("3=afisare copiatoare");
            System.out.println("4=afisare sisteme de calcul");
            System.out.println("5=Modificarea stării în care se află un echipament ");
            System.out.println("6=Setarea unui anumit mod de scriere pentru o imprimantă");
            System.out.println("7=Setarea unui format de copiere pentru copiatoare");
            System.out.println("8=Instalarea unui anumit sistem de operare pe un sistem de calcul ");
            System.out.println("9=Afişarea echipamentelor vândute ");
            boolean b = false;
            while(b==false){
            String UIs = null;
            try {
                UIs=scan.next();
                UI = Integer.parseInt(UIs);
                b=true;
                // Use the integer value
            } catch (NumberFormatException e) {
                System.err.println("The string is not a valid integer: "+UIs);
                // Handle the exception or provide an alternative behavior
            }
            }
            switch (UI){
                case 0->{
                    System.out.println("closing program");
                    //break;
                }
                case 1->{
                    for(int i=0;i<n;i++){
                        System.out.println(echipamentList.get(i));
                    }
                   // break;
                }
                case 2->{
                    for(int i=0;i<n;i++){
                        if((echipamentList.get(i).getTip())==Tip.valueOf("Imprimant")){
                            System.out.println(echipamentList.get(i));
                        }
                    }
                }
                case 3->{
                    for(int i=0;i<n;i++){
                        if((echipamentList.get(i).getTip())==Tip.valueOf("Copiator")){
                            System.out.println(echipamentList.get(i));
                        }
                    }
                }
                case 4->{
                        for(int i=0;i<n;i++){
                            if((echipamentList.get(i).getTip())==Tip.valueOf("SistemDeCalcul")){
                                System.out.println(echipamentList.get(i));
                            }
                        }
                }
                case 5->{
                    System.out.println("Denumirea echipamentului?");
                    String UIs=scan.next();
                    for(int i=0;i<n;i++){
                        if(echipamentList.get(i).getDenumire().equals(UIs)){
                            System.out.println("status of product: "+echipamentList.get(i).getStatusEch());
                            System.out.println("what is the new status(achizitionat,expus,vandut)");
                            UIs=scan.next();
                            echipamentList.get(i).setStatusEch(Status.valueOf(UIs));
                        }
                    }
                }
                case 6->{
                    System.out.println("Denumirea echipamentului?");
                    String UIs=scan.next();
                    for(int i=0;i<n;i++){
                        if(echipamentList.get(i).getTip().equals(Tip.valueOf("Imprimant")))
                        if(echipamentList.get(i).getDenumire().equals(UIs)){
                            Imprimante aux=(Imprimante)echipamentList.get(i);
                            System.out.println("modul de tiparire: "+aux.getModTip());
                            System.out.println("modul de tiparire noua(color,negru)");
                            UIs=scan.next();
                            aux.setModTip(ModTip.valueOf(UIs));
                            echipamentList.set(i,aux);
                        }
                    }
                }
                case 7->{
                    System.out.println("Denumirea echipamentului?");
                    String UIs=scan.next();
                    for(int i=0;i<n;i++){
                        if(echipamentList.get(i).getTip().equals(Tip.valueOf("Copiator")))
                            if(echipamentList.get(i).getDenumire().equals(UIs)){
                                Copiatoare aux=(Copiatoare)echipamentList.get(i);
                                System.out.println("formatul curent: "+aux.getFormat());
                                System.out.println("formatul nou(A3,A4)");
                                UIs=scan.next();
                                aux.setFormat(Format.valueOf(UIs));
                                echipamentList.set(i,aux);
                            }
                    }
                }
                case 8->{
                    System.out.println("Denumirea echipamentului?");
                    String UIs=scan.next();
                    for(int i=0;i<n;i++){
                        if(echipamentList.get(i).getTip().equals(Tip.valueOf("SistemDeCalcul")))
                            if(echipamentList.get(i).getDenumire().equals(UIs)){
                                SistemeDeCalcul aux=(SistemeDeCalcul)echipamentList.get(i);
                                System.out.println("sistemul de operare curenta: "+aux.getSistemOp());
                                System.out.println("sistemul de operare nou(Windows,Linux)");
                                UIs=scan.next();
                                aux.setSistemOp(SistemOp.valueOf(UIs));
                                echipamentList.set(i,aux);
                            }
                    }
                }
                case 9->{
                    for(int i=0;i<n;i++){
                        if(echipamentList.get(i).getStatusEch()==Status.valueOf("vandut")){
                            System.out.println(echipamentList.get(i));
                        }
                    }
                }

                default -> {
                    System.out.println("error");
                }
            }
        }while(UI!=0);


    }
}
