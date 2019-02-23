package com.blindnews.kimh2.blindnews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder> {


    public List<BlogPost> blog_list;
    public Context context;


    public BlogRecyclerAdapter(List<BlogPost> blog_list) {
        this.blog_list = blog_list;
    }


    public void updatePosts(List<BlogPost> blogPostList) {
        //if you want to update the whole list. If you want to append, List has addAll method I think and use it with notifyItemRangeInserted for better performance.
        this.blog_list = blogPostList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_list_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            String desc_data = blog_list.get(position).getAppBody();
            String image_url = blog_list.get(position).getUrl();
            String user_id = blog_list.get(position).getAuthor();
            String time = blog_list.get(position).getDate();
            String subTitle = blog_list.get(position).getSubTitle();
            String title =  blog_list.get(position).getTitle();

            holder.setBlogImage(image_url);
            holder.setDescText(desc_data);
            holder.setAuthor(user_id);
            holder.setTime(time);
            holder.setSub(subTitle);
            holder.setTitle(title);



    }

    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private View mView;
        private TextView descView;
        private TextView authorView;
        private TextView subView;
        private TextView titleView;
        private ImageView blogImageView;
        private TextView timeView;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDescText(String descText){
            descView = mView.findViewById(R.id.blog_desc);
            descView.setText(descText);
        }

        public void setBlogImage(String downloadUri) {
            blogImageView = mView.findViewById(R.id.blog_image);
            Glide.with(context).load(downloadUri).into(blogImageView);
        }

        public void setAuthor(String author) {

            authorView = mView.findViewById(R.id.blog_user_name);
            authorView.setText(author);

        }

        public void setTime(String time) {
            timeView = mView.findViewById(R.id.blog_date);
            timeView.setText(time);
        }

        public void setSub (String sub) {
            subView = mView.findViewById(R.id.blog_subtitle);
            subView.setText(sub);
        }

        public void setTitle (String title) {
            titleView = mView.findViewById(R.id.blog_title);
            titleView.setText(title);
        }
    }
}
