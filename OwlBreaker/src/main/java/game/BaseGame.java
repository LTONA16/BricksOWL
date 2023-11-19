package game;

/**
 * Clase base para la creación de la lógica del juego. Esta clase contiene la firma de los métodos utilizados por
 * el GameLoop para controlar la lógica del juego y su renderizado en la ventana.
 *
 * @author Aguilera Luzania José Luis.
 */
public abstract class BaseGame {

    /**
     * Velocidad a la que el contenido del juego se debe actualizar.
     */
    private final double UPDATE_RATE = 1.0d / 144.0d;

    /**
     * Bandera que permite saber si el GameLoop se está ejecutando.
     */
    protected boolean isRunning = false;

    /**
     * Método que maneja la lógica del juego y es invocado 60 veces por segundo.
     */
    public abstract void update();

    /**
     * Método que maneja el renderizado del juego en la ventana, es invocado al menos una vez por segundo.
     */
    public abstract void render();

    /**
     * @return Bandera que permite saber si el GameLoop se está ejecutando.
     */
    public boolean IsRunning() {
        return isRunning;
    }

    /**
     * Se encarga de invocar los métodos para actualizar y renderizar el contenido del juego.
     */
    public void run() {
        // Permite llevar un control para saber cuando es necesario actualizar la lógica.
        double accumulator = 0;

        // Variables para calcular el tiempo entre actualizaciones.
        long currentTime, lastUpdate = System.currentTimeMillis();

        // Ciclo principal.
        while (IsRunning()) {

            // Obtener el tiempo.
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            // Actualizamos la lógica del juego.
            if (accumulator >= UPDATE_RATE) {

                while (accumulator > UPDATE_RATE) {
                    update();
                    accumulator -= UPDATE_RATE;
                }

                // Actualizamos los gráficos.
                render();
            }
        }
    }
}
