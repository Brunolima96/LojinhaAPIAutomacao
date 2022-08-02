package dataFactory;

import Pojo.UsuarioPojo;

public class UsuarioDataFactory {

    public static UsuarioPojo CriarUmNovoUsuarioAdministrador(){
        UsuarioPojo  usuarioLogin = new UsuarioPojo("admin","admin");
        return usuarioLogin;
    }
}
