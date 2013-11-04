package org.rx.cr.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SystemInfo {
  private static String NombrePlataformaEjecuccion;
  private static String VersionPlataformaEjecucion;
  private static String VersionJava;
  private static String VersionEspecificaJava;
  private static String NombreMaquinaVirtual;
  private static String VendedorMaquinaVirtual;
  private static String VersionEspecificaMaquinaVirtual;
  private static String URLVendedor;
  private static String EspecificacionesVendedor;
  private static String DirectorioJava;
  private static String DirectorioActual;
  private static String DirectorioUsuario;
  private static String DirectorioEscritorio;
  private static String EscritorioSO;
  private static String DirectorioTemporal;
  private static String NombreSO;
  private static String ArquitecturaSO;
  private static String ArquitecturaModeloDatosSO;
  private static String NivelSO;
  private static String VersionSO;
  private static String LenguajeUsuario;
  private static String PaisUsuario;
  private static String HusoHorario;

    static {
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
    public static  String getNombrePlataformaEjecuccion() {
        return NombrePlataformaEjecuccion;
    }
    public static String getVersionPlataformaEjecucion() {
        return VersionPlataformaEjecucion;
    }
    public static String getVersionJava() {
        return VersionJava;
    }
    public static String getVersionEspecificaJava() {
        return VersionEspecificaJava;
    }
    public static String getVendedorMaquinaVirtual() {
        return VendedorMaquinaVirtual;
    }
    public static String getVersionEspecificaMaquinaVirtual() {
        return VersionEspecificaMaquinaVirtual;
    }
    public static String getURLVendedor() {
        return URLVendedor;
    }
    public static String getEspecificacionesVendedor() {
        return EspecificacionesVendedor;
    }
    public static String getDirectorioJava() {
        return DirectorioJava;
    }
    public static String getDirectorioActual() {
        return DirectorioActual;
    }
    public static String getDirectorioUsuario() {
        return DirectorioUsuario;
    }
    public static String getDirectorioEscritorio() {
        return DirectorioEscritorio;
    }
    public static String getEscritorioOS() {
        return EscritorioSO;
    }
    public static String getDirectorioTemporal() {
        return DirectorioTemporal;
    }
    public static String getNombreSO() {
        return NombreSO;
    }
    public static String getArquitecturaSO() {
        return ArquitecturaSO;
    }
    public static String getArquitecturaModeloDatosSO() {
        return ArquitecturaModeloDatosSO;
    }
    public static String getNivelSO() {
        return NivelSO;
    }
    public static String getVersionSO() {
        return VersionSO;
    }
    public static String getLenguajeUsuario() {
        return LenguajeUsuario;
    }
    public static String getPaisUsuario() {
        return PaisUsuario;
    }
    public static String getHusoHorario() {
        return HusoHorario;
    }
    public static String getNombreMaquinaVirtual() {
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
              System.out.println(programfilesdir);
              programfilesdir=programfilesdir.replaceAll("(x86)","");
              System.out.println(programfilesdir);
              buff=programfilesdir.indexOf("()");
              if (buff>0) {
                programfilesdir=programfilesdir.substring(0,programfilesdir.indexOf("()"));
              }              
              programfilesdir=programfilesdir.trim();
              is.close();
        } catch (IOException ex) {
            Logger.getLogger(SystemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
      return programfilesdir;
    }
    public static String getDirectorioArchivosProgramaX86(){      
      return getDirectorioArchivosPrograma()+" (x86)";
    }
    private static void setNombrePlataformaEjecuccion(String NombrePlataformaEjecuccion) {
        SystemInfo.NombrePlataformaEjecuccion = NombrePlataformaEjecuccion;
    }
    private static void setVersionPlataformaEjecucion(String VersionPlataformaEjecucion) {
        SystemInfo.VersionPlataformaEjecucion = VersionPlataformaEjecucion;
    }
    private static void setVersionJava(String VersionJava) {
        SystemInfo.VersionJava = VersionJava;
    }
    private static void setVersionEspecificaJava(String VersionEspecificaJava) {
        SystemInfo.VersionEspecificaJava = VersionEspecificaJava;
    }
    private static void setVendedorMaquinaVirtual(String VendedorMaquinaVirtual) {
        SystemInfo.VendedorMaquinaVirtual = VendedorMaquinaVirtual;
    }
    private static void setVersionEspecificaMaquinaVirtual(String VersionEspecificaMaquinaVirtual) {
        SystemInfo.VersionEspecificaMaquinaVirtual = VersionEspecificaMaquinaVirtual;
    }
    private static void setURLVendedor(String URLVendedor) {
        SystemInfo.URLVendedor = URLVendedor;
    }
    private static void setEspecificacionesVendedor(String EspecificacionesVendedor) {
        SystemInfo.EspecificacionesVendedor = EspecificacionesVendedor;
    }
    private static void setDirectorioJava(String DirectorioJava) {
       if (NombreSO.equals("linux")) {
         DirectorioJava+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioJava.length()>3) {
               DirectorioJava+="\\";
           }
       }
        SystemInfo.DirectorioJava = DirectorioJava;
    }
    private static void setDirectorioActual(String DirectorioActual) {
      if (NombreSO.equals("linux")) {
         DirectorioActual+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioActual.length()>3) {
               DirectorioActual+="\\";
           }
       }
        SystemInfo.DirectorioActual = DirectorioActual;
    }
    private static void setDirectorioUsuario(String DirectorioUsuario) {
      if (NombreSO.equals("linux")) {
         DirectorioUsuario+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioUsuario.length()>3) {
               DirectorioUsuario+="\\";
           }
       }
        SystemInfo.DirectorioUsuario = DirectorioUsuario;
    }
    private static void setDirectorioEscritorio(String DirectorioEscritorio) {
      if (NombreSO.equals("linux")) {
         DirectorioEscritorio+="/";
       } else {//if(getNombreSO().equals("windows")){
           if (DirectorioEscritorio.length()>3) {
               DirectorioEscritorio+="\\";
           }
       }
        SystemInfo.DirectorioEscritorio = DirectorioEscritorio;
    }
    private static void setEscritorioSO(String Escritorio) {
        SystemInfo.EscritorioSO = Escritorio;
    }
    private static void setDirectorioTemporal(String DirectorioTemporal) {
        SystemInfo.DirectorioTemporal = DirectorioTemporal;
    }
    private static void setNombreSO(String NombreSO) {
        SystemInfo.NombreSO = NombreSO;
    }
    private static void setArquitecturaSO(String ArquitecturaSO) {
        SystemInfo.ArquitecturaSO = ArquitecturaSO;
    }
    private static void setArquitecturaModeloDatosSO(String ArquitecturaModeloDatosSO) {
        SystemInfo.ArquitecturaModeloDatosSO = ArquitecturaModeloDatosSO;
    }
    private static void setNivelSO(String NivelSO) {
        SystemInfo.NivelSO = NivelSO;
    }
    private static void setVersionSO(String VersionSO) {
        SystemInfo.VersionSO = VersionSO;
    }
    private static void setLenguajeUsuario(String LenguajeUsuario) {
        SystemInfo.LenguajeUsuario = LenguajeUsuario;
    }
    private static void setPaisUsuario(String PaisUsuario) {
        SystemInfo.PaisUsuario = PaisUsuario;
    }
    private static void setHusoHorario(String HusoHorario) {
        SystemInfo.HusoHorario = HusoHorario;
    }
    public static void setNombreMaquinaVirtual(String NombreMaquinaVirtual) {
        SystemInfo.NombreMaquinaVirtual = NombreMaquinaVirtual;
    }
    public static String toStringInfo(){
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
    public static void main(String[] args) {
//        System.out.println(new File(getDirectorioArchivosPrograma()).exists());
//        System.out.println(new File(getDirectorioArchivosProgramaX86()).exists());
        System.out.println(toStringInfo());
    }
}
