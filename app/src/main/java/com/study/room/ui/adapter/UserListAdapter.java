package com.study.room.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.room.R;
import com.study.room.model.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    List<User> users;

    public void setUserData(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User user = users.get(i);
        viewHolder.userName.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return users != null?users.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName  = itemView.findViewById(R.id.user_name);
        }
    }
}
