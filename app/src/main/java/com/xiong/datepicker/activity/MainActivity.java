package com.xiong.datepicker.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiong.datepicker.R;
import com.xiong.datepicker.utils.ChooseCityInterface;
import com.xiong.datepicker.utils.ChooseCityUtil;
import com.xiong.datepicker.utils.ChooseDateInterface;
import com.xiong.datepicker.utils.ChooseDateUtil;

public class MainActivity extends BaseActivity {

    TextView tvDate,tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvCity = (TextView) findViewById(R.id.tvCity);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseDateDialog();
            }
        });
        tvCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseCityDialog();
            }
        });
    }

    //Choose Date
    public void chooseDateDialog() {
        final ChooseDateUtil dateUtil = new ChooseDateUtil();
        int[] oldDateArray = {2016, 01, 01};
        dateUtil.createDialog(this, oldDateArray, new ChooseDateInterface() {
            @Override
            public void sure(int[] newDateArray) {
                tvDate.setText(newDateArray[0] + "-" + newDateArray[1] + "-" + newDateArray[2]);
            }
        });
    }

    //Choose Date
    public void chooseCityDialog() {
        final ChooseCityUtil cityUtil = new ChooseCityUtil();
        String[] oldCityArray = tvCity.getText().toString().split("-");
        cityUtil.createDialog(this, oldCityArray, new ChooseCityInterface() {
            @Override
            public void sure(String[] newCityArray) {
                tvCity.setText(newCityArray[0] + "-" + newCityArray[1] + "-" + newCityArray[2]);
            }
        });
    }
}
