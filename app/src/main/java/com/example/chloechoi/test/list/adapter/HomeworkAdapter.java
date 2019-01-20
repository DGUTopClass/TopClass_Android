package com.example.chloechoi.test.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chloechoi.test.interfaces.HomeworkViewHolder;
import com.example.chloechoi.test.list.viewholder.ToBeSummitedHWViewHolder;
import com.example.chloechoi.test.model.HomeworkData;
import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.viewholder.SummitedHWViewHolder;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;

import static android.view.View.GONE;

public class HomeworkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<HomeworkData> dataList;
    Context mContext;
    Constants constants = new Constants();

    int[] layouts = {R.layout.li_to_be_summited_hw, R.layout.li_summited_hw};

    int type;
    public HomeworkAdapter(ArrayList<HomeworkData> itemList, int type) {
        dataList = itemList;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layout = layouts[type];
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        mContext = viewGroup.getContext();
        RecyclerView.ViewHolder holder = initViewHolder(v);
        return holder;
    }

    RecyclerView.ViewHolder initViewHolder(View v){
        if(type == 0) return new ToBeSummitedHWViewHolder(v);
        else return new SummitedHWViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int i) {
        if(type == constants.TYPE_TO_BE_SUMMITED_HW){
            ToBeSummitedHWViewHolder castedHolder = (ToBeSummitedHWViewHolder) holder;

            castedHolder.vPriority.setBackgroundColor(mContext.getResources().getColor(R.color.hw_priority_2));
            /*TODO 시연아^^ 이거^^ 서버에서 받으면 deadline이라는 날짜를 나타내는 string이 넘어와^^
            * 이걸 잘 잘라서 오늘 날짜(받아오는 함수 있음^~^)랑 비교해서 color 바꿔주면돼*^^* */

            castedHolder.tvTitle.setText(dataList.get(i).title);
            castedHolder.tvSubject.setText(dataList.get(i).subject);
            castedHolder.tvDeadLine.setText(dataList.get(i).deadline);
        }
        else{
            final SummitedHWViewHolder castedHolder = (SummitedHWViewHolder) holder;

            castedHolder.tvTitle.setText(dataList.get(i).title);
            castedHolder.tvSubject.setText(dataList.get(i).subject);
            if(dataList.get(i).isHanded) castedHolder.tvIsSummited.setVisibility(View.INVISIBLE);
            castedHolder.btnScore.setText(dataList.get(i).toTvScore());

            castedHolder.btnScore.setOnClickListener(
                    new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            if(castedHolder.lyFeedback.getVisibility() == GONE){
                                castedHolder.lyFeedback.setVisibility(View.VISIBLE);
                                castedHolder.btnScore.setBackgroundColor(mContext.getResources().getColor(R.color.btnSelected));
                            }
                            else{
                                castedHolder.lyFeedback.setVisibility(View.GONE);
                                castedHolder.btnScore.setBackgroundColor(mContext.getResources().getColor(R.color.btnDefault));
                            }
                        }
                    }
            );

            castedHolder.tvFeedback.setText(dataList.get(i).feedback);
        }

    }

    @Override
    public int getItemCount() {return dataList.size();}
}
