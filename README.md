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

A fake Maven repository forked from the 12foo repository is now available on github for easier installation. Add the following to your `plugins.sbt`:

```scala
resolvers += Resolver.url("play-livescript repo", url("https://github.com/alvinfrancis/mvnrepo/raw/master/releases/"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.github.otfoo" % "play-livescript" % "0.1.1")
```

Local Build / Installation
--------------------------

First, clone the repository:

    git clone https://github.com/alvinfrancis/play-livescript.git

In the project directory, do:

    sbt -Dplay.path=/your/play/directory publish

This will compile the plugin and install it into your Play repository. To use it in your webapp, add the plugin to its `project/plugins.sbt`:

    addSbtPlugin("com.github.otfoo" % "play-livescript" % "0.1.1")


License
-------

MIT-style licensing, for details see file LICENSE.

[1]: http://learnboost.github.com/stylus/
[2]: http://www.playframework.org/
[3]: https://github.com/harrah/xsbt
[4]: https://github.com/patiencelabs/play-stylus
[5]: https://github.com/12foo/play-livescript
