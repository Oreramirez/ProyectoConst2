package com.example.rikuwa_cliente.Login;

public class LoginPresentador implements LoginInterface.Presenter, LoginInterface.TaskListener {

    private LoginInterface.View view;
    private LoginInterface.Model model;

    public LoginPresentador(LoginInterface.View view) {
        this.view = view;
        model=new LoginModelo(this);
    }

    @Override
    public void mtdOnDestroy() {
        view = null;
    }

    @Override
    public void mtdToLogin(String email, String password) {
        if(view!=null){
            view.mtdDesactivarInputs();
            view.mtdMostrarProgress();
        }
        model.mtdDoLogin(email, password);
    }

    @Override
    public void mtdDoLogin(String email, String password) {
        if(view!=null){
            view.mtdDesactivarInputs();
            view.mtdMostrarProgress();
        }
        model.mtdDoLogin(email, password);
    }

    @Override
    public void mtdOnSuccess() {
        if(view!=null){
            view.mtdActivarInputs();
            view.mtdOcultarProgress();
            view.mtdOnLogin();
        }
    }

    @Override
    public void mtdOnError(String error) {

    }
}
