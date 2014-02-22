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

package com.dogmalabs.wonderadapter.demo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.dogmalabs.wonderadapter.demo.R;
import com.dogmalabs.wonderadapter.demo.model.Wonder;

/**
 * Created by cesar on 07/02/14.
 */
public abstract class BaseActivity extends FragmentActivity {

  // Views
  @InjectView(android.R.id.list) ListView listView;

  // Headers
  public abstract void setInitData();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list);
    ButterKnife.inject(this);
    setInitData();
  }

  @OnItemClick(android.R.id.list) public void onItemClick(int position) {
    Wonder wonder = (Wonder) listView.getItemAtPosition(position);
    Toast.makeText(this, wonder.getTitle(), Toast.LENGTH_SHORT).show();
  }

}
