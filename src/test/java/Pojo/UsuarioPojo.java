package Pojo;

public class UsuarioPojo {


    private String usuarioLogin;
    private String usuarioSenha;

    public UsuarioPojo(String usuario,String senha){
        this.usuarioLogin = usuario;
        this.usuarioSenha = senha;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }
}
