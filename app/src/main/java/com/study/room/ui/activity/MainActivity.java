package com.study.room.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.study.room.R;
import com.study.room.database.AppDatabase;
import com.study.room.model.User;
import com.study.room.ui.adapter.UserListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    UserListAdapter userListAdapter;

    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        //addDataToDb();
        getDataFromDb();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDatabase.destroyInstance();
    }

    private void addDataToDb() {
        final AppDatabase db = AppDatabase.getAppDatabase(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User("anandu");

                //db.userDao().deleteAll();
                db.userDao().insertAll(user);
                //db.userDao().insertAll(user);

            }
        }).run();
    }

    private void getDataFromDb() {
        final AppDatabase db = AppDatabase.getAppDatabase(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User("anandu");
                db.userDao().insertAll(user);
                //db.userDao().insertAll(user);


                List<User> users = db.userDao().getUsers();
                if(null != users){
                    setDataToRecyclerView(users);
                }
            }
        }).run();
    }

    private void initUi() {
        rvList = findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        userListAdapter = new UserListAdapter();
        rvList.setAdapter(userListAdapter);
    }

    private void setDataToRecyclerView(List<User>users){
        if(null != userListAdapter){
            userListAdapter.setUserData(users);
        }
    }
}
