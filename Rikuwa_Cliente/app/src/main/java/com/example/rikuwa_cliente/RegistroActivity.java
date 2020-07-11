package com.example.rikuwa_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.rikuwa_cliente.Registro.RegistroInterface;
import com.example.rikuwa_cliente.Registro.RegistroPresentador;

public class RegistroActivity extends AppCompatActivity implements RegistroInterface.View {
    private EditText miEditTextNombre;
    private EditText miEditTextApellido;
    private Spinner zona;
    private EditText miEditTextDireccion;
    private EditText miEditTextEmail;
    private EditText miEditTextPassword;
    private Button miButtonRegister;
    private Button miButtonSendToLogin;
    private MaterialDialog dialog;

    private RegistroInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setViews();
        miButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtdHandleRegistro();
            }
        });

    }

    private void setViews() {
        presenter = new RegistroPresentador(this);
        miEditTextNombre = (EditText) findViewById(R.id.et_Usuario);
        miEditTextApellido = (EditText) findViewById(R.id.et_Apellido);
        zona = (Spinner) findViewById(R.id.sp_Zona);
        miEditTextDireccion = (EditText) findViewById(R.id.et_Direccion);
        miEditTextEmail = (EditText) findViewById(R.id.et_correo);
        miEditTextPassword = (EditText) findViewById(R.id.et_password);
        miButtonRegister = (Button) findViewById(R.id.btn_ir_crearCuenta);
        miButtonSendToLogin = (Button) findViewById(R.id.btnSendToLogin);
       /* miButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtdHandleRegistro();
            }
        });*/
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)

                .title("CARGANDO")

                .content("Espere porfavor ...")

                .cancelable(false)

                .progress(true, 0);//true para que sea indeterminado y que no tenga maximo
        dialog = builder.build();
    }


    @Override
    public void mtdDesactivarInputs() {
        mtdSetEnable(false);
    }
    private void mtdSetEnable(boolean b) {
        miEditTextNombre.setEnabled(b);
        miEditTextApellido.setEnabled(b);
        zona.setEnabled(b);
        miEditTextDireccion.setEnabled(b);
        miEditTextEmail.setEnabled(b);
        miEditTextPassword.setEnabled(b);
        miButtonRegister.setEnabled(b);
    }

    @Override
    public void mtdActivarInputs() {
        mtdSetEnable(true);
    }

    @Override
    public void mtdMostrarProgress() {
        dialog.show();
    }

    @Override
    public void mtdOcultarProgress() {
        dialog.dismiss();
    }

    @Override
    public void mtdHandleRegistro() {
        if(!mtdValidarViews()){
            presenter.mtdDoRegistro(miEditTextNombre.getText().toString(), miEditTextApellido.getText().toString(), zona.getSelectedItem().toString(), miEditTextDireccion.getText().toString(), miEditTextEmail.getText().toString().trim(), miEditTextPassword.getText().toString().trim());
        }
    }

    @Override
    public boolean mtdValidarViews() {
        boolean retornarValor = true;
        //TextUtils.isEmpty: si esta vacio y es menor que 4, no es valido
        if (TextUtils.isEmpty(miEditTextNombre.getText())) {
            miEditTextNombre.setError("Este campo es obligatorio");
            retornarValor = false;
        }else if(miEditTextNombre.getText().toString().length() <2){
            miEditTextNombre.setError("Debes escribir al menos 2 caracteres");
            retornarValor = false;
        }

        if (TextUtils.isEmpty(miEditTextApellido.getText())) {
            miEditTextApellido.setError("Este campo es obligatorio");
            retornarValor = false;
        }else if(miEditTextApellido.getText().toString().length() <2){
            miEditTextApellido.setError("Debes escribir al menos 2 caracteres");
            retornarValor = false;
        }

        if (TextUtils.isEmpty(miEditTextDireccion.getText())) {
            miEditTextDireccion.setError("Este campo es obligatorio");
            retornarValor = false;
        }else if(miEditTextDireccion.getText().toString().length() <2){
            miEditTextDireccion.setError("Debes escribir al menos 2 caracteres");
            retornarValor = false;
        }

        if (TextUtils.isEmpty(miEditTextEmail.getText())) {
            miEditTextEmail.setError("Este campo es obligatorio");
            retornarValor = false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(miEditTextEmail.getText().toString().trim()).matches()){
            miEditTextEmail.setError("No es un email valido");
            retornarValor = false;
        }

        if (TextUtils.isEmpty(miEditTextPassword.getText())) {
            miEditTextPassword.setError("Este campo es obligatorio");
            retornarValor = false;
        }else if(miEditTextPassword.getText().toString().length() <6){
            miEditTextPassword.setError("Debes escribir al menos 6 caracteres");
            retornarValor = false;
        }

        return  retornarValor;
    }
    @Override
    protected void onDestroy() {
        ///cuando se cieerre la app, destroza la vista
        super.onDestroy();
        presenter.mtdOnDestroy();
    }

    @Override
    public void mtdOnError(String error) {
        Toast.makeText(RegistroActivity.this, "Error", Toast.LENGTH_SHORT).show();//muestra el error que envia el tasklistener
    }

    @Override
    public void mtdOnLogin() {
        finish();
    }
}
