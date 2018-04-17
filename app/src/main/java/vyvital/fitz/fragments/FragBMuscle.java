package vyvital.fitz.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import vyvital.fitz.R;
import vyvital.fitz.data.ExerciseAdapter;
import vyvital.fitz.data.models.Muscle;


public class FragBMuscle extends Fragment {

    int pic;
    String trans;
    int img;
    RecyclerView exerciseRV;
    Muscle muscle;

    public FragBMuscle() {
        // Required empty public constructor
    }

    public static FragBMuscle newInstance() {
        return new FragBMuscle();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
        if (getArguments() != null) {
            pic = getArguments().getInt("PIC");
            trans = getArguments().getString("TRANS");
            muscle = getArguments().getParcelable("MUSCLE");
            img = getArguments().getInt("PHOTO");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_muscle_b, container, false);
        exerciseRV = view.findViewById(R.id.exerciseRV);
        exerciseRV.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        exerciseRV.setLayoutManager(mLayoutManager);
        //Toast.makeText(getContext(), muscle.getName() + muscle.getExercises().get(0).getName(), Toast.LENGTH_SHORT).show();
        exerciseRV.setAdapter(new ExerciseAdapter(getActivity(),muscle.getExercises(),img));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView image = getView().findViewById(R.id.fragment_b_image);
        image.setImageResource(pic);
        image.setTransitionName(trans);

    }
 
}