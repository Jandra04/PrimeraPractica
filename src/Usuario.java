public abstract class Usuario {

    private String nombreCompleto;
    private String cedula;
    private String correoElectronico;
    private String contrasenia;

    public Usuario(String nombreCompleto, String cedula,
                   String correoElectronico, String contrasenia) {

        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;

        setContrasenia(contrasenia);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {

        if (validarContrasenia(contrasenia)) {
            this.contrasenia = contrasenia;
        } else {
            throw new IllegalArgumentException(
                    "La contraseña no cumple con los requisitos."
            );
        }
    }

    public boolean validarContrasenia(String contrasenia) {

        if (contrasenia == null || contrasenia.length() < 8) {
            return false;
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        for (int i = 0; i < contrasenia.length(); i++) {

            char caracter = contrasenia.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayuscula = true;
            }

            if (Character.isLowerCase(caracter)) {
                tieneMinuscula = true;
            }

            if (Character.isDigit(caracter)) {
                tieneNumero = true;
            }

            if (!Character.isLetterOrDigit(caracter)) {
                tieneEspecial = true;
            }
        }

        return tieneMayuscula
                && tieneMinuscula
                && tieneNumero
                && tieneEspecial;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Usuario otroUsuario = (Usuario) obj;

        return cedula.equals(otroUsuario.cedula);
    }

    @Override
    public String toString() {

        return "Nombre: " + nombreCompleto +
                ", Cédula: " + cedula +
                ", Correo electrónico: " + correoElectronico;
    }
}