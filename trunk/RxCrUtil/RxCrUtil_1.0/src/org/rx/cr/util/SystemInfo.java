package org.rx.cr.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SystemInfo {
  private String NombrePlataformaEjecuccion;
  private String VersionPlataformaEjecucion;
  private String VersionJava;
  private String VersionEspecificaJava;
  private String NombreMaquinaVirtual;
  private String VendedorMaquinaVirtual;
  private String VersionEspecificaMaquinaVirtual;
  private String URLVendedor;
  private String EspecificacionesVendedor;
  private String DirectorioJava;
  private String DirectorioActual;
  private String DirectorioUsuario;
  private String DirectorioEscritorio;
  private String EscritorioSO;
  private String DirectorioTemporal;
  private String NombreSO;
  private String ArquitecturaSO;
  private String ArquitecturaModeloDatosSO;
  private String NivelSO;
  private String VersionSO;
  private String LenguajeUsuario;
  private String PaisUsuario;
  private String HusoHorario;

    public SystemInfo() {
      setNombreSO(System.getProperty("os.name"));
      setNombrePlataformaEjecuccion(System.getProperty("java.runtime.name"));
      setVersionPlataformaEjecucion(System.getProperty("java.runtime.version"));
      setVersionJava(System.getProperty("java.specification.version"));
      setVersionEspecificaJava(System.getProperty("java.version"));
      setNombreMaquinaVirtual(System.getProperty("java.vm.name"));
      setVendedorMaquinaVirtual(System.getProperty("java.vm.vendor"));
      setVersionEspecificaMaquinaVirtual(System.getProperty("java.vm.version"));
      setURLVendedor(System.getProperty("java.vendor.url"));
      setEspecificacionesVendedor(System.getProperty("java.vm.specification.vendor"));
      setDirectorioJava(System.getProperty("java.home"));
      setDirectorioActual(System.getProperty("user.dir"));
      setDirectorioUsuario(System.getProperty("user.home"));
      setDirectorioEscritorio(System.getProperty("user.home"));
      setEscritorioSO(System.getProperty("sun.desktop"));
      setDirectorioTemporal(System.getProperty("java.io.tmpdir"));      
      setArquitecturaSO(System.getProperty("os.arch"));
      setArquitecturaModeloDatosSO(System.getProperty("sun.arch.data.model"));
      setNivelSO(System.getProperty("sun.os.patch.level"));
      setVersionSO(System.getProperty("os.version"));
      setLenguajeUsuario(System.getProperty("user.language"));
      setPaisUsuario(System.getProperty("user.country"));
      setHusoHorario(System.getProperty("user.timezone"));
    }
    public String getNombrePlataformaEjecuccion() {
        return NombrePlataformaEjecuccion;
    }
    public String getVersionPlataformaEjecucion() {
        return VersionPlataformaEjecucion;
    }
    public String getVersionJava() {
        return VersionJava;
    }
    public String getVersionEspecificaJava() {
        return VersionEspecificaJava;
    }
    public String getVendedorMaquinaVirtual() {
        return VendedorMaquinaVirtual;
    }
    public String getVersionEspecificaMaquinaVirtual() {
        return VersionEspecificaMaquinaVirtual;
    }
    public String getURLVendedor() {
        return URLVendedor;
    }
    public String getEspecificacionesVendedor() {
        return EspecificacionesVendedor;
    }
    public String getDirectorioJava() {
        return DirectorioJava;
    }
    public String getDirectorioActual() {
        return DirectorioActual;
    }
    public String getDirectorioUsuario() {
        return DirectorioUsuario;
    }
    public String getDirectorioEscritorio() {
        return DirectorioEscritorio;
    }
    public String getEscritorioOS() {
        return EscritorioSO;
    }
    public String getDirectorioTemporal() {
        return DirectorioTemporal;
    }
    public String getNombreSO() {
        return NombreSO;
    }
    public String getArquitecturaSO() {
        return ArquitecturaSO;
    }
    public String getArquitecturaModeloDatosSO() {
        return ArquitecturaModeloDatosSO;
    }
    public String getNivelSO() {
        return NivelSO;
    }
    public String getVersionSO() {
        return VersionSO;
    }
    public String getLenguajeUsuario() {
        return LenguajeUsuario;
    }
    public String getPaisUsuario() {
        return PaisUsuario;
    }
    public String getHusoHorario() {
        return HusoHorario;
    }
    public String getNombreMaquinaVirtual() {
        return NombreMaquinaVirtual;
    }
    public static String getDirectorioDatosPrograma(){
      String appdatadir="";
        try {
            Process pc = Runtime.getRuntime().exec("cmd.exe /C echo %appdata%");
              InputStream is = pc.getInputStream();
              int buff;              
              while ((buff=is.read())>0) {            
                 appdatadir+=(char)buff;
              }
              appdatadir=appdatadir.trim();
              is.close();
        } catch (IOException ex) {
            Logger.getLogger(SystemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
      return appdatadir;
    }
    public static String getDirectorioArchivosPrograma(){
      String programfilesdir="";
        try {
            Process pc = Runtime.getRuntime().exec("cmd.exe /C echo %programfiles%");
              InputStream is = pc.getInputStream();
              int buff;
              
              while ((buff=is.read())>0) {            
                 programfilesdir+=(char)buff;
              }
              programfilesdir=programfilesdir.trim();
              is.close();
        } catch (IOException ex) {
            Logger.getLogger(SystemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
      return programfilesdir;
    }
    private void setNombrePlataformaEjecuccion(String NombrePlataformaEjecuccion) {
        this.NombrePlataformaEjecuccion = NombrePlataformaEjecuccion;
    }
    private void setVersionPlataformaEjecucion(String VersionPlataformaEjecucion) {
        this.VersionPlataformaEjecucion = VersionPlataformaEjecucion;
    }
    private void setVersionJava(String VersionJava) {
        this.VersionJava = VersionJava;
    }
    private void setVersionEspecificaJava(String VersionEspecificaJava) {
        this.VersionEspecificaJava = VersionEspecificaJava;
    }
    private void setVendedorMaquinaVirtual(String VendedorMaquinaVirtual) {
        this.VendedorMaquinaVirtual = VendedorMaquinaVirtual;
    }
    private void setVersionEspecificaMaquinaVirtual(String VersionEspecificaMaquinaVirtual) {
        this.VersionEspecificaMaquinaVirtual = VersionEspecificaMaquinaVirtual;
    }
    private void setURLVendedor(String URLVendedor) {
        this.URLVendedor = URLVendedor;
    }
    private void setEspecificacionesVendedor(String EspecificacionesVendedor) {
        this.EspecificacionesVendedor = EspecificacionesVendedor;
    }
    private void setDirectorioJava(String DirectorioJava) {
       if (NombreSO.equals("linux")) {
         DirectorioJava+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioJava.length()>3) {
               DirectorioJava+="\\";
           }
       }
        this.DirectorioJava = DirectorioJava;
    }
    private void setDirectorioActual(String DirectorioActual) {
      if (NombreSO.equals("linux")) {
         DirectorioActual+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioActual.length()>3) {
               DirectorioActual+="\\";
           }
       }
        this.DirectorioActual = DirectorioActual;
    }
    private void setDirectorioUsuario(String DirectorioUsuario) {
      if (NombreSO.equals("linux")) {
         DirectorioUsuario+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioUsuario.length()>3) {
               DirectorioUsuario+="\\";
           }
       }
        this.DirectorioUsuario = DirectorioUsuario;
    }
    private void setDirectorioEscritorio(String DirectorioEscritorio) {
      if (NombreSO.equals("linux")) {
         DirectorioEscritorio+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioEscritorio.length()>3) {
               DirectorioEscritorio+="\\";
           }
       }
        this.DirectorioEscritorio = DirectorioEscritorio;
    }
    private void setEscritorioSO(String Escritorio) {
        this.EscritorioSO = Escritorio;
    }
    private void setDirectorioTemporal(String DirectorioTemporal) {
        this.DirectorioTemporal = DirectorioTemporal;
    }
    private void setNombreSO(String NombreSO) {
        this.NombreSO = NombreSO;
    }
    private void setArquitecturaSO(String ArquitecturaSO) {
        this.ArquitecturaSO = ArquitecturaSO;
    }
    private void setArquitecturaModeloDatosSO(String ArquitecturaModeloDatosSO) {
        this.ArquitecturaModeloDatosSO = ArquitecturaModeloDatosSO;
    }
    private void setNivelSO(String NivelSO) {
        this.NivelSO = NivelSO;
    }
    private void setVersionSO(String VersionSO) {
        this.VersionSO = VersionSO;
    }
    private void setLenguajeUsuario(String LenguajeUsuario) {
        this.LenguajeUsuario = LenguajeUsuario;
    }
    private void setPaisUsuario(String PaisUsuario) {
        this.PaisUsuario = PaisUsuario;
    }
    private void setHusoHorario(String HusoHorario) {
        this.HusoHorario = HusoHorario;
    }
    public void setNombreMaquinaVirtual(String NombreMaquinaVirtual) {
        this.NombreMaquinaVirtual = NombreMaquinaVirtual;
    }
    @Override
    public String toString(){
      String SI=" Nombre de la Plataforma de Ejecuccion : "+getNombrePlataformaEjecuccion()+"\n"
               +" Version de la Plataforma de Ejecucion : "+getVersionPlataformaEjecucion()+"\n"
               +" Version Java : "+getVersionJava()+"\n"
               +" Version Especifica Java : "+getVersionEspecificaJava()+"\n"
               +" Nombre de la Maquina Virtual : "+getNombreMaquinaVirtual()+"\n"
               +" Vendedor de la Maquina Virtual : "+getVendedorMaquinaVirtual()+"\n"
               +" Version Especifica de la Maquina Virtual : "+getVersionEspecificaMaquinaVirtual()+"\n"
               +" URL Vendedor : "+getURLVendedor()+"\n"
               +" Especificaciones del Vendedor : "+getEspecificacionesVendedor()+"\n"
               +" Direcctorio Java : "+getDirectorioJava()+"\n"
               +" Directorio Actual : "+getDirectorioActual()+"\n"
               +" Directorio del Usuario : "+getDirectorioUsuario()+"\n"
               +" Directorio del Escritorio : "+getDirectorioEscritorio()+"\n"
               +" Directorio Temporal : "+getDirectorioTemporal()+"\n"
               +" Escritorio SO : "+getEscritorioOS()+"\n"
               +" Nombre SO : "+getNombreSO()+"\n"
               +" Arquitectura SO : "+getArquitecturaSO()+"\n"
               +" Arquitectura del Modelo de datos : "+getArquitecturaModeloDatosSO()+" Bits "+"\n"
               +" Nivel de SO : "+getNivelSO()+"\n"
               +" Version del SO : "+getVersionSO()+"\n"
               +" Lenguaje Usuario : "+getLenguajeUsuario()+"\n"
               +" Pais Usuario : "+getPaisUsuario()+"\n"
               +" Huso Horario : "+getHusoHorario()+"\n";
      return SI;
    }
}
