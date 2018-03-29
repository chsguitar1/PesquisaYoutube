package br.edu.ifpr.pesquisa;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.opencsv.CSVWriter;
import com.orm.query.Condition;
import com.orm.query.Select;

import net.qiujuer.genius.ui.widget.Button;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

import br.edu.ifpr.pesquisa.model.Pesquisa;
import br.edu.ifpr.pesquisa.model.Resposta;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerguntaActivity extends AppCompatActivity {

    @BindView(R.id.bt_matematica)
    Button btMatematica;
    @BindView(R.id.bt_fisica)
    Button btFisica;
    @BindView(R.id.bt_biologia)
    Button btBiologia;
    @BindView(R.id.bt_portugues)
    Button btPortugues;
    List<Pesquisa> pes;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        ButterKnife.bind(this);
        verFechamento();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add("salva").setIcon(R.drawable.ic_cloud_download_white_36dp).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        this.menu = menu;
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getTitle().equals("salva")) {
            if(convertHappiness()){
                Pesquisa.deleteAll(Pesquisa.class);
                Resposta.deleteAll(Resposta.class);
            }

            return true;
        }
        return false;
    }
    private void verFechamento() {
         pes = Pesquisa.listAll(Pesquisa.class);
        System.out.println(pes.size());
        if(!pes.isEmpty()){
            final Pesquisa p = pes.get(0);
            System.out.println("STATUS PESQUISA"+ p.getStatus());
            if(p.getStatus() == false){

                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setMessage("A pesquisa anterior esta aberta!\n Escolha a opção abaixo.");
                alerta.setPositiveButton("Fechar a pesquisa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       habilitaBotoes(true);
                       A.DISCIPLINA = "";
                       A.CODIGO_PESQUISA = null;
                        Pesquisa p = Select.from(Pesquisa.class)
                                .where(Condition.prop("codigo").eq(MySugar.queryMax(Pesquisa.class,"codigo",PerguntaActivity.this)))
                                .list()
                                .get(0);
                        p.setStatus(true);
                        p.save();
                    }
                });
                alerta.setNegativeButton("Continuar a pesquisa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        novaPesquisa();
                        habilitaBotoes(true);
                    }
                });
                alerta.create();
                alerta.show();
            }else{

                habilitaBotoes(true);
            }
        }else{

            habilitaBotoes(true);
        }
    }

    private void habilitaBotoes(boolean b) {
        btBiologia.setEnabled(b);
        btFisica.setEnabled(b);
        btMatematica.setEnabled(b);
        btPortugues.setEnabled(b);
    }

    @OnClick({R.id.bt_matematica, R.id.bt_fisica, R.id.bt_biologia, R.id.bt_portugues})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_matematica:
                A.DISCIPLINA = "matematica";
                break;
            case R.id.bt_fisica:
                A.DISCIPLINA = "fisica";
                break;
            case R.id.bt_biologia:
                A.DISCIPLINA = "biologia";
                break;
            case R.id.bt_portugues:
                A.DISCIPLINA = "portugues";
                break;
        }

            novaPesquisa();

        Intent it = new Intent(this, Q1Activity.class);
        startActivity(it);
        finish();
    }
    void novaPesquisa(){
        Integer codigo = (int) MySugar.queryMax(Pesquisa.class,"codigo",this)+1;
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setData(new Date());
        pesquisa.setDisciplina(A.DISCIPLINA);
        pesquisa.setStatus(false);
        pesquisa.setCodigo(codigo);
        A.CODIGO_PESQUISA = codigo;
        pesquisa.save();
    }

    public boolean convertHappiness() {
        Pesquisa pes = Pesquisa.listAll(Pesquisa.class).get(0);
        String FILENAME = "pesquisa"+A.dataParaString(new Date())+"-"+pes.getCodigo()+".csv";
        File directoryDownload = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File logDir = new File(directoryDownload, FILENAME);
        try {
            logDir.createNewFile();
            CSVWriter csvWriter = new CSVWriter(new FileWriter(logDir));
            Cursor curCSV = MySugar.getCursor("SELECT * FROM resposta", PerguntaActivity.this);
            csvWriter.writeNext(curCSV.getColumnNames());
            while (curCSV.moveToNext()) {
                String arrStr[] = {curCSV.getString(0) + ",", curCSV.getString(1) + ",",
                        curCSV.getString(2),curCSV.getString(3) };
                csvWriter.writeNext(arrStr);
            }
            csvWriter.close();
            curCSV.close();
            return true;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
            return false;
        }
    }
}
