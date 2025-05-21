public class Reserva {
    private int idPista;
    private String fecha;
    private int duracion;

    public Reserva(int idPista, String fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public int getIdPista() {
        return idPista;
    }

    public String getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }
}
