package test.app.com.libraryb;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chenenyu.router.Router;
import com.chenenyu.router.annotation.InjectParam;
import com.chenenyu.router.annotation.Interceptor;
import com.chenenyu.router.annotation.Route;

@Route(value = "libararyBActivity")
public class librarybActivity extends Activity implements View.OnClickListener {

    @InjectParam(key="value")
    String value;
    TextView clickText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_lib_b);
        clickText=findViewById(R.id.clickText);
        clickText.setOnClickListener(this);
        Router.injectParams(this);
        Toast.makeText(this,value,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Router.build("libraryA").go(this);
    }
}
