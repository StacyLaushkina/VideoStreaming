package laushkina.com.videostreaming;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize(){
        getStartButton().setOnClickListener((view) -> startVideo());
    }

    private void startVideo(){
        // Initialize video
        VideoView videoView = findViewById(R.id.video_view);
        videoView.setVideoURI(getVideoUri());

        // Initialize playback controls
        MediaController videoControl = new MediaController(this);
        videoControl.setAnchorView(videoView);
        videoView.setMediaController(videoControl);

        videoView.start();
        disableStartButton();
    }

    private void disableStartButton(){
        Button startButton = getStartButton();
        startButton.setEnabled(false);
        startButton.setAlpha(0.5f);
    }

    private Uri getVideoUri(){
        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        return Uri.parse(vidAddress);
    }

    private Button getStartButton(){
        return findViewById(R.id.start_video_button);
    }
}
