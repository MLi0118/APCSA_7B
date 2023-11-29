import java.util.ArrayList;
import java.util.Scanner;
public class APCSA_7B {

    public static void main(String[] args) {
        System.out.println(SieveOfEratosthenes(12));
        GoldbachConjecture(80);
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(9);
        a.add(0);
        a.add(0);
        b.add(1);
        b.add(2);
        System.out.println(AddingBigInts(a,b));
    }


    public static ArrayList<Integer> SieveOfEratosthenes(int n){
        ArrayList<Integer> num = new ArrayList<Integer>();

        for(int i = 0; i< n-1; i++){
            num.add(2+i);
        }
        for(int j = 0; j< num.size(); j++) {
            int p = num.get(j);
            for (int q = j + 1; q < num.size(); q++) {
                if (num.get(q) % p == 0) {
                    num.remove(q);
                    q--;
                }
            }
        }
        return num;
    }

    public static void GoldbachConjecture (int n){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst = SieveOfEratosthenes(n);
        boolean a = true;
        for(int i = 0; i< lst.size(); i++){
            for(int j = i+1; j<lst.size(); j++){
                if(lst.get(i)+lst.get(j)== n && a == true){
                    System.out.println(lst.get(i) + " + " + lst.get(j) + " = " + n);
                    a = false;
                }
            }
        }
    }

    public static ArrayList<Integer> AddingBigInts(ArrayList<Integer> num, ArrayList<Integer> lst){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int j = 0;
        if(num.size()>lst.size()){
            while(num.size()!=lst.size()){
                lst.add(0,0);
            }
        }
        else if(num.size()<lst.size()){
            while(num.size()!=lst.size()){
                num.add(0,0);
            }
        }
        for(int i = num.size()-1; i>=0; i--){
            result.add(0, (num.get(i)+ lst.get(i))%10 +j);
            if(num.get(i)+ lst.get(i) >=10){
                j = 1;
            }
            else{
                j = 0;
            }
        }
        return result;
    }

}
