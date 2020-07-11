package com.example.rikuwa_cliente.Registro;

public interface RegistroInterface {

    interface View {
        void mtdDesactivarInputs();////desactivar los editext
        void mtdActivarInputs();/////activa los edt
        void mtdMostrarProgress();///muestra el progreso cuando envia datos al preesentador
        void mtdOcultarProgress();///oculta el progresbar
        void mtdHandleRegistro();//empieza a trabajar para validar los datos, se encarga de quetodo funcione Y CUMPLA LOSPARAMETROS
        boolean mtdValidarViews();
        void mtdOnError(String error);///porque el presentador nos devuelve el error
        void mtdOnLogin();
    }

    // se encarga de trabajar con la vista: necesita esos recursos de la vista para hacer el login
    interface Presenter{
        //tiene que tener esto para que elimine la vista y descarguemos recursos de telefono, cuaando cambiamos de activida a actividad
        //evitamos de que android se ralentize
        void mtdOnDestroy();
        void mtdDoRegistro(String nombre, String apellido, String zona, String direccion, String email, String password);
    }

    //se encarga de hacer esa transaccion
    interface Model{
        void mtdOnRegistro(String nombre, String apellido, String zona, String direccion, String email, String password);
    }

    //si el login ha sido bueno o no, siempre esta escuchando
    interface TaskListener{
        void mtdOnSuccess();
        void mtdOnError(String error);
    }

}
