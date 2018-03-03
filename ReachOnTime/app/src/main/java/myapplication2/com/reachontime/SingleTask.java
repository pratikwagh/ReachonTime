package myapplication2.com.reachontime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SingleTask extends AppCompatActivity {

    private  String task_key = null;
    private TextView singletask;
    private  TextView singleTime;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        task_key = getIntent().getExtras().getString("TaskId");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Tasks");

        singletask = (TextView)findViewById(R.id.singletask);
        singleTime = (TextView)findViewById(R.id.singletime);

        mDatabase.child(task_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String task_title = (String)dataSnapshot.child("name").getValue();
                String tas_time   = (String)dataSnapshot.child("time").getValue();

                singletask.setText(task_title);
                singleTime.setText(tas_time);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
