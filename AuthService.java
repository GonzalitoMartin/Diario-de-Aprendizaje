import java.io.*;

public class AuthService {

private static final String ARCHIVO_USUARIOS = "usuarios.txt";

// REGISTRO
public void registrarUsuario(Usuario usuario) {

try {

FileWriter fw = new FileWriter(ARCHIVO_USUARIOS, true);
BufferedWriter bw = new BufferedWriter(fw);

bw.write(usuario.getEmail() + ";" + usuario.getPassword());
bw.newLine();

bw.close();

System.out.println("Usuario registrado correctamente");

} catch (IOException e) {

System.out.println("Error al registrar usuario");
}
}

// LOGIN
public boolean login(String email, String password) {

try {

BufferedReader br = new BufferedReader(
new FileReader(ARCHIVO_USUARIOS));

String linea;

while ((linea = br.readLine()) != null) {

String[] datos = linea.split(";");

if (datos[0].equals(email)
&& datos[1].equals(password)) {

br.close();

System.out.println("Login correcto");
return true;
}
}

br.close();

} catch (IOException e) {

System.out.println("Error al leer usuarios");
}

System.out.println("Usuario o contraseña incorrectos");

return false;
}
}
