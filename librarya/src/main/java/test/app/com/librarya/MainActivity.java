package test.app.com.librarya;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;

@Route(value = "libraryA")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        textView=findViewById(R.id.textView);
        textView.setOnClickListener(this);
    }

    //router test
    void routerJump(){
        Router.build("main_activity").go(this);
    }

    @Override
    public void onClick(View v) {
        routerJump();
    }
}
