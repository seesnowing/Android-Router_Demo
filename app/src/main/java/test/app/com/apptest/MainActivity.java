package test.app.com.apptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import test.app.com.apptest.strategy_study.ImageLoadUtils;

import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.Route;

@Route(value = "main_activity")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView jumpId;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jumpId=findViewById(R.id.jumpId);
        jumpId.setOnClickListener(this);
        imageView=findViewById(R.id.imageView);
    }

    //test code
    void  testAppCode(){
        //#2.txt
    }

    //loadImageView
    void loadImage(){
        String url="http://pic19.nipic.com/20120210/7827303_221233267358_2.jpg";
        ImageLoadUtils.getInstance().loadImageView(this,url,imageView);
    }

    //router test
    void routerJump(){
        Router.build("libararyBActivity").with("value","123").go(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.jumpId){
            routerJump();
            loadImage();
        }
    }
}
