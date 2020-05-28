package tjdev.mathquiz.com.br.controller;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;

        import androidx.appcompat.app.AppCompatActivity;

        import tjdev.mathquiz.com.br.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

}
