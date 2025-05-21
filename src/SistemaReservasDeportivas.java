
/**
 * Clase que modela un sistema de reservas deportivas.
 * Permite gestionar reservas de pistas deportivas y controlar la iluminación de las mismas.
 * 
 * @author César Sánchez
 * @version 1.2
 * 
 */
// prueba
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class SistemaReservasDeportivas {
    /**
     * Lista de reservas realizadas.
     */
    private List<Reserva> reservas;
    
    private GestorIluminacion GestorIluminacion;

	/**
     * Número máximo de pistas disponibles en el sistema.
     */
    private static final int MAX_PISTAS = 10; 

    /**
     * Constructor que inicializa la lista de reservas y el sistema de iluminación.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
    }
    public class GestorIluminacion{ 
    	private boolean[] iluminacion;
    	
    	
    	public GestorIluminacion(int numPistas) {
    		iluminacion = new boolean[numPistas]; // inializacion todas las luces 
    	}
    	
    	
    	public boolean encenderLuces(int idPista) {
            if (idPista < 0 || idPista >= iluminacion.length) {
                return false; // ID de pista inválido
            }
            iluminacion[idPista] = true;
            return true;
        }

        /**
         * Desactiva la iluminación de una pista específica.
         * 
         * @param idPista Identificador de la pista.
         * @return true si la iluminación se desactivó correctamente, false si el ID de la pista es inválido.
         */
        public boolean apagarLuces(int idPista) {
            if (idPista < 0 || idPista >= iluminacion.length) {
                return false; // ID de pista inválido
            }
            iluminacion[idPista] = false;
            return true;
        }
	}

    /**
     * Reserva una pista deportiva si está disponible en la fecha indicada.
     * 
     * @param idPista Identificador de la pista (0 a MAX_PISTAS - 1).
     * @param fecha Fecha de la reserva en formato "yyyy-MM-dd".
     * @param duracion Duración de la reserva en horas.
     * @return true si la reserva se realizó con éxito, false si la pista ya estaba reservada o el ID es inválido.
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == reserva.getIdPista() && EsFechaDisponible(null, reserva)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva identificada por su ID.
     * 
     * @param idReserva Identificador único de la reserva a cancelar.
     * @return true si la reserva se canceló correctamente, false si no se encontró la reserva.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) { // Se asume que Reserva tiene getIdReserva()
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    
    /**
     * Verifica la disponibilidad de una pista en una fecha y hora específica.
     * @param idPista Identificador de la pista.
     * @param fecha Fecha en formato "yyyy-MM-dd".
     * @param hora Hora de la reserva en formato "HH:mm" (no se usa actualmente en la comparación).
     * @return true si la pista está disponible, false si ya está reservada en la fecha indicada.
     */
    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && EsFechaDisponible(fecha, r)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }

	private boolean EsFechaDisponible(String fecha, Reserva r) {
		return r.getFecha().equals(fecha);
	}

	public BooleanSupplier reservarPista(int i, String string, int j) {
		// TODO Auto-generated method stub
		return null;
	}
}
