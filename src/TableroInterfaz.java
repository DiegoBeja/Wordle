import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TableroInterfaz extends JPanel{
    private JLabel[][] palabraIntento;

    public TableroInterfaz(){
        palabraIntento = new JLabel[6][5];
        setLayout(new GridLayout(6, 5, 0, 0));

        for(int i=0; i<6; i++){
            for(int j=0; j<5; j++) {
                palabraIntento[i][j] = new JLabel(" ");
                palabraIntento[i][j].setHorizontalAlignment(JLabel.CENTER);
                palabraIntento[i][j].setFont(new Font("Arial", Font.BOLD, 55));
                palabraIntento[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(palabraIntento[i][j]);
            }
        }

    }

    public void mostrarPalabraIntento(String palabra, String palabraAdivinar, int intento){
        String[] palabraIntentoSplit = palabra.split("");
        String[] palabraAdivinarSplit = palabraAdivinar.split("");
        boolean[] letrasAdivinarUsadas = new boolean[palabraAdivinarSplit.length];

        for(int i=0; i<6; i++){
            if (intento >= 0 && intento < 6 && i < 5) {
                palabraIntento[intento][i].setText(palabraIntentoSplit[i]);

                if(palabraIntentoSplit[i].equals(palabraAdivinarSplit[i])){
                    palabraIntento[intento][i].setOpaque(true);
                    palabraIntento[intento][i].setBackground(Color.green);
                    letrasAdivinarUsadas[i] = true;
                }
            }
        }

        for (int columna = 0; columna < palabraIntentoSplit.length; columna++) {
            if (!palabraIntentoSplit[columna].equals(palabraAdivinarSplit[columna])) {
                for (int k = 0; k < palabraAdivinarSplit.length; k++) {
                    if (palabraIntentoSplit[columna].equals(palabraAdivinarSplit[k]) && !letrasAdivinarUsadas[k]) {
                        palabraIntento[intento][columna].setOpaque(true);
                        palabraIntento[intento][columna].setBackground(Color.YELLOW);
                        letrasAdivinarUsadas[k] = true;
                        break;
                    } else{
                        palabraIntento[intento][columna].setOpaque(true);
                        palabraIntento[intento][columna].setBackground(Color.lightGray);
                    }
                }
            }
        }
    }
}
