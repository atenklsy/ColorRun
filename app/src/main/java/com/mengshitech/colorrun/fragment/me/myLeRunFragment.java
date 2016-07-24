package com.mengshitech.colorrun.fragment.me;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.MyLerunListViewAdapter;
import com.mengshitech.colorrun.bean.ImageEntity;
import com.mengshitech.colorrun.bean.OrderEntity;
import com.mengshitech.colorrun.bean.UserEntiy;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.HttpUtils;
import com.mengshitech.colorrun.utils.IPAddress;
import com.mengshitech.colorrun.utils.JsonTools;
import com.mengshitech.colorrun.utils.MainBackUtility;
import com.mengshitech.colorrun.view.MyListView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * atenklsy
 */
public class myLeRunFragment extends BaseFragment {
    private int entry_number = 3;
    View mLeRunView;
    List<OrderEntity> order_list;
    final List<ImageEntity> bmlist = new ArrayList<ImageEntity>();
    Bitmap bm;
    ImageEntity ib = null;
    OrderEntity order_info;
    MyListView myshow_listview;
    MyLerunListViewAdapter adapter;
    String userid = "123";

    @Override
    public View initView() {
        mActivity = getActivity();
        mLeRunView = View.inflate(mActivity, R.layout.me_mylerun, null);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
//        {
//            // 透明状态栏
//            getActivity().getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        MainBackUtility.MainBack(mLeRunView,"我的乐跑",getFragmentManager(),1);
        find();
//        loadData();
        new Thread(runnable).start();

        return mLeRunView;
    }

    private void find() {
        myshow_listview = (MyListView) mLeRunView.findViewById(R.id.lv_me_myshow);

    }

    private void loadData() {

        int count = adapter.getCount();
        int length = order_list.size() / entry_number;
        System.out.println("list" + order_list.size());
        System.out.println("length" + length);
        // 判断有没有数据
        if (count < length * entry_number) {
            adapter.addItem(count + entry_number);
        } else if (length * entry_number < count + 1
                && count + 1 < order_list.size() + 1) {
            adapter.addItem(order_list.size());
        } else {
            Toast.makeText(getActivity(), "没有更多活动了", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            String path = IPAddress.PATH;
            Map<String, String> map = new HashMap<String, String>();
            map.put("flag", "lerun");
            map.put("user_id", "123");
            map.put("index", "6");

            String result = HttpUtils.sendHttpClientPost(path, map,
                    "utf-8");
            Log.i("result", result);
            Message msg = new Message();
            msg.obj = result;
            handler.sendMessage(msg);
        }
    };

    Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            String result = (String) msg.obj;

            Log.i("result111", result);
            if (result.equals("timeout")) {
//                progressDialog.dismiss();
                Toast.makeText(getActivity(), "连接服务器超时", Toast.LENGTH_SHORT).show();
            } else {
//                progressDialog.dismiss();
                try {
                    Log.i("执行线程2222222","sssss");
                    order_list = JsonTools.getOrderInfo("result",result);
                    GetBitmap(order_list);

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };

    private void GetBitmap(final  List<OrderEntity> list) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {
                    order_info = list.get(i);
                    ib = new ImageEntity();

                    String path =IPAddress.path
                            + order_info.getLerun_poster();
                    System.out.println("图片地址" + path);
                    bm = HttpUtils.GetImage(path);
                    System.out.println("bm" + bm);
                    ib.setType_bitmap(bm);
                    System.out.println("从服务器那图" + ib.getType_bitmap());

                    bmlist.add(ib);
                }
                    Message msg = new Message();
                    msg.obj = bmlist;
                    handler2.sendMessage(msg);
            }
        }).start();
    }

    Handler handler2 = new Handler() {
        public void handleMessage(Message msg) {
            List<ImageEntity> bmlist = (List<ImageEntity>) msg.obj;
            adapter = new MyLerunListViewAdapter(entry_number, getActivity(), order_list, bmlist);
            myshow_listview.setAdapter(adapter);
        }
    };
}
