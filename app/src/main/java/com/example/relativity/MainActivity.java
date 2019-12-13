package com.example.relativity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {


    LineGraphSeries<DataPoint> series1;
    LineGraphSeries<DataPoint> series2;
    LineGraphSeries<DataPoint> series3;
    LineGraphSeries<DataPoint> series4;
    LineGraphSeries<DataPoint> series5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        double ta,tb,x,lax,lat,lbx,lbt,c,u,v;

        x = 0;
        c = 300000000;
        u = 999999;
        v = 777777;


        GraphView graph = (GraphView) findViewById(R.id.relativitygraph);
        series1 = new LineGraphSeries<DataPoint>();
        series2 = new LineGraphSeries<DataPoint>();


        for(int i = 0; i<500; i++){
            x = x + 0.1;
            ta = x/u;
            tb = x/v;
            lax = ((x-u*ta)/(Math.sqrt(1-u*u/((c*c)))));
            lat = ((ta-(u/c*c)*x)/(Math.sqrt(1-u*u/((c*c)))));
            lbx = ((x-v*tb)/(Math.sqrt(1-v*v/((c*c)))));
            lbt = ((tb-(v/c*c)*x)/(Math.sqrt(1-v*v/((c*c)))));

            series1.appendData(new DataPoint(x, ta), true, 500);
            series2.appendData(new DataPoint(x, tb), true, 500);



        }
        graph.addSeries(series1);
        graph.addSeries(series2);





        GraphView lorentz = (GraphView) findViewById(R.id.lorentzgraph);
        series3 = new LineGraphSeries<DataPoint>();
        series4 = new LineGraphSeries<DataPoint>();

        x = 0;

        for(int i = 0; i<500; i++){
            x = x + 0.1;
            ta = x/u;
            tb = x/v;
            lax = ((x-u*ta)/(Math.sqrt(1-u*u/((c*c)))));
            lat = ((ta-(u/c*c)*x)/(Math.sqrt(1-u*u/((c*c)))));
            lbx = ((x-v*tb)/(Math.sqrt(1-v*v/((c*c)))));
            lbt = ((tb-(v/c*c)*x)/(Math.sqrt(1-u*u/((c*c)))));

            series3.appendData(new DataPoint(x, lat), true, 500);
            series4.appendData(new DataPoint(x, lbt), true, 500);



        }
        lorentz.addSeries(series3);
        lorentz.addSeries(series4);


    }
}
