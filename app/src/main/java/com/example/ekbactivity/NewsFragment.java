package com.example.ekbactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


public class NewsFragment extends Fragment {
    private ImageView imageView;
    private ArrayList<News> newsArr = new ArrayList<>();
    private RecyclerView recyclerView;


    //Объявление переменной для того, связать фрагмент и активити
    private OnFragmentInteractionListener mListener;

    public NewsFragment() {
        // Required empty public constructor
    }

    //Создаем объект нашего фрагмента (заметь, что метод возвращает именно созданный фрагмент)
    //??? что такое newInstance
    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }


    //Стандартный метод, вызывается когда фрагмент прикрепляется к активити
    //Здесь Context context - является нашей MainActivity, (Context пра-прадедушка MainActivity)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Так как MainActivity реализует OnFragmentInteractionListener, мы можем
        // переменной mListener присвоить MainActivity
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    //Стандартный метод для того чтобы создать view (у нас здесь создается из R.layout.recycler_view_row_news)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


    }



    //Стандартный метод для того чтобы найти кнопки, текста и др. из уже созданной View
    //Параметр View view - это корневой элемент в R.layout.fragment_fragment1 (в данном случае FrameLayout)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

    }

    private void init(View view){
        imageView = view.findViewById(R.id.news_box_img);

        newsArr.add(new News(R.drawable.news_box_img2));
        newsArr.add(new News(R.drawable.news_box_img2));
        newsArr.add(new News(R.drawable.box_img));

        recyclerView = view.findViewById(R.id.recycler_news);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(newsArr, getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
    }





    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //Интерфейс для того, связать фрагмент и активити

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onNewsFragmentInteraction();
    }
}







