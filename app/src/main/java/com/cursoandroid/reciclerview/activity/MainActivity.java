package com.cursoandroid.reciclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cursoandroid.reciclerview.DisplayMessageActivity;
import com.cursoandroid.reciclerview.R;
import com.cursoandroid.reciclerview.RecyclerItemClickListener;
import com.cursoandroid.reciclerview.adapter.Adapter;
import com.cursoandroid.reciclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text.
        //TextView textView = findViewById(R.id.textView );
        //textView.setText(message);

        recyclerView =findViewById(R.id.recycleView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar Reciclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this , LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);

                                Toast.makeText(
                                     getApplicationContext(),
                                     "Item pressionado:" + filme.getTituloFilme(),
                                     Toast.LENGTH_SHORT
                             ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo:" + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }
    public void criarFilmes(){

        Filme filme = new Filme("Areia" , "Kg" , "100");
        listaFilmes.add(filme);

        filme = new Filme("Tijolo Baiano" , "Unidade" , "1000");
        listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha" , "Fantasia" , "2017");
        listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça" , "Ficção" , "2016");
        listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civíl" , "Aventura" , "2020");
        listaFilmes.add(filme);

        filme = new Filme("It: A Coisa" , "Drama/Terror" , "2021");
        listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme" , "Coméria/Animação" , "2010");
        listaFilmes.add(filme);

        filme = new Filme("A Múmia" , "Terror" , "2015");
        listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera" , "Romance" , "2014");
        listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3" , "Comédia" , "2018");
        listaFilmes.add(filme);

        filme = new Filme("Carros 3" , "Comédia" , "2012");
        listaFilmes.add(filme);

    }


}