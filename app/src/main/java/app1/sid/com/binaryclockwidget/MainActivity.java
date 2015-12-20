package app1.sid.com.binaryclockwidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.os.PowerManager;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppWidgetProvider {

    private int color_block,color_block2 ;
    public RemoteViews views;
    public int sec,min,hou ;
    Timer timer;
    boolean running;


    public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {
        ComponentName thisWidget = new ComponentName(context,
                MainActivity.class);



        for (int widgetId : appWidgetManager.getAppWidgetIds(thisWidget)) {


            //Get the remote views
            views = new RemoteViews(context.getPackageName(),
                    R.layout.activity_main);
            // Set the text with the current time.
            setColor_block();
            timeGet();
            methodHH(String.valueOf(hou));
            methodMM(String.valueOf(min));
            methodSS(String.valueOf(sec));
            Log.e("Tick", "tick");
            appWidgetManager.updateAppWidget(widgetId, views);
            startTimer(context);


        }



    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Toast.makeText(context, "TimeWidgetRemoved id(s):"+appWidgetIds, Toast.LENGTH_SHORT).show();
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);

        running = false;
        Toast.makeText(context,"Disabled Timer!",Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
      /*  AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        //After after 3 seconds
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ 1000 , 1000 , pi);*/
        running = true;

    }




    private void startTimer( final Context context) {




        TimerTask minuteTask = new TimerTask() {

            @Override
            public void run() {


                    PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
                    PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
                    //Acquire the lock
                    wl.acquire();

                    //You can do the processing here update the widget/remote views.
                    views = new RemoteViews(context.getPackageName(),
                            R.layout.activity_main);
                    timeGet();
                    methodHH(String.valueOf(hou));
                    methodMM(String.valueOf(min));
                    methodSS(String.valueOf(sec));
                    Log.e("Tick", "tick");

                    ComponentName thiswidget = new ComponentName(context, MainActivity.class);
                    AppWidgetManager manager = AppWidgetManager.getInstance(context);
                    manager.updateAppWidget(thiswidget, views);
                    //Release the lock
                    wl.release();



            }
        };

        timer = new Timer();

        // schedule the task to run starting now and then every minute
        timer.scheduleAtFixedRate(minuteTask, 0l, 1000 );


    }

    public void methodSS(String s) {
        String h1,h2;

        if(s.length() == 2) {
            h1 =s.substring(0,1);
            h2 =s.substring(1);
        }
        else
        {
            h1 ="0";
            h2 =s.substring(0);
        }
        int h1_int,h2_int;

        h1_int = Integer.parseInt(h1);
        h2_int = Integer.parseInt(h2);
        Log.e("values1:",String.valueOf(h1_int));
        Log.e("values2:",String.valueOf(h2_int));
        switch(h1_int)
        {
            case 0:
                // img30.setBackgroundColor(color_block);
                // img20.setBackgroundColor(color_block);
                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block);
                views.setInt(R.id.img24, "setBackgroundColor", color_block);
                views.setInt(R.id.img34, "setBackgroundColor", color_block);
                break;
            case 1:

                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block);
                views.setInt(R.id.img24, "setBackgroundColor", color_block);
                views.setInt(R.id.img34, "setBackgroundColor", color_block2);
                break;
            case 2:
                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block);
                views.setInt(R.id.img24, "setBackgroundColor", color_block2);
                views.setInt(R.id.img34, "setBackgroundColor", color_block);
                break;
            case 3:

                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block);
                views.setInt(R.id.img24, "setBackgroundColor", color_block2);
                views.setInt(R.id.img34, "setBackgroundColor", color_block2);
                break;
            case 4:
                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block2);
                views.setInt(R.id.img24, "setBackgroundColor", color_block);
                views.setInt(R.id.img34, "setBackgroundColor", color_block);
                break;
            case 5:
                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block2);
                views.setInt(R.id.img24, "setBackgroundColor", color_block);
                views.setInt(R.id.img34, "setBackgroundColor", color_block2);
                break;
            case 6:
                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block2);
                views.setInt(R.id.img24, "setBackgroundColor", color_block2);
                views.setInt(R.id.img34, "setBackgroundColor", color_block);
                break;
            case 7:
                views.setInt(R.id.img04, "setBackgroundColor", color_block);
                views.setInt(R.id.img14, "setBackgroundColor", color_block2);
                views.setInt(R.id.img24, "setBackgroundColor", color_block2);
                views.setInt(R.id.img34, "setBackgroundColor", color_block2);
                break;
            case 8:
                views.setInt(R.id.img04, "setBackgroundColor", color_block2);
                views.setInt(R.id.img14, "setBackgroundColor", color_block);
                views.setInt(R.id.img24, "setBackgroundColor", color_block);
                views.setInt(R.id.img34, "setBackgroundColor", color_block);
                break;
            case 9:
                views.setInt(R.id.img04, "setBackgroundColor", color_block2);
                views.setInt(R.id.img14, "setBackgroundColor", color_block);
                views.setInt(R.id.img24, "setBackgroundColor", color_block);
                views.setInt(R.id.img34, "setBackgroundColor", color_block2);
                break;



        }

        switch(h2_int)
        {
            case 0:
                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block);
                views.setInt(R.id.img25, "setBackgroundColor", color_block);
                views.setInt(R.id.img35, "setBackgroundColor", color_block);
                break;
            case 1:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block);
                views.setInt(R.id.img25, "setBackgroundColor", color_block);
                views.setInt(R.id.img35, "setBackgroundColor", color_block2);
                break;
            case 2:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block);
                views.setInt(R.id.img25, "setBackgroundColor", color_block2);
                views.setInt(R.id.img35, "setBackgroundColor", color_block);
                break;
            case 3:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block);
                views.setInt(R.id.img25, "setBackgroundColor", color_block2);
                views.setInt(R.id.img35, "setBackgroundColor", color_block2);
                break;
            case 4:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block2);
                views.setInt(R.id.img25, "setBackgroundColor", color_block);
                views.setInt(R.id.img35, "setBackgroundColor", color_block);
                break;
            case 5:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block2);
                views.setInt(R.id.img25, "setBackgroundColor", color_block);
                views.setInt(R.id.img35, "setBackgroundColor", color_block2);
                break;
            case 6:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block2);
                views.setInt(R.id.img25, "setBackgroundColor", color_block2);
                views.setInt(R.id.img35, "setBackgroundColor", color_block);
                break;
            case 7:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block);
                views.setInt(R.id.img15, "setBackgroundColor", color_block2);
                views.setInt(R.id.img25, "setBackgroundColor", color_block2);
                views.setInt(R.id.img35, "setBackgroundColor", color_block2);
                break;
            case 8:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block2);
                views.setInt(R.id.img15, "setBackgroundColor", color_block);
                views.setInt(R.id.img25, "setBackgroundColor", color_block);
                views.setInt(R.id.img35, "setBackgroundColor", color_block);
                break;
            case 9:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img05, "setBackgroundColor", color_block2);
                views.setInt(R.id.img15, "setBackgroundColor", color_block);
                views.setInt(R.id.img25, "setBackgroundColor", color_block);
                views.setInt(R.id.img35, "setBackgroundColor", color_block2);
                break;


        }
    }

    public void methodMM(String s) {
        String h1,h2;

        if(s.length() == 2) {
            h1 =s.substring(0,1);
            h2 =s.substring(1);
        }
        else
        {
            h1 ="0";
            h2 =s.substring(0);
        }
        int h1_int,h2_int;

        h1_int = Integer.parseInt(h1);
        h2_int = Integer.parseInt(h2);
        Log.e("values1:",String.valueOf(h1_int));
        Log.e("values2:",String.valueOf(h2_int));
        switch(h1_int)
        {
            case 0:
                // img30.setBackgroundColor(color_block);
                // img20.setBackgroundColor(color_block);
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 1:

                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 2:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 3:

                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 4:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 5:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 6:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 7:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 8:
                views.setInt(R.id.img02, "setBackgroundColor", color_block2);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 9:
                views.setInt(R.id.img02, "setBackgroundColor", color_block2);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;



        }

        switch(h2_int)
        {
            case 0:
                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 1:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 2:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 3:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 4:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 5:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 6:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 7:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 8:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block2);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 9:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block2);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;


        }
    }


    public void methodHH(String s) {
        String h1,h2;

        if(s.length() == 2) {
            h1 =s.substring(0,1);
            h2 =s.substring(1);
        }
        else
        {
            h1 ="0";
            h2 =s.substring(0);
        }
        int h1_int,h2_int;

        h1_int = Integer.parseInt(h1);
        h2_int = Integer.parseInt(h2);
        Log.e("values1:",String.valueOf(h1_int));
        Log.e("values2:",String.valueOf(h2_int));
        switch(h1_int)
        {
            case 0:
               // img30.setBackgroundColor(color_block);
               // img20.setBackgroundColor(color_block);
                views.setInt(R.id.img30, "setBackgroundColor", color_block);
                views.setInt(R.id.img20, "setBackgroundColor", color_block);
                break;
            case 1:
                //img30.setBackgroundColor(color_block2);
                //img20.setBackgroundColor(color_block);
                views.setInt(R.id.img30, "setBackgroundColor", color_block2);
                views.setInt(R.id.img20, "setBackgroundColor", color_block);
                break;
            case 2:
               // img30.setBackgroundColor(color_block);
               // img20.setBackgroundColor(color_block2);
                views.setInt(R.id.img30, "setBackgroundColor", color_block);
                views.setInt(R.id.img20, "setBackgroundColor", color_block2);
                break;

        }

        switch(h2_int)
        {
            case 0:
               /* img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 1:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 2:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 3:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 4:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 5:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 6:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 7:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 8:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block2);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 9:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block2);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;


        }
    }

    public void timeGet() {
        Calendar c = Calendar.getInstance();
        sec = c.get(Calendar.SECOND);
        min = c.get(Calendar.MINUTE);
        hou = c.get(Calendar.HOUR);
    }



    private void setColor_block() {
        color_block = Color.GRAY;
        color_block2 = Color.BLACK;
    }



}
