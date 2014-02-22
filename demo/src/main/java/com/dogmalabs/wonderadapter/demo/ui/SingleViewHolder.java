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

package com.dogmalabs.wonderadapter.demo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.dogmalabs.wonderadapter.SingleWonder;
import com.dogmalabs.wonderadapter.demo.R;
import com.dogmalabs.wonderadapter.demo.model.Wonder;
import com.squareup.picasso.Picasso;

public class SingleViewHolder implements SingleWonder<Wonder, SingleViewHolder> {

  // UI
  @InjectView(R.id.row_wonder_image) ImageView imageView;
  @InjectView(R.id.row_wonder_title) TextView titleView;

  @Override public SingleViewHolder newInstance() {
    return new SingleViewHolder();
  }

  @Override public void bind(Context context, Wonder item) {
    Picasso.with(context).load(item.getImage()).into(imageView);
    titleView.setText(item.getTitle());
  }

  @Override public View inflateView(LayoutInflater inflater, ViewGroup parent) {
    View view = inflater.inflate(R.layout.row_wonder, parent, false);
    ButterKnife.inject(this, view);
    return view;
  }

}
