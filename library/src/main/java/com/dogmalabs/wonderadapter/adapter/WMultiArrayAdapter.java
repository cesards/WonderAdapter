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
import android.widget.BaseAdapter;
import com.dogmalabs.wonderadapter.MultiWonder;
import java.util.List;

public class WMultiArrayAdapter<W extends MultiWonder<W>> extends BaseAdapter {

  // Controller/logic fields
  private W wonder;
  private LayoutInflater inflater;
  private List<Object> data;
  protected Context context;

  // Constructors
  public WMultiArrayAdapter(Context context, List<Object> data, W wonder) {
    this.context = context;
    this.data = data;
    this.wonder = wonder;
    inflater = LayoutInflater.from(context);
  }

  @Override public int getCount() {
    return data.size();
  }

  @Override public Object getItem(int position) {
    return data.get(position);
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemViewType(int position) {
    return wonder.getViewType(data.get(position));
  }

  /**
   * @return number of different Views the row could be
   */
  @Override public int getViewTypeCount() {
    return wonder.getViewTypeCount();
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    final W w;
    final int viewType;
    if (convertView == null) {
      viewType = getItemViewType(position);
      w = wonder.newInstance();
      convertView = w.inflateView(inflater, parent, viewType);
      convertView.setTag(w);
    } else {
      w = (W) convertView.getTag();
      viewType = getItemViewType(position);
    }
    w.bind(context, getItem(position), viewType);
    return convertView;
  }
}
