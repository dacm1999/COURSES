package com.example.seccion1_cursoandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.Manifest;
import android.widget.Toast;


public class Implicit_Intend extends AppCompatActivity {


    private EditText editTextPhone;
    private EditText editTextWeb;
    private ImageButton imgView;
    private ImageButton btnPhone;
    private ImageButton btnWeb;
    private ImageButton btnCamera;

    private final int PHONE_CALL_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);


        //Setting a tool bar to navigate between activities
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí inicias la actividad MainActivity
                Intent intent = new Intent(Implicit_Intend.this, MainActivity.class);
                startActivity(intent);
            }
        });

        editTextPhone = findViewById(R.id.txfPhone2);
        editTextWeb = findViewById(R.id.txfView);
        btnPhone = findViewById(R.id.imgButtonPhone);
        btnWeb = findViewById(R.id.imgBtnWeb);
        btnCamera = findViewById(R.id.imgBtnCamera);

        //Boton para la llamada telefonica
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhone.getText().toString();

                if (isValidPhoneNumber(phoneNumber)) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        //Comprobar si ha aceptado, no ha aceptado o nunca se le ha preguntado
                        if (checkPermission(Manifest.permission.CALL_PHONE)) {
                            // Ha aceptado
                            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                            if (ActivityCompat.checkSelfPermission(Implicit_Intend.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                                return;
                            startActivity(i);
                        } else {

                            //Ha denegado, es la primera vez que se le pregunta
                            if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                                //No se le ha preguntado aun
                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
                            } else {
                                //Ha denegado
                                Toast.makeText(Implicit_Intend.this, "Please, enable the permission", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                i.addCategory(Intent.CATEGORY_DEFAULT);
                                i.setData(Uri.parse("package:" + getPackageName()));
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                            }
                        }
                    } else {
                        olderVersions(phoneNumber);
                    }
                } else {
                    Toast.makeText(Implicit_Intend.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean isValidPhoneNumber(String phoneNumber) {
                // Aquí puedes implementar una validación más robusta para asegurarte de que el número sea válido
                return phoneNumber != null && !phoneNumber.isEmpty();
            }

            private void olderVersions(String phoneNumber) {
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));

                if (checkPermission(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentCall);
                } else {

                }
            }
        });

        //boton para la direccion web
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextWeb.getText().toString();
                String email = "danielcontreras_98@hotmail.com";

                if (!url.equals(null) && !url.isEmpty()) {
                    Intent intentWeb = new Intent();
                    intentWeb.setAction(Intent.ACTION_VIEW);
                    intentWeb.setData(Uri.parse("http://" + url));

                    //Contactos
                    Intent intentContacts = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));

                    //Email
                    Intent intentEmailTo = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));

                    //Email Completo
                    Intent intentMail = new Intent(Intent.ACTION_SEND, Uri.parse(email));
                    intentMail.setType("plain/text");
                    intentMail.putExtra(Intent.EXTRA_SUBJECT, "Mail's title");
                    intentMail.putExtra(Intent.EXTRA_TEXT, "Hi everyone");
                    intentMail.putExtra(Intent.EXTRA_EMAIL, new String[]{"danielcontreras12.dc@gmail.com"});
                    startActivity(Intent.createChooser(intentMail, "Elige cliente de correo"));

                    //Telefono 2 sin permisos requeridos
                    Intent intentphone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:694457964"));

                }
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intentCamera);
            }
        });
    }


// El resto del código permanece igual


    /**
     * El método onRequestPermissionsResult() es un callback que se invoca cuando el usuario responde a una
     * solicitud de permisos que fue realizada mediante ActivityCompat.requestPermissions()
     *
     * @param requestCode  El método onRequestPermissionsResult() es un callback que se invoca cuando el
     *                     usuario responde a una solicitud de permisos que fue realizada mediante ActivityCompat.requestPermissions()
     * @param permissions  Un array de strings que contiene los nombres de los permisos que fueron solicitados. --- NEVER NULL
     * @param grantResults Un array de enteros que contiene los resultados de las solicitudes de permisos correspondientes a los permisos en el array permissions.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {

            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];

                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    //Comprobamos si ha sido aceptado o denegado la peticion del permiso
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        //Permiso concedido
                        String phoneNumber = editTextPhone.getText().toString();
                        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                            return;
                        startActivity(intentCall);
                    } else {
                        Toast.makeText(Implicit_Intend.this, "You decline the access", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }

    }

    /**
     * Metodo que comprueba dandole un permiso si lo tiene o no -> Agregar el permiso al manifest
     *
     * @param permission String
     * @return int
     */
    private boolean checkPermission(String permission) {

        int result = this.checkSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }

}