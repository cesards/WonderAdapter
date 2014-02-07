package com.dogmalabs.wonderadapter.demo.db.provider;

import android.database.sqlite.SQLiteDatabase;
import com.dogmalabs.wonderadapter.demo.db.Contract;
import com.dogmalabs.wonderadapter.demo.db.DatabaseHelper;
import com.dogmalabs.wonderadapter.demo.db.provider.base.BaseContract;
import com.dogmalabs.wonderadapter.demo.db.provider.base.DespicableContentProvider;
import com.dogmalabs.wonderadapter.demo.db.provider.base.SimpleMinionContentProvider;
/**
 * This class creates a data base and add all minions
 */
public class WonderContentProvider extends DespicableContentProvider {

  private static SQLiteDatabase db;

  @Override
  public void recruitMinions() {
    addMinion(new SimpleMinionContentProvider(Contract.Cursor.Wonders.PATH_DIR, Contract.Db.Wonder.TABLE, Contract.getContentType(getContext(), true)));
  }

  @Override public String getAuthority() {
    return BaseContract.getAuthority(getContext());
  }

  @Override public SQLiteDatabase getDb() {
    // Open the database.
    if (db == null) {
      db = new DatabaseHelper(getContext()).getReadableDatabase();
    }
    return db;
  }
}
