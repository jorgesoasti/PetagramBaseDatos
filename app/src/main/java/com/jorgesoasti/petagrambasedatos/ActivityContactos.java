package com.jorgesoasti.petagrambasedatos;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContactos extends AppCompatActivity {

    EditText usuario;
    EditText contrasena;
    EditText correo;
    EditText mensaje;
    Button enviar;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        usuario = findViewById(R.id.edtUsuario);
        contrasena = findViewById(R.id.edtContrasena);
        correo = findViewById(R.id.edtCorreo);
        mensaje = findViewById(R.id.edtMensaje);
        enviar = findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try{

                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return  new PasswordAuthentication(usuario.getText().toString(), contrasena.getText().toString());
                        }
                    });

                    if (session!=null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(usuario.getText().toString()));
                        message.setSubject("Prueba de JavaMail");
                        message.setRecipient(Message.RecipientType.TO, new InternetAddress(correo.getText().toString()));
                        message.setContent(mensaje.getText().toString(), "text/html; charset=utf-8");

                        Transport.send(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
