package com.example.rikuwa_cliente.Login;

public interface LoginInterface {

    interface View {
        void mtdDesactivarInputs();////desactivar los editext
        void mtdActivarInputs();/////activa los edt
        void mtdMostrarProgress();///muestra el progreso cuando envia datos al preesentador
        void mtdOcultarProgress();///oculta el progresbar
        void mtdHandleLogin();//empieza a trabajar para validar los datos, se encarga de quetodo funcione Y CUMPLA LOSPARAMETROS
        boolean mtdValidarEmail();///esto lo podria hacer el presentador
        boolean mtdValidarPassword();///esto igual
        void mtdOnLogin();
        void mtdOnError(String error);///porque el presentador nos devuelve el error    }
    }

    // se encarga de trabajar con la vista: necesita esos recursos de la vista para hacer el login
    interface Presenter{
        //tiene que tener esto para que elimine la vista y descarguemos recursos de telefono, cuaando cambiamos de activida a actividad
        //evitamos de que android se ralentize
        void mtdOnDestroy();
        void mtdToLogin(String email, String password);///enviar estos datos al modelo

        void mtdDoLogin(String email, String password);
    }

    //se encarga de hacer esa transaccion
    interface Model{
        void mtdDoLogin(String email, String password);
    }

    //si el login ha sido bueno o no, siempre esta escuchando
    interface TaskListener{
        void mtdOnSuccess();
        void mtdOnError(String error);
    }

}

