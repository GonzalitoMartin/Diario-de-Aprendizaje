public class EntradaDiario {

private String fecha;
private String aprendido;
private String realizado;
private String dificultades;
private String herramientas;

public EntradaDiario(String fecha,
String aprendido,
String realizado,
String dificultades,
String herramientas) {

this.fecha = fecha;
this.aprendido = aprendido;
this.realizado = realizado;
this.dificultades = dificultades;
this.herramientas = herramientas;
}

public String getFecha() {
return fecha;
}

public String getAprendido() {
return aprendido;
}

public String getRealizado() {
return realizado;
}

public String getDificultades() {
return dificultades;
}

public String getHerramientas() {
return herramientas;
}
}
