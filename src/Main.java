
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci la lunghezza della chiave: ");
        int lunghezza = input.nextInt();

        if (lunghezza <= 0) {
            System.out.println("La lunghezza deve essere maggiore di zero");
            input.close();
            return;
        }

        int[] chiave = new int[lunghezza];

        for (int i = 0; i < lunghezza; i++) {
            System.out.print("Inserisci il numero " + (i + 1) + ": ");
            chiave[i] = input.nextInt();
        }

        System.out.print("Scegli 1 per cifrare, 2 per decifrare: ");
        int operazione = input.nextInt();
        input.nextLine();

        if (operazione != 1 && operazione != 2) {
            System.out.println("Operazione non valida");
            input.close();
            return;
        }

        System.out.print("Inserisci il testo: ");
        String testo = input.nextLine();

        String risultato = "";
        int indiceChiave = 0;

        for (int i = 0; i < testo.length(); i++) {
            Lettera lettera = new Lettera(testo.charAt(i));

            if (lettera.carattere >= 32 && lettera.carattere <= 126) {
                if (operazione == 1) {
                    lettera.trasla(chiave[indiceChiave % lunghezza], "+");
                } else {
                    lettera.trasla(chiave[indiceChiave % lunghezza], "-");
                }

                indiceChiave++;
            }

            risultato = risultato + lettera.carattere;
        }

        System.out.println("Testo risultante: " + risultato);

        input.close();
    }
}
