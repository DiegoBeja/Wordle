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
    private boolean win;

    public InterfazJuego(String palabraAdivinar){
        tecladoInterfaz = new TecladoInterfaz(this);
        tableroInterfaz = new TableroInterfaz();
        intentos = 0;
        win = false;
        palabraPorAdivinar = new PalabraPorAdivinar();
        mensajes = new JLabel();

        interfazJuego = new JPanel(new BorderLayout());
        setContentPane(interfazJuego);
        setTitle("Wordle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        interfazJuego.add(tableroInterfaz, BorderLayout.NORTH);
        JPanel panelMensaje = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelMensaje.add(mensajes);
        add(panelMensaje, BorderLayout.CENTER);
        interfazJuego.add(tecladoInterfaz, BorderLayout.SOUTH);
    }

    public void imprimirPalabraIntento(String palabraIntento){
        String palabrAdivinar = palabraPorAdivinar.getPalabraAdivinar();
        tableroInterfaz.mostrarPalabraIntento(palabraIntento, palabrAdivinar ,intentos);
        intentos++;
        procesarVictoria();
    }

    public void procesarVictoria(){
        win = tableroInterfaz.getResultado();

        if(intentos <= 6 && win){
            mensajes.setText("Has ganado :)");
            mensajes.setVisible(true);
            tecladoInterfaz.desactivarJTextField(false);
        } else if(intentos > 5 && !win){
            mensajes.setText("Has perdido");
            mensajes.setVisible(true);
            tecladoInterfaz.desactivarJTextField(false);
        }
    }
}
