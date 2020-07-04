package com.ygorfx1.dev.android.testeandroidv2ym.statementScreen;

import com.ygorfx1.dev.android.testeandroidv2ym.R;
import com.ygorfx1.dev.android.testeandroidv2ym.models.ResponseStatement;
import com.ygorfx1.dev.android.testeandroidv2ym.network.ApiConfig;
import com.ygorfx1.dev.android.testeandroidv2ym.network.Statement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatementPresenter implements StatementInteractor.Presenter {

    private StatementInteractor.View view;

    public StatementPresenter(StatementInteractor.View view) {
        this.view = view;
    }

    @Override
    public void getListStatement(int id) {

        //Call conection to DataBase

        Statement statementClient = ApiConfig.create(Statement.class);
        Call<ResponseStatement> call = statementClient.getExtract(id);
        call.enqueue(new Callback<ResponseStatement>() {
            @Override
            public void onResponse(Call<ResponseStatement> call, Response<ResponseStatement> response) {
                ResponseStatement responseStatement = response.body();

                if (response.isSuccessful()) {
                    view.receiveListStatement(responseStatement.getStatementList());
                } else {
                    view.loadError(R.string.error_load_statement);
                }
            }

            @Override
            public void onFailure(Call<ResponseStatement> call, Throwable t) {
                view.loadError(R.string.error_load_statement);
            }
        });

    }
}
