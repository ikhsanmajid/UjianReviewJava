package com.juaracoding;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void soalPertama(){
        System.out.println("Soal Pertama: ");
        for(int i = 1; i <= 100; i++){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.print("BIZZBUZZ");
            }else if (i % 3 == 0){
                System.out.print(" BIZZ ");
            }else if (i % 5 == 0){
                System.out.print(" BUZZ ");
            }else {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println();
    }

    static void soalKedua(float n){
        System.out.println("Soal Kedua: ");
        int mid = (int) Math.round(n/2.0);

        for(int i = 1; i <= mid; i++){
            for(int j = i; j <= (int) n; j++){
                if ( j % 2 == 0 ){
                    System.out.print("_");
                }else{
                    System.out.print(j);
                }
            }
            n = n - 1;
            System.out.println();
        }

        System.out.println();

    }

    static void soalKetiga(String tag1, String tag2, int charEndTag, int charCountPerTrailer, int[] expectedOrder){
        List<String> trailer = new ArrayList<>();
        trailer.add(0, tag2.substring(0, charEndTag));
        int charPerTrailer = charCountPerTrailer;

        String tag2excluded = tag2.substring(charEndTag);
        int expectedTrailerLength = (int) (Math.ceil((double) (tag2excluded.length() + 1) / (double) charPerTrailer));

        for (int i = 0; i < expectedTrailerLength; i++){
            int arrayIndex = i + 1;
            if (i == (expectedTrailerLength - 1)){
                trailer.add(arrayIndex, tag2excluded.substring((i*charPerTrailer)));
            }else if (i == 0){
                trailer.add(arrayIndex, tag2excluded.substring(i, (charPerTrailer)));
            }else {
                trailer.add(arrayIndex, tag2excluded.substring((i*charPerTrailer), ((i+1) * charPerTrailer)));
            }

        }

        String result = "";
        result += trailer.get(0);
        for (int i : expectedOrder){
            result += trailer.get(i);
        }

        System.out.println(tag1);
        System.out.println(result);
        System.out.println();
    }


    public static void main(String[] args) {

        soalPertama();
        soalKedua(9);
        System.out.println("Soal Ketiga: ");
        int[] order = {3, 4, 5, 1, 2};
        soalKetiga(":T1:212112SOAL3", ":T2:SOAL3/2112/AB000000011 OD:0001234500CDE5432100 SOAL003 ABCDE12345 XAS SKILL TEST ESSAY .DT", 4, 18, order);
        soalKetiga(":T1:202111SOAL3", ":T2:SOAL3/2111/BC000011100 OD:0003452100EFG2451300 SOAL003 EFGHI25134 XAS SKILL TEST ESSAT .DT", 4, 18, order);
        soalKetiga(":T1:202110SOAL3", ":T2:SOAL3/2110/DE210031010 OD:0001524300HIJ2145300 SOAL003 JKLMN52431 XAS SKILL TEST ESSAY .DT", 4, 18, order);
    }
}