public class Usuario {
    private String name;
    private String apellido;
    private int numero;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Usuario(String name, String apellido, int numero) {
        this.name = name;
        this.apellido = apellido;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numero=" + numero +
                '}';
    }
}
