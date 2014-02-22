WonderAdapter
============

How many times do you copy ArrayAdapter, CursorAdapter and ViewHolders code? I've developed this library based mostly on
the idea of [UniversalAdapter][1] library, but I've implemented a few improvements like ViewHolder pattern, multi view
and cursor compatibility.

Screenshots
-----------

![Demo Screenshot][3]

Usage
-----

You just have to use the adapter that fits better to your needs. For now, there are only 3 wonder adapters you can use:

* WSingleArrayAdapter
* WMultiArrayAdapter
* WCursorAdapter

Steps to use any of these adapters within a ListView:

1. Create Custom ```Holder``` and let implement ```SingleWonder, MultiWonder or CursorWonder``` depending on the Adapter
we want to use with.
..* ```T``` is the class of the item we want to show.
..* ```W``` the Holder class.
2. Basic methods to implement (on single views):
..* ```W newInstance()``` returns an instance of ```W```(holder) for every row in the list. Our holder contains row view fields initialized.
..* ```void bind(...)``` needed to draw desired object fields on the initialized view fields contained inside our class ```W```.
..* ```View inflateView(...)``` needs explanation? :-).

__Example: ListView with array list of items within a single row view__
```java
WSingleArrayAdapter<Wonder, SingleViewHolder> adapter = new WSingleArrayAdapter(this, getData(cursor), new SingleViewHolder());
listView.setAdapter(adapter);
```
and our SingleViewHolder implementation:
```java
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

```
I've used [Jake Wharton's][6] [Butterknife][5] library to avoid using findViewById on every view in our row layout :-)


[Check][2] the code for full demo samples.


Download
--------
Not yet.

Download [the latest JAR][4] or grab via Maven:
```xml
<! -- Coming soon -->
```
or Gradle:
```groovy
# Coming soon
```

TODO'S
--------
* CursorAdapter with multiple views support
* My ```WMultiArrayAdapter``` extends Object for a reason. It's very possible to draw our headers from
another list (having two separated array lists or more, depending the number of custom view rows we would like to use)
I can discuss whether use Generics or Object...
* I have to study carefully how to interact with other libraries, like [StickyListHeaders][7], [pinned-section-listview][8] and other multi view ones.


Developed By
------------

* César Díez Sánchez - <cesaryomismo@gmail.com>

<a href="https://twitter.com/menorking">
  <img alt="Follow me on Twitter" src="http://imageshack.us/a/img812/3923/smallth.png" />
</a>
<a href="https://plus.google.com/115273462230054581675">
  <img alt="Follow me on Google Plus" src="http://imageshack.us/a/img203/4712/smallg.png" />
</a>
<a href="http://www.linkedin.com/in/cesardiezsanchez">
  <img alt="Add me to Linkedin" src="http://imageshack.us/a/img41/7877/smallld.png" />
</a>


License
-------

    Copyright 2014 DogmaLabs

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



[1]: https://github.com/yDelouis/UniversalAdapter
[2]: https://github.com/m3n0R/WonderAdapters/tree/master/demo/src/main/java/com/dogmalabs/wonderadapter/demo/ui
[3]: https://raw.github.com/m3n0R/WonderAdapter/master/art/screen_demo_1.png
[5]: https://github.com/JakeWharton/butterknife
[6]: https://github.com/JakeWharton
[7]: https://github.com/emilsjolander/StickyListHeaders
[8]: https://github.com/beworker/pinned-section-listview