package cl.atromilen.jsontocsv.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

@JsonRootName(value = "registros")
public class Employee implements Serializable {
    private static final long serialVersionUID = 7901569272729826603L;
    @JsonProperty("anexo")
    private String anexo;
    @JsonProperty("cargo")
    private String cargo;
    @JsonProperty("compania")
    private String compania;
    @JsonProperty("departamento")
    private String departamento;
    @JsonProperty("email")
    private String email;
    @JsonProperty("fecha_inicio_licencia")
    private String fecha_inicio_licencia;
    @JsonProperty("fecha_inicio_vacaciones")
    private String fecha_inicio_vacaciones;
    @JsonProperty("fecha_termino_licencia")
    private String fecha_termino_licencia;
    @JsonProperty("fecha_termino_vacaciones")
    private String fecha_termino_vacaciones;
    @JsonProperty("rut")
    private String rut;
    @JsonProperty("rut_jefe_directo")
    private String rut_jefe_directo;
    @JsonProperty("sucursal")
    private String sucursal;
    @JsonProperty("telefono")
    private String telefono;

}
