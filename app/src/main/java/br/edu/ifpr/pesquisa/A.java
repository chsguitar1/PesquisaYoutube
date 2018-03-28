package br.edu.ifpr.pesquisa;

import android.content.Context;

import com.yarolegovich.lovelydialog.LovelyInfoDialog;

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
}
