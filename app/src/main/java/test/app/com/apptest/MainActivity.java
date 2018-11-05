package test.app.com.apptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;

@Route(value = "main_activity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView jumpId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jumpId=findViewById(R.id.jumpId);
        jumpId.setOnClickListener(this);
    }

    //test code
    void  testAppCode(){
        //#2.txt
    }

    //router test
    void routerJump(){
        Router.build("libararyBActivity").with("value","123").go(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.jumpId){
            routerJump();
        }
    }
}
