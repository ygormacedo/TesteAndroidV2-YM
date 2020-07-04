package com.ygorfx1.dev.android.testeandroidv2ym.statementScreen;

import com.ygorfx1.dev.android.testeandroidv2ym.models.Statement;

import java.util.List;

public interface StatementInteractor {

    interface View {

        void receiveListStatement(List<Statement> listStatement);

        void loadError(int message);
    }

    interface Presenter {

        void getListStatement(int id);

    }
}
