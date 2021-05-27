package com.test.viewpagertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Pagers extends LinearLayout {//繼承別的Layout亦可

    public Pagers(Context context, int pageNumber) {//pageNumber是由ＭainActivity.java那邊傳入頁碼
        super(context);

        //頁面須在此顯示

        View view = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        if(pageNumber == 1 ){
            view = inflater.inflate(R.layout.my_page_2, null);//連接頁面
        }else if(pageNumber ==2 ){
            view = inflater.inflate(R.layout.my_page_3, null);//連接頁面
            //recyclerView 畫面
//            setCardViewDataAndRecyclerView(context);

            RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
            recyclerAdapter recyclerAdapter = new recyclerAdapter(context);
            recyclerView.setAdapter(recyclerAdapter);
        }else {

            view = inflater.inflate(R.layout.my_pagers, null);//連接頁面
            TextView textView = view.findViewById(R.id.textView);//取得頁面元件
            textView.setText("第"+pageNumber+"頁");
        }

        addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);




        //將元件放入ViewPager

        //記得我之前的專案是在Pager內再設計RecyclerView，請注意就是每個Pagers可視為獨立運作，
        // 因此如果遇到RecyclerView即時更新的話，請記得在這個檔案裡面撰寫呦！
    }

    public void setCardViewDataAndRecyclerView(Context context){
        String TAG = "RecyclerView";

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
        recyclerAdapter recyclerAdapter = new recyclerAdapter(context);
        recyclerView.setAdapter(recyclerAdapter);
    }


    public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder>{
        private Context context;

        //建構子
        recyclerAdapter(Context context){
            this.context = context;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView address,tempMax,tempMin;
            Button button1,button2;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                button1 = itemView.findViewById(R.id.recycler_button1);
                button2 = itemView.findViewById(R.id.recycler_button2);

            }
        }
        //創建recyclerView
        @NonNull
        @Override
        public recyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerlayout,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }
        //設定 recyclerView 內容
        @Override
        public void onBindViewHolder(@NonNull recyclerAdapter.ViewHolder holder, int position) {


        }
        @Override
        public int getItemCount() {
            return 2;
        }
    }

}
