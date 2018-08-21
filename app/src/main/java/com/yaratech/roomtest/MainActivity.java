package com.yaratech.roomtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.yaratech.roomtest.data.AppDatabase;
import com.yaratech.roomtest.data.table.Comment;
import com.yaratech.roomtest.data.table.Post;
import com.yaratech.roomtest.data.table.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<Comment> cmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = findViewById(R.id.first_query);
        final TextView result1 = findViewById(R.id.second_query);

        final AppDatabase myApp = AppDatabase.getAppDatabase(getApplicationContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                populateWithTestData(myApp);
                result.setText(cmList.get(0).getUserName() + "\n" + cmList.get(0).getCommentText());
                //result1.setText(cmList.get(1).getUserName() + "\n" + cmList.get(1).getCommentText());
            }
        }).start();
    }

    private static void populateWithTestData(AppDatabase db) {
        User user1 = new User("mahshid", "ganjeh", 123, "mag.jpg");
        User user2 = new User("arezoo", "nazer", 122, "an.jpg");

        db.userDao().insertUser(user1);
        db.userDao().insertUser(user2);

        Post post1 = new Post(1, "post1", "this is post 1", "f");
        db.postDao().insertPost(post1);

        Comment cm1 = new Comment(1, 1, "ali", "nice");
        Comment cm2 = new Comment(1, 2, "mahsa", "thanks");
        db.commentDao().insertComment(cm1);
        db.commentDao().insertComment(cm2);

        cmList = db.commentDao().getCommentOfUser(2);

        Log.d("user" , db.commentDao().getUsers(1).get(0));
        Log.d("user" , db.commentDao().getUsers(1).get(1));
    }
}
