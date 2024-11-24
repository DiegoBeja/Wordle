import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class InterfazJuego extends JFrame {
    private JPanel interfazJuego;
    private TecladoInterfaz tecladoInterfaz;
    private TableroInterfaz tableroInterfaz;
    private int intentos;
    private PalabraPorAdivinar palabraPorAdivinar;
    private JLabel mensajes;

    public InterfazJuego(String palabraAdivinar){
        tecladoInterfaz = new TecladoInterfaz(this);
        tableroInterfaz = new TableroInterfaz();
        intentos = 0;
        palabraPorAdivinar = new PalabraPorAdivinar();
        mensajes = new JLabel("Holaaa");

        interfazJuego = new JPanel(new BorderLayout());
        setContentPane(interfazJuego);
        setTitle("Wordle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        interfazJuego.add(tableroInterfaz, BorderLayout.NORTH);
        interfazJuego.add(mensajes, BorderLayout.CENTER);
        interfazJuego.add(tecladoInterfaz, BorderLayout.SOUTH);

    }

    public void imprimirPalabraIntento(String palabraIntento){
        String palabrAdivinar = palabraPorAdivinar.getPalabraAdivinar();
        tableroInterfaz.mostrarPalabraIntento(palabraIntento, palabrAdivinar ,intentos);
        intentos++;
    }
}
