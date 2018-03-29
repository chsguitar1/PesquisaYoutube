package br.edu.ifpr.pesquisa;

import android.content.Context;
import android.util.Log;

import com.yarolegovich.lovelydialog.LovelyInfoDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cristiano on 26/03/18.
 */

public abstract class A {
        public static String DISCIPLINA = "";
        public static  Integer CODIGO_PESQUISA;
        public static void showMsg(String msg, Context ctx){
                new LovelyInfoDialog(ctx)
                        .setTopColorRes(R.color.colorPrimary)
                        .setTitle(R.string.app_name)
                        .setMessage(msg)
                        .show();

        }
        public static String dataParaString(Date data) {
                try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        return sdf.format(data);
                } catch (Exception e) {
                        Log.e("afaLog","Houve um problema ao obter uma data (data para string)"+e.getMessage());
                        return null;
                }
        }
}
