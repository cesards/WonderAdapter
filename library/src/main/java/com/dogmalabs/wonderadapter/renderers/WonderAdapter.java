package com.dogmalabs.wonderadapter.renderers;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/**
 * Created by menor on 02/03/14.
 */
public class WonderAdapter extends BaseAdapter implements Filterable {


// UTILIZAR PATRON BUILDER E IR CONSTRUYENDO EL ADAPTER SEGUN LO QUE VENGA POR EL BUILDER....


  // mirar como está hecho el cursor adapter por dentro

  // pero primero hacer el arrayadapter


  @Override public int getCount() {
    return 0;
  }

  @Override public Object getItem(int position) {
    return null;
  }

  @Override public long getItemId(int position) {
    return 0;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    return null;
  }

  @Override public Filter getFilter() {
    return null;
  }




















  // Classes & Interfaces

  /**
   * Related to cursorAdapter
   */
  interface CursorFilterClient {
    CharSequence convertToString(Cursor cursor);

    Cursor runQueryOnBackgroundThread(CharSequence constraint);

    Cursor getCursor();

    void changeCursor(Cursor cursor);
  }

  /**
   * CursorFilter needed for CursorAdapter content
   */
  class CursorFilter extends Filter {

    CursorFilterClient client;

    CursorFilter(CursorFilterClient client) {
      this.client = client;
    }

    @Override
    public CharSequence convertResultToString(Object resultValue) {
      return client.convertToString((Cursor) resultValue);
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      Cursor cursor = client.runQueryOnBackgroundThread(constraint);

      FilterResults results = new FilterResults();
      if (cursor != null) {
        results.count = cursor.getCount();
        results.values = cursor;
      } else {
        results.count = 0;
        results.values = null;
      }
      return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      Cursor oldCursor = client.getCursor();

      if (results.values != null && results.values != oldCursor) {
        client.changeCursor((Cursor) results.values);
      }
    }
  }
}
