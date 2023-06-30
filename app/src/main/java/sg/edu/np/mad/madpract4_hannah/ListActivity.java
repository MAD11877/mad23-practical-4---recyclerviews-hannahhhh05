package sg.edu.np.mad.madpract4_hannah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    public ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Create a list of User objects
        userList = new ArrayList<>();
        Random random = new Random();
        for (int i = 2; i < 22; i++) {
            String name = "User " + random.nextInt(100000);
            String description = "Description " + random.nextInt(1000000);
            boolean followed = random.nextBoolean();
            userList.add(new User(name, description, i, followed));
        }

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        userAdpter mAdapter = new userAdpter(userList, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}