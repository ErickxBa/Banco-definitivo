public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(new Cuenta(4685, 0, "Pichincha"), "Erick");
        Usuario usuario1 = new Usuario(new Cuenta(9643, 0, "Pichincha"), "Fernando");
        usuario.ingresar(4685);
        usuario.depositar(4685, 200);
        usuario.retirar(4685, 100);
        usuario.imprimir(4685);
        usuario.transferir(usuario, usuario1, 20.1);
        usuario.imprimir(4685);


    }
}