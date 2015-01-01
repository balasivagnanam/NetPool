package netpool.lab.barracks.netpool;

import android.app.ExpandableListActivity;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.parse.Parse;
import com.parse.ParseObject;

import java.util.Date;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "myewFjcTkVOAXj4lCO24ttvyUEAxpYC94U9wuCS1", "wGqCAQRtoXIueawV6vjE6nQwXChj1V3Vy6VaXroI");
        ParseObject.registerSubclass(Sessions.class);

        DataHelper dataHelper = new DataHelper();

        ExpandableListView expView = (ExpandableListView)findViewById(R.id.expandableListView);
        SessionListAdapter adapter = new SessionListAdapter(this,dataHelper.getAllDateHeaders(),dataHelper.getAllListDate());

        expView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
