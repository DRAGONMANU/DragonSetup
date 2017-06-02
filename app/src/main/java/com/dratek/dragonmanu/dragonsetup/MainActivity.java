package com.dratek.dragonmanu.dragonsetup;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    public SwitchBoard switchBoard = new SwitchBoard();
    private ArrayAdapter<Appliance> mAdapter;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText room_name       = (EditText) findViewById(R.id.room_name);
        final EditText board_id     = (EditText) findViewById(R.id.boardId);

        mAdapter = new DeviceListAdapter(getApplicationContext(), switchBoard.getAttachedAppliances());

        final Button register = (Button) findViewById(R.id.button);
        Button add = (Button) findViewById(R.id.add_device);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DeviceActivity.class);
                startActivityForResult(i,10);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String roomname     = room_name.getText().toString();
                String boardid   = board_id.getText().toString();


                if (TextUtils.isEmpty(roomname)){
                    room_name.setError("Enter Room Name");
                    room_name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(boardid)){
                    board_id.setError("Enter Board ID");
                    board_id.requestFocus();
                    return;
                }
                switchBoard.setBoardID(boardid);
                switchBoard.setRoomName(roomname);



            /*  Intent registerDevice = new Intent(getApplicationContext(),DeviceActivity.class);

                registerDevice.setType("plain/text");
                registerDevice.putExtra("houseid",houseid);
                registerDevice.putExtra("roomname",roomname);
                registerDevice.putExtra("boardid",boardid);
                startActivity(Intent.createChooser(registerDevice, "Register device"));
            */
                Toast.makeText(getApplicationContext(), "Device registered successfully", Toast.LENGTH_SHORT).show();
                Log.d("Final",switchBoard.getBoardID());
                Log.d("Final",switchBoard.getHouseId());
                Log.d("Final",switchBoard.getRoomName());
                Log.d("Final",switchBoard.getAttachedAppliances().get(0).getRelayId());
                Log.d("Final",switchBoard.getAttachedAppliances().get(0).getName());
                Log.d("Final",switchBoard.getAttachedAppliances().get(0).getRating());
                Log.d("Final",switchBoard.getAttachedAppliances().get(0).getAction());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            Log.d("check","result");
            String relayid = data.getExtras().getString("relayid");
            String name = data.getExtras().getString("name");
            String power = data.getExtras().getString("power");
            String action = data.getExtras().getString("action");
            Appliance app = new Appliance(relayid,name,power,action);
            switchBoard.getAttachedAppliances().add(app);
        }
    }



    @Override
    public void onResume() {
        mListView = (ListView) findViewById(R.id.device_list);
        if (mListView != null) {
            mListView.setAdapter(mAdapter);
        }
        super.onResume();
        //Get a Tracker (should auto-report)
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
