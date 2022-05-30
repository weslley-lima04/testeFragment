package com.example.testefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.testefragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        callFragment(new Home_Fragment()); //torna home a tela padrão de inicialização

        /*quando o usuário selecionar qualquer item, pegamos o item na variável "item" */
        binding.btmNavigation.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
               case R.id.home:
                   callFragment(new Home_Fragment());
                    break;
                case R.id.contatos:
                    callFragment(new Contatos_Fragment());
                    break;
                case R.id.config:
                    callFragment(new Config_Fragment()); //aqui estamos gerando um novo objeto da classe
                    break;

            }

            return true;

        });

    }

    private void callFragment(Fragment fragment)
    {
        //fragment manager auxilia a gerenciar fragmentos. essa primeira linha sempre existe, junto com a de baixo
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); //Transaction permite transita entre fragmentos. também sempre existe
        fragmentTransaction.replace(R.id.Frame1, fragment); //substituindo o frame layout pelo fragment
        fragmentTransaction.commit();

    /*o frame layout da main será substituído pela fragment*/
    }


}