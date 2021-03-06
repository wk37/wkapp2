package aacom.wangke.wkappw.testmvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wangke.core.basemvp.BaseMVPActivity;

import aacom.wangke.wkappw.R;

public class TestMvpActivity extends BaseMVPActivity<TestContract.TestPresenter>implements TestContract.TestView {

    private Button mBtnSd;
    private Button mBtnNet;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        mBtnSd = findViewById(R.id.btn_sd);
        mBtnNet = findViewById(R.id.btn_net);
        mBtnSd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestSD();
            }
        });
        mBtnNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestNet();

            }
        });

    }

    @Override
    public TestContract.TestPresenter createPresenter() {
        return new TestPresenterImpl();
    }

    @Override
    public void updateUISD(String text) {
        textView.setText(text);
    }

    @Override
    public void updateUINet(String text) {
        textView.setText(text);

    }
}
