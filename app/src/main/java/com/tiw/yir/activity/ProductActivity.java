package com.tiw.yir.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.adapter.MagazineProductAdapter;
import com.tiw.yir.adapter.NotebookProductAdapter;
import com.tiw.yir.adapter.StationaryProductAdapter;
import com.tiw.yir.model.MagazineProductModal;
import com.tiw.yir.model.NotebookProductModal;
import com.tiw.yir.model.StationaryProductModal;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    RecyclerView magazine_rv,notebook_rv,stationary_rv;
    TextView buy_magazines,buy_notebook,buy_stationary;
    ImageView back_btn;
    List<MagazineProductModal> magazineProductModalList = new ArrayList<>();
    Activity context;

    List<NotebookProductModal> notebookProductModalList = new ArrayList<>();
    List<StationaryProductModal> stationaryProductModalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product);

        inIt();
    }

    private void inIt() {
        MagazineProductModal modal = new MagazineProductModal();
        modal.setMagazine_title("Today,I am Grateful");
        for (int i = 0; i < 6; i++) {
            magazineProductModalList.add(modal);
        }

        NotebookProductModal notebookProductModal = new NotebookProductModal();
        notebookProductModal.setNotebook_title("Colorful Notebook");
        for (int i = 0; i < 6; i++) {
            notebookProductModalList.add(notebookProductModal);
        }

        StationaryProductModal stationaryProductModal = new StationaryProductModal();
        stationaryProductModal.setStationary_title("Sketch Pens");
        for (int i = 0; i < 6; i++) {
            stationaryProductModalList.add(stationaryProductModal);
        }

        magazine_rv = findViewById(R.id.magzines_rv);
        notebook_rv = findViewById(R.id.notebooks_rv);
        stationary_rv = findViewById(R.id.stationary_rv);

        /// Magazine RecyclerView
        MagazineProductAdapter adapter = new MagazineProductAdapter(magazineProductModalList,context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        magazine_rv.setLayoutManager(layoutManager);
        magazine_rv.setAdapter(adapter);

        /// Notebook RecyclerView

        NotebookProductAdapter notebook_adapter = new NotebookProductAdapter(notebookProductModalList,context);
        LinearLayoutManager notebook_layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        notebook_rv.setLayoutManager(notebook_layoutManager);
        notebook_rv.setAdapter(notebook_adapter);

        //Stationary RecycView

        StationaryProductAdapter stationary_adapter = new StationaryProductAdapter(stationaryProductModalList,context);
        LinearLayoutManager stationary_layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        stationary_rv.setLayoutManager(stationary_layoutManager);
        stationary_rv.setAdapter(stationary_adapter);


        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProductActivity.this,MainActivity.class);
            }
        });
    }


}