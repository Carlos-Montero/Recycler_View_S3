package com.example.carlos.tutorial_s3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //*****************PODEMOS DECLARAR NUESTRO DATASET AQUÍ*****************
    private String[]myDataset;
    private String[] cargarDatos()
    {
        String[] array = new String[10];
        array[0] = "Carlos";
        array[1] = "Victor";
        array[2] = "Alvaro";
        array[3] = "Ruben";
        array[4] = "Marta";
        array[5] = "Laura";
        array[6] = "Roger";
        array[7] = "Xavi";
        array[8] = "Javi";
        array[9] = "Maria";
        return array;
    }
    //************************************************************************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        //LLAMAMOS A LA FUNCION PARA QUE NOS CARGUE LOS VALORES
        myDataset = cargarDatos();
        mAdapter = new MyAdapter(myDataset);      //HABRA QUE CREAR LA CLASE MyAdpater  y   myDataset es lo que le pasaremos
        mRecyclerView.setAdapter(mAdapter);
    }
// ...
}


//*********************AQUI COPIAMOS LA CLASE MyAdapter****************************
//******************TMABIEN PODRIAMOS CREAR LA CLASE EN UN .JAVA SEPARADO**********
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;
    // Provide a reference to the views for each data item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public MyViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {



        //***********************************************************************************************************************+
        //AQUI CREAMOS OTRO LAYOUT LLAMADO my_text_view, QUE SERÁ CADA UNO DE LOS ELEMENTOS VIEWHOLDER DEL RECYCLERVIEW
        // ************************************************************************************************************************
// create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
//...
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    //************************************************************************************************************************
    //************************************************************************************************************************





    //************************************************************************************************************************
    //AQUI ES DONDE VAMOS RELLENANDO CON NUETROS DATOS, AQUI ES DONDE SE CARGAN STRINGS, IMAGES, ETC
    //************************************************************************************************************************

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
// - get element from your dataset at this position
// - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
    //************************************************************************************************************************
    //************************************************************************************************************************