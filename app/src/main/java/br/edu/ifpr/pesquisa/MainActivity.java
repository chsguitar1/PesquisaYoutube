package br.edu.ifpr.pesquisa;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static br.edu.ifpr.pesquisa.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.edlogin)
    TextInputEditText edLogin;
    @BindView(R.id.edsenha)
    TextInputEditText edSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.bt_login)
    void login(){
        if(edLogin.getText().toString().equals("ifpr") && edSenha.getText().toString().equals("ifpr2018") ){
            Intent it = new Intent(this,PerguntaActivity.class);
            startActivity(it);
            finish();
        }else{
            A.showMsg("Usuário ou senha inválidos",this);
        }
    }
}
