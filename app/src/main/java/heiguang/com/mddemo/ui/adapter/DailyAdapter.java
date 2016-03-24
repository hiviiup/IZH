package heiguang.com.mddemo.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import heiguang.com.mddemo.R;
import heiguang.com.mddemo.bean.NewDailys;
import heiguang.com.mddemo.ui.activity.WebActivity;

/**
 * Created by hiviiup on 16/3/24.
 */
public class DailyAdapter extends BaseAdapter<NewDailys.StoriesEntity,DailyAdapter.DailyViewHolder>
{

    public DailyAdapter(Activity activity)
    {
        super(activity);
    }

    @Override
    public DailyViewHolder createMyViewHolder(ViewGroup parent, int viewType)
    {
        return new DailyViewHolder(View.inflate(mActivity, R.layout.list_item_daily,null));
    }

    @Override
    protected void bindData(DailyViewHolder dailyViewHolder, int position)
    {
        dailyViewHolder.textView.setText(getObject(position).getTitle());
        Glide.with(mActivity).load(getObject(position).getImages().get(0)).centerCrop().crossFade().into(dailyViewHolder.imageView);

        addListener(dailyViewHolder,position);
    }

    private void addListener(DailyViewHolder dailyViewHolder, final int position)
    {
        dailyViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(mActivity,WebActivity.class);
                intent.putExtra("id",getObject(position).getId());
                intent.putExtra("title",getObject(position).getTitle());
                mActivity.startActivity(intent);
            }
        });

        dailyViewHolder.relativeLayout.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                return true;
            }
        });
    }


    public class DailyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        RelativeLayout relativeLayout;
        public DailyViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            textView = (TextView) itemView.findViewById(R.id.title);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.ll);
        }
    }


}
