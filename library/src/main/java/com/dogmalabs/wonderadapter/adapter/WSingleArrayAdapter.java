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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.dogmalabs.wonderadapter.SingleWonder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by menor on 22/02/14.
 */
public class WSingleArrayAdapter<T, W extends SingleWonder<T, W>> extends ArrayAdapter<T> {

  // Controller/logic fields
  private W wonder;
  private LayoutInflater inflater;
  private List<Object> data;
  protected Context context;

  // Constructors
  public WSingleArrayAdapter(Context context, T[] data, W wonder) {
    super(context, 0, data);
    init(context, wonder);
  }

  public WSingleArrayAdapter(Context context, List<T> data, W wonder) {
    super(context, 0, data);
    init(context, wonder);
  }

  private void init(Context context, W wonder) {
    this.wonder = wonder;
    inflater = LayoutInflater.from(context);
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    final W w;
    if (convertView == null) {
      w = wonder.newInstance();
      convertView = w.inflateView(inflater, parent);
      convertView.setTag(w);
    } else {
      w = (W) convertView.getTag();
    }
    w.bind(getContext(), getItem(position));
    return convertView;
  }

}
