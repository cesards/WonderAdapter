/*
 * Copyright 2014 DogmaLabs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dogmalabs.wonderadapter.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dogmalabs.wonderadapter.CursorWonder;

public class WCursorAdapter<W extends CursorWonder<W>> extends CursorAdapter {

  // Controller/logic fields
  private W wonder;
  private LayoutInflater inflater;

  // Constructors
  public WCursorAdapter(Context context, W wonder) {
    super(context, null, false);
    init(context, wonder);
  }

  /**
   * 0 prevents the CursorAdapter from doing its own observing of the Cursor,
   * which is not needed since when a change happens you will get a new Cursor
   * throw another call here.
   */
  public WCursorAdapter(Context context, Cursor c, W wonder) {
    super(context, c, 0);
    init(context, wonder);
  }

  private void init(Context context, W wonder) {
    this.wonder = wonder;
    inflater = LayoutInflater.from(context);
  }

  @Override
  public void bindView(View view, Context context, Cursor cursor) {
    final W w = (W) view.getTag();
    w.bind(context, cursor);
  }

  @Override
  public View newView(Context context, Cursor cursor, ViewGroup parent) {
    final W w = wonder.newInstance();
    View convertView = w.inflate(inflater, parent);
    convertView.setTag(w);
    return convertView;
  }
}
