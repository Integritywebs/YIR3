package com.tiw.yir.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiw.yir.R;
import com.tiw.yir.adapter.SelectedStudentAdapter;
import com.tiw.yir.model.SelectedStudentModal;

import java.util.ArrayList;
import java.util.List;

public class ElectedStudentsFragment extends Fragment {

    RecyclerView electedStudent_rv;
    List<SelectedStudentModal> studentModals = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SelectedStudentModal modal = new SelectedStudentModal();
        modal.setName("Sanjay Kapoor");
        modal.setMobile("+91 8866000015");
        modal.setGroup("MS Group");
        for (int i = 0; i < 5; i++) {
            studentModals.add(modal);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_elected_students, container, false);
        electedStudent_rv = view.findViewById(R.id.elected_students_rv);



        return view;
    }
}