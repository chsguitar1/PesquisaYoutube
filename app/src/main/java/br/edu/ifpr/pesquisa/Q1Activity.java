package br.edu.ifpr.pesquisa;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.yarolegovich.lovelydialog.LovelyTextInputDialog;

import net.qiujuer.genius.ui.widget.Button;
import net.qiujuer.genius.ui.widget.CheckBox;

import java.util.List;

import br.edu.ifpr.pesquisa.model.Perguntas;
import br.edu.ifpr.pesquisa.model.Pesquisa;
import br.edu.ifpr.pesquisa.model.Resposta;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Q1Activity extends AppCompatActivity {

    @BindView(R.id.tv_q1)
    TextView tvQ1;
    @BindView(R.id.ch_2)
    CheckBox ch2;
    @BindView(R.id.ch_1)
    CheckBox ch1;
    @BindView(R.id.tv_r1)
    TextView tvR1;
    @BindView(R.id.tv_r2)
    TextView tvR2;
    @BindView(R.id.ch_4)
    CheckBox ch4;
    @BindView(R.id.ch_3)
    CheckBox ch3;
    @BindView(R.id.tv_r4)
    TextView tvR4;
    @BindView(R.id.tv_r3)
    TextView tvR3;
    @BindView(R.id.bt_go)
    Button btGo;
    Resposta resposta;
    List<Perguntas> perguntasList;
    int indice = 0;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        ButterKnife.bind(this);
        perguntasList = BancoQuestoes.getBancoQuestoes(A.DISCIPLINA);
        this.setTitle("Pesquisa "+A.DISCIPLINA.toUpperCase());
        if(indice == 0){
            setQuestao(indice);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add("salva").setIcon(R.drawable.ic_send_white_36dp).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        this.menu = menu;
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getTitle().equals("salva")) {
          finalizaPesquisa();

            return true;
        }
        return false;
    }
    void setQuestao(int indice){
        resposta = new Resposta();
        System.out.println("indice"+ indice);
        tvQ1.setText(perguntasList.get(indice).getTitulo());
        tvR1.setText(perguntasList.get(indice).getQuestoes()[0]);
        tvR2.setText(perguntasList.get(indice).getQuestoes()[1]);
        if(perguntasList.get(indice).getQuestoes().length >= 3){
            tvR3.setText(perguntasList.get(indice).getQuestoes()[2]);
        }else{
            ch3.setVisibility(View.GONE);
            tvR3.setVisibility(View.GONE);
        }
        if(perguntasList.get(indice).getQuestoes().length == 4){
            tvR4.setText(perguntasList.get(indice).getQuestoes()[3]);
        }else{
            ch4.setVisibility(View.GONE);
            tvR4.setVisibility(View.GONE);
        }
    }
    @OnClick({R.id.ch_2, R.id.ch_1, R.id.ch_4, R.id.ch_3, R.id.bt_go})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.ch_2:

                ch1.setChecked(false);
                ch3.setChecked(false);
                ch4.setChecked(false);
                resposta.setResposta(tvR2.getText().toString());
                break;
            case R.id.ch_1:

                ch2.setChecked(false);
                ch3.setChecked(false);
                ch4.setChecked(false);
                resposta.setResposta(tvR1.getText().toString());

                break;
            case R.id.ch_4:

                ch1.setChecked(false);
                ch3.setChecked(false);
                ch2.setChecked(false);
                resposta.setResposta(tvR4.getText().toString());

                break;
            case R.id.ch_3:

                ch1.setChecked(false);
                ch2.setChecked(false);
                ch4.setChecked(false);
                resposta.setResposta(tvR3.getText().toString());

                break;
            case R.id.bt_go:
                ch1.setChecked(false);
                ch3.setChecked(false);
                ch4.setChecked(false);
                ch2.setChecked(false);
                ch3.setVisibility(View.VISIBLE);
                ch4.setVisibility(View.VISIBLE);
                tvR3.setVisibility(View.VISIBLE);
                tvR4.setVisibility(View.VISIBLE);
                resposta.setCodigoPesquisa(A.CODIGO_PESQUISA);
                resposta.setTitulo(tvQ1.getText().toString());
                resposta.save();
                if(indice == 4 || indice == 5){
                    if(resposta.getResposta().equals("Não")){
                    reiniciaPesquisa();

                    }else{
                        indice++;
                        setQuestao(indice);
                    }
                }else{
                    indice++;
                    System.out.println("val = "+ indice+" "+ perguntasList.size()  );
                    if(indice < perguntasList.size()) {
                        setQuestao(indice);

                    }else{
                        reiniciaPesquisa();
                    }

                }
                break;
        }
    }

    private void reiniciaPesquisa() {
        indice = 0;
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("Obrigado por respopnder nossa pesquisa!!!");
        alerta.setCancelable(false);

        alerta.setPositiveButton("Próxima entrevista", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               setQuestao(indice);
            }
        });

        alerta.create();
        alerta.show();
    }

    void finalizaPesquisa(){
        new LovelyTextInputDialog(this)
                .setTopColorRes(R.color.green_900)
                .setMessage("Instituto federal")
                .setIconTintColor(R.color.red_900)
                .setInputType(InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .setTitle("Senha para finalizar a pesquisa")
                .setConfirmButton(android.R.string.ok, new LovelyTextInputDialog.OnTextInputConfirmListener() {
                    @Override
                    public void onTextInputConfirmed(String text) {
                       Pesquisa p = Select.from(Pesquisa.class)
                               .where(Condition.prop("codigo").eq(MySugar.queryMax(Pesquisa.class,"codigo",Q1Activity.this)))
                               .list()
                               .get(0);
                            p.setStatus(true);
                            p.save();
                            Intent it = new Intent( Q1Activity.this, PerguntaActivity.class);
                            startActivity(it);
                            finish();
                        }
                    })

            .show();
    }
}
