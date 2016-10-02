package pe.com.unispan.mobile.activities;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.com.unispan.mobile.R;
import pe.com.unispan.mobile.model.User;
import pe.com.unispan.mobile.storage.ExternalStorage;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    // UI references.
    private AutoCompleteTextView userTextView;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        // Set up the login form.
        userTextView = (AutoCompleteTextView) findViewById(R.id.userTextView);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        Button signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("STATE", "Validar usuario");

        User user = User.getInstance();
        if (!user.getLogin().isEmpty()) {
            Toast.makeText(getApplicationContext(),"Hola " + user.getLogin(),Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        userTextView.setError(null);
        passwordEditText.setError(null);

        // Store values at the time of the login attempt.
        String user = userTextView.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            Log.d("STATE", "Password " + password);
            passwordEditText.setError(getString(R.string.error_invalid_password));
            focusView = passwordEditText;
            cancel = true;
        }

        // Check for a valid user address.
        if (TextUtils.isEmpty(user)) {
            userTextView.setError(getString(R.string.error_field_required));
            focusView = userTextView;
            cancel = true;
        } else if (!(user.equals("admin") && password.equals("admin"))) {
            Log.d("STATE", user);
            userTextView.setError(getString(R.string.error_invalid_user));
            focusView = userTextView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            Log.d("STATE", "Grabar en memoria y en el modelo");
            ExternalStorage externalStorage = new ExternalStorage(getApplicationContext());
            externalStorage.setKeptName(user);

            User userModel = User.getInstance();
            userModel.setLogin(user);
        }
    }
}