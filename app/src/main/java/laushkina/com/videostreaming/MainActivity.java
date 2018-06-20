package laushkina.com.videostreaming;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize(){
        TextView startButton = findViewById(R.id.start_video_button);
        startButton.setOnClickListener((view) -> startVideo());
    }

    private void startVideo(){
        VideoView videoView = findViewById(R.id.video_view);
        videoView.setVideoURI(getVideoUri());
        videoView.start();
    }

    private Uri getVideoUri(){
        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        return Uri.parse(vidAddress);
    }
}
