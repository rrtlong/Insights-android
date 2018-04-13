package com.imalljoy.insightdemo.mvps.coins.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.entity.CoinVo;
import com.imalljoy.insightdemo.utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/31.
 */

public class CoinDetailIcoInfoFragment extends BaseFragment {
    public static String TITLE = "ICO信息";
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.for_coin)
    TextView forCoin;
    @BindView(R.id.soft_cap)
    TextView softCap;
    @BindView(R.id.hard_cap)
    TextView hardCap;
    @BindView(R.id.private_price)
    TextView privatePrice;
    @BindView(R.id.pre_ico_price)
    TextView preIcoPrice;
    @BindView(R.id.roi)
    TextView roi;
    @BindView(R.id.ico_market_value)
    TextView icoMarketValue;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.end_time)
    TextView endTime;
    @BindView(R.id.status)
    TextView status;
    Unbinder unbinder;
    private View mRootView;
    private CoinVo mVo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_coins_detail_icoinfo, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        mVo = (CoinVo) getArguments().getSerializable("coinVo");
        initView();
        return mRootView;
    }



    private void initView() {
        if(mVo != null){
            price.setText(mVo.getPriceConvert());
            forCoin.setText(mVo.getForCoin());
            softCap.setText(mVo.getSoftcap());
            hardCap.setText(mVo.getHardcap());
            roi.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getRoni()));
            icoMarketValue.setText(mVo.getIcoMarketValue());
            privatePrice.setText(mVo.getPrivatePrice());
            preIcoPrice.setText(mVo.getPreIcoPrice());

            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日:HH:mm:ss");
            startTime.setText(mVo.getIcoTime() != null ? format.format(new Date(mVo.getIcoTime().getTime())):"");
            endTime.setText(mVo.getIcoEndTime() != null ? format.format(new Date(mVo.getIcoEndTime().getTime())):"待定");
            //0:空投   1:新上  2:即将ico  3:正在ico  4:ico结束 5：币市
            switch (mVo.getType()){
                case 0:
                    status.setText("空投");
                    break;
                case 1:
                    status.setText("新上");
                    break;
                case 2:
                    status.setText("即将ICO");
                    break;
                case 3:
                    status.setText("正在ICO");
                    break;
                case 4:
                    status.setText("ICO结束");
                    break;
                case 5:
                    status.setText("币市");
                    break;
            }
        }
    }


    public static CoinDetailIcoInfoFragment newInstance(CoinVo coinVo) {
        CoinDetailIcoInfoFragment fragment = new CoinDetailIcoInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("coinVo", coinVo);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
