WonderAdapter
============

How many times do you copy ArrayAdapter, CursorAdapter and ViewHolders code? I've developed this library based mostly on
the idea of [UniversalAdapter][1] library, but I've implemented a few improvements like ViewHolder pattern and View
Injection, to be faster writing your adapters.

This library uses [ButterKnife][2] which uses annotation processing to generate code that does direct filed assignment
of your views, so __remember to enable Annotations in whatever IDE you're using__

In __IntelliJ 13__ Go to Preferences --> Compiler --> Annotation processors and check __"Enable annotation processing"__

Screenshots
-----------

![Demo Screenshot][3]

Usage
-----

```java
// TODO
```


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
[2]: https://github.com/JakeWharton/butterknife
[3]: https://raw.github.com/m3n0R/WonderAdapter/master/art/screen_demo_1.png
[4]: