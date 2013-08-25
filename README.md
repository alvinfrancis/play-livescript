play-livescript
===============

Rudimentary [livescript] [1] asset handling for [Play 2.1.x] [2], implemented as an [sbt] [3]
plugin (very similar to Play's handling of CoffeeScript and LESS), working very similarly to [play-stylus] [4] (from which it is in fact forked).

Prerequisites
-------------

The plugin assumes the availability of the `livescript` executable. With
node.js and npm installed, run

    npm install -g livescript

to install livescript globally.

How to Use
----------

A fake Maven repository is now available on github for easier installation. Add the following to your `plugins.sbt`:

```scala
resolvers += "12foo github/maven" at "https://github.com/12foo/mvnrepo/raw/master/releases/"

addSbtPlugin("com.github.otfoo" % "play-livescript" % "0.1")
```

NOTE: I'm probably going to maintain this very sloppily (I don't currently use LiveScript in Play, and I'm lazy).
If something doesn't work, open an issue and I'll get around to it.

Local Build / Installation
--------------------------

First, clone the repository:

    git clone https://github.com/12foo/play-livescript.git

In the project directory, do:

    sbt -Dplay.path=/your/play/directory publish

This will compile the plugin and install it into your Play repository. To use it in your webapp, add the plugin to its `project/plugins.sbt`:

    addSbtPlugin("com.github.otfoo" % "play-livescript" % "0.1")


License
-------

MIT-style licensing, for details see file LICENSE.

[1]: http://learnboost.github.com/stylus/
[2]: http://www.playframework.org/
[3]: https://github.com/harrah/xsbt
[4]: https://github.com/patiencelabs/play-stylus
