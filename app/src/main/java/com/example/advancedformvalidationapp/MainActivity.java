package com.example.advancedformvalidationapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
/** @noinspection unused*/
public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextSurname;
    private EditText editNumberPhone;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Powiązanie widoków z kodem
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSurname = findViewById(R.id.editTextSurname);
        editNumberPhone = findViewById(R.id.editNumberPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie wprowadzonych danych
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String numberphone = editNumberPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordconfirm = editTextPasswordConfirm.getText().toString().trim();
                // Walidacja danych
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                }else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
                }
                else if
                (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres email", Toast.LENGTH_SHORT).show();
                }else if (numberphone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();
                }else if (!(numberphone.length() >=9)){
                    Toast.makeText(MainActivity.this, "Niepoprawny numer telefonu", Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić hasło", Toast.LENGTH_SHORT).show();
                }else if (!(password.length() >=6)){
                    Toast.makeText(MainActivity.this, "Hasło jest za krótkie", Toast.LENGTH_SHORT).show();
                }else if (passwordconfirm.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę potwierdzić hasło", Toast.LENGTH_SHORT).show();
                }else if (!(passwordconfirm.equals(password))) {
                    Toast.makeText(MainActivity.this, "Hasła się nie zgadzają", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}