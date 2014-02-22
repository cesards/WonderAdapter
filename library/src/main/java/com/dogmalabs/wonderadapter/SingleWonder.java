package com.dogmalabs.wonderadapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by menor on 22/02/14.
 */
public interface SingleWonder<T, W extends SingleWonder<T, W>> {

  public W newInstance();

  public void bind(Context context, T item);

  public View inflateView(LayoutInflater inflater, ViewGroup parent);

}
