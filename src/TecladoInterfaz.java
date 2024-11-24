import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TecladoInterfaz extends JPanel{
    private HashMap<Character, JButton> botonesTeclado;
    private JTextField ingresarPalabraIntento;

    public TecladoInterfaz(InterfazJuego juego){
        botonesTeclado = new HashMap<>();
        ingresarPalabraIntento = new JTextField();

        setLayout(new BorderLayout());

        ingresarPalabraIntento.setFont(new Font("Arial", Font.PLAIN, 18));
        ingresarPalabraIntento.setColumns(20);
        add(ingresarPalabraIntento, BorderLayout.NORTH);

        JPanel panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            JButton boton = new JButton(String.valueOf(letra));
            boton.setFont(new Font("Arial", Font.BOLD, 10));
            botonesTeclado.put(letra, boton);
            panelTeclado.add(boton);
        }
        add(panelTeclado, BorderLayout.CENTER);

        ingresarPalabraIntento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabraIntento = ingresarPalabraIntento.getText().toUpperCase(); // Convertir a mayúsculas
                if (palabraIntento.length() == 5) {
                    juego.imprimirPalabraIntento(palabraIntento);
                    ingresarPalabraIntento.setText("");
                    for (char letra : palabraIntento.toCharArray()) {
                        JButton boton = botonesTeclado.get(letra);
                        if (boton != null) {
                            boton.setEnabled(false); // Deshabilitar el botón
                            boton.setBackground(Color.GRAY); // Cambiar color de fondo (opcional)
                        }
                    }
                }
            }
        });

    }
}
