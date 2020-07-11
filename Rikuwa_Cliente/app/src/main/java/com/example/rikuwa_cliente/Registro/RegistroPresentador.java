package com.example.rikuwa_cliente.Registro;

public class RegistroPresentador implements RegistroInterface.Presenter, RegistroInterface.TaskListener{

    private RegistroInterface.View view;
    private RegistroInterface.Model model;

    public RegistroPresentador(RegistroInterface.View view) {
        this.view = view;
        model=new RegistroModelo(this);
    }

    @Override
    public void mtdOnDestroy() {
        view = null;
    }

    @Override
    public void mtdDoRegistro(String nombre, String apellido, String zona, String direccion, String email, String password) {
        if(view!=null){
            view.mtdDesactivarInputs();
            view.mtdMostrarProgress();
        }
        model.mtdOnRegistro(nombre, apellido, zona, direccion, email, password);
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
        if(view!=null){
            view.mtdActivarInputs();
            view.mtdOcultarProgress();
            view.mtdOnError(error);
        }
    }
}
