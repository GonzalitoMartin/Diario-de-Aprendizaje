import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        AuthService authService = new AuthService();
        DiarioService diarioService = new DiarioService();

        int opcion;

        do {

            System.out.println("\n===== DIARIO DE APRENDIZAJE =====");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Contraseña: ");
                    String password = sc.nextLine();

                    Usuario usuario = new Usuario(email, password);

                    authService.registrarUsuario(usuario);

                    break;

                case 2:

                    System.out.print("Email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Contraseña: ");
                    String loginPassword = sc.nextLine();

                    boolean loginCorrecto =
                            authService.login(loginEmail, loginPassword);

                    if (loginCorrecto) {

                        menuDiario(diarioService);
                    }

                    break;

                case 3:

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 3);
    }

    // MENU DIARIO
    public static void menuDiario(DiarioService diarioService) {

        int opcion;

        do {

            System.out.println("\n===== MENÚ DIARIO =====");
            System.out.println("1. Crear entrada");
            System.out.println("2. Ver entradas");
            System.out.println("3. Cerrar sesión");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Fecha: ");
                    String fecha = sc.nextLine();

                    System.out.print("Lo aprendido: ");
                    String aprendido = sc.nextLine();

                    System.out.print("Lo realizado: ");
                    String realizado = sc.nextLine();

                    System.out.print("Dificultades: ");
                    String dificultades = sc.nextLine();

                    System.out.print("Herramientas utilizadas: ");
                    String herramientas = sc.nextLine();

                    EntradaDiario entrada = new EntradaDiario(
                            fecha,
                            aprendido,
                            realizado,
                            dificultades,
                            herramientas
                    );

                    diarioService.guardarEntrada(entrada);

                    break;

                case 2:

                    diarioService.mostrarEntradas();

                    break;

                case 3:

                    System.out.println("Sesión cerrada");
                    break;

                default:

                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 3);
    }
}