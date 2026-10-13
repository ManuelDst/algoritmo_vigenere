
public class Lettera {
    char carattere;

    public Lettera(char carattere) {
        this.carattere = carattere;
    }

    public void trasla(int salto, String direzione) {
        if (carattere >= 32 && carattere <= 126) {
            if (direzione.equals("-")) {
                salto = -salto;
            }

            int codice = carattere - 32;
            codice = ((codice + salto) % 95 + 95) % 95;
            carattere = (char) (codice + 32);
        }
    }
}
