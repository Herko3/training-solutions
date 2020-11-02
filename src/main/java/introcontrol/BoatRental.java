package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hányan szeretnének csónakázni?");
        int amount = scanner.nextInt();
        scanner.nextLine();

//        if (amount>10){
//            System.out.println("Kivitték az összeset, és maradtak még a parton");
//        }
//        if (amount<=10 && amount>=8){
//            System.out.println("Elvitték az 5 és 3 személyest, még a 2 személyes maradt bent");
//        }
//
//        if (amount<=7 && amount>=6 ){
//            System.out.println("Elvitték az 5 és 2 személyest, még a 3 személyes maradt bent");
//        }
//
//        if(amount<=5 && amount >=4){
//            System.out.println("Elvitték az 5 személyest, még a 3 és 2 személyes maradt bent");
//        }
//
//        if (amount == 3){
//            System.out.println("Elvitték a 3 személyest, még az 5 és 2 személyes maradt bent");
//        }
//        if (amount<=2){
//            System.out.println("Elvitték a 2 személyest, még az 5 és 3 személyes maradt bent");
//        }
    int places = 10;
    int boats = 3;

    if (amount>3){
        System.out.println("5 személyes kiadva");
        amount = amount -5;
        places = places - 5;
        boats--;
    }
    if (amount>2){
        System.out.println("3 személyes kiadva");
        amount = amount -3;
        places = places -3;
        boats--;
    }
    if (amount>0){
        System.out.println("2 személyes kiadva");
        amount = amount - 2;
        places = places - 2;
        boats--;
    }
    if (amount>0){
        System.out.println("Maradtak a parton is, az összes hajó elfogyott");
    } else {
        System.out.println("Üres helyek száma " + places);
        System.out.println("Bent maradt csónakok száma " + boats);
    }


    }

}
