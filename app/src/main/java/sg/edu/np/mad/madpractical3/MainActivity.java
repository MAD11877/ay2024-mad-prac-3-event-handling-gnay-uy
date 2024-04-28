package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        User user = new User("John Doe", "MAD Developer", 1, false);
        Random random = new Random();

        findViewById(R.id.Button1).setOnClickListener(v -> {
            boolean isFollowed = user.followed;
            user.followed = !isFollowed;
            if (user.followed) {
                user.followed = false;
                ((Button) v).setText("UNFOLLOW");
                Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show();
            } else {
                user.followed = true;
                ((Button) v).setText("FOLLOW");
                Toast.makeText(this, "Unfollowed", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.imageView1).setOnClickListener(v -> {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle("Profile")
                    .setMessage("MADness")
                    .setPositiveButton("CLOSE", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setNegativeButton("VIEW", (dialog, which) -> {
                        TextView x = (TextView)findViewById(R.id.textView2);
                        String text = "MAD " + Math.abs(random.nextInt());
                        x.setText(text);
                    })
                    .create();

            alertDialog.show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}