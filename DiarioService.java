import java.io.*;

public class DiarioService {

    private static final String ARCHIVO_ENTRADAS = "entradas.txt";

    // GUARDAR ENTRADA
    public void guardarEntrada(EntradaDiario entrada) {

        try {

            FileWriter fw = new FileWriter(ARCHIVO_ENTRADAS, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(
                    entrada.getFecha() + ";" +
                    entrada.getAprendido() + ";" +
                    entrada.getRealizado() + ";" +
                    entrada.getDificultades() + ";" +
                    entrada.getHerramientas()
            );

            bw.newLine();

            bw.close();

            System.out.println("Entrada guardada");

        } catch (IOException e) {

            System.out.println("Error al guardar entrada");
        }
    }

    // MOSTRAR ENTRADAS
    public void mostrarEntradas() {

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(ARCHIVO_ENTRADAS));

            String linea;

            System.out.println("\n===== ENTRADAS =====");

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                System.out.println("---------------------");
                System.out.println("Fecha: " + datos[0]);
                System.out.println("Aprendido: " + datos[1]);
                System.out.println("Realizado: " + datos[2]);
                System.out.println("Dificultades: " + datos[3]);
                System.out.println("Herramientas: " + datos[4]);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("No hay entradas guardadas");
        }
    }
}
