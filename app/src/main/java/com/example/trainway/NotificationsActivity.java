package com.example.trainway;
/*
This portion of code will be edited when fully implementing the functionality of the program.
The Notifications portion is highly reliant on other parts of the program to recieve information on when an event happens.
*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.CheckBox;
public class NotificationsActivity extends AppCompatActivity {
    private int msgCount, unreadMsg;
    private TextView timeText0, timeText1, timeText2, timeText3, timeText4, timeText5,
            timeText6;
    private TextView msgText0, msgText1, msgText2, msgText3, msgText4,
            msgText5, msgText6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        final CheckBox cb0Value=(CheckBox) findViewById(R.id.cb0);
        final CheckBox cb1Value=(CheckBox) findViewById(R.id.cb1);
        cb0Value.setChecked(true);
        cb1Value.setChecked(true);
        //final TextView cb0F = (TextView) findViewById(R.id.cb0);

    }
    public void checkedBox()
    {

    }
    /*
    public void newNotification()
    {

        for(int x=0; x<=msgCount; x++)
        {

        }
    }*/
}
