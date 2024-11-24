public class Main {
    public static void main(String[] args) {
        PalabraPorAdivinar hola = new PalabraPorAdivinar();
        InterfazJuego juego = new InterfazJuego(hola.getPalabraAdivinar());
        System.out.println(hola.getPalabraAdivinar());
    }
}