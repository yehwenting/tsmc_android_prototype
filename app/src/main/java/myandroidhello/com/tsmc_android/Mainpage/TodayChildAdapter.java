package myandroidhello.com.tsmc_android.Mainpage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import myandroidhello.com.tsmc_android.DetailChild.DetailChildActivity;
import myandroidhello.com.tsmc_android.DetailParent.DetailParentActivity;
import myandroidhello.com.tsmc_android.Model.WorkOrder;
import myandroidhello.com.tsmc_android.Model.WorkOrderChild;
import myandroidhello.com.tsmc_android.R;

/**
 * Created by Yehwenting on 2018/7/30.
 */

public class TodayChildAdapter extends  RecyclerView.Adapter<TodayChildAdapter.TodayChildViewHolder> {

    private List<WorkOrder> workOrderChildren;
    private WorkOrder workOrder;
    Context context;

    public TodayChildAdapter(WorkOrder workOrderChildren) {
        this.workOrder=workOrderChildren;
//        this.workOrderChildren = workOrderChildren;
        Log.d("hhhhh","hello");

    }


    @NonNull
    @Override
    public TodayChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_mainpage_item,null);

        return new TodayChildAdapter.TodayChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodayChildViewHolder holder, int position) {
        if(position>0){
            final WorkOrderChild workOrderChild=workOrder.getWorkOrderChildren().get(position-1);
            holder.name.setText(workOrderChild.getNum());
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.name.getText().equals("F15-ASSET100")){
                    Intent intent=new Intent(context, DetailChildActivity.class);
                    context.startActivity(intent);
                }else{
                    Intent intent=new Intent(context, DetailParentActivity.class);
                    context.startActivity(intent);
                }

            }
        });
//        if(position==0){
//            holder.cardView.setCardBackgroundColor(Color.parseColor("#ffecdd"));
//        }

    }

    @Override
    public int getItemCount() {
        return workOrder.getWorkOrderChildren().size()+1;
    }

    public class TodayChildViewHolder extends RecyclerView.ViewHolder {

        TextView name,uname,num,time,place,remain,note;
        Button join;
        ImageView pic,more;
        CardView cardView;

        public TodayChildViewHolder(View itemView) {
            super(itemView);

            cardView=itemView.findViewById(R.id.cardView2);
            name=itemView.findViewById(R.id.cga_name);

        }
    }
}
