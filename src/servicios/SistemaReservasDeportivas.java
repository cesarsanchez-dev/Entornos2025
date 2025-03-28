/**
 * Clase que modela un sistema de reservas deportivas.
 * Permite gestionar reservas de pistas deportivas y controlar la iluminación de las mismas.
 * 
 * @author César Sánchez
 * @version 1.1
 */
package servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entidades.Reserva;

public class SistemaReservasDeportivas {
    /**
     * Lista de reservas realizadas.
     */
    private List<Reserva> reservas;
    
    /**
     * Número máximo de pistas disponibles en el sistema.
     */
    private static final int MAX_PISTAS = 10; 

    /**
     * Constructor que inicializa la lista de reservas.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
    }

    /**
     * Reserva una pista deportiva si está disponible en la fecha indicada.
     * 
     * @param reserva Objeto Reserva con los datos de la reserva.
     * @return true si la reserva se realizó con éxito, false si la pista ya estaba reservada o el ID es inválido.
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            return false; // La pista ya está reservada en esa fecha
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
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha específica.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha Fecha en formato LocalDate.
     * @return true si la pista está disponible, false si ya está reservada en la fecha indicada.
     */
    public boolean verificarDisponibilidad(int idPista, String fecha) {
        return esFechaDisponible(idPista, fecha);
    }

    /**
     * Método privado que verifica si una fecha está disponible para una pista dada.
     * 
     * @param idPista Identificador de la pista.
     * @param string Fecha en formato LocalDate.
     * @return true si la pista está disponible, false si ya está reservada.
     */
    private boolean esFechaDisponible(int idPista, String string) {
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(string)) {
                return false;
            }
        }
        return true;
    }
}
