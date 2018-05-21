# Deraja
Simple temperature conversion app for teachers.

# Downloading and Running

You can download the current version from PackageCloud.

[Click Here for the JAR](https://packagecloud.io/ahdo9i/deraja-sample-prod/packages/java/deraja/deraja-0.0.1-SNAPSHOT.jar/artifacts/deraja-0.0.1-20180521.060853-1.jar/download)

As a savvy teacher, you can open this console application on the operating
system of your choice. All you need to do is run the following command:

```console
foo@bar:~$ java -jar  deraja-0.0.1-20180521.060853-1.jar
Welcome to Temp Conversion Grader!
You may quit at any time by typing 'q' or 'quit' at a prompt.
Please enter a temperature:
>
```

Maybe on Windows it looks like this,

```console
C:\Windows\System32> java -jar  deraja-0.0.1-20180521.060853-1.jar
Welcome to Temp Conversion Grader!
You may quit at any time by typing 'q' or 'quit' at a prompt.
Please enter a temperature:
>
```

And you are off to the races, to see the mettle of your students and how much
heat they can handle!

# Development Workflow

Contributors make PRs that are to be reviewed by core contributors (currently,
only me). Then, if we all did our job, it immediately gets sent to [TravisCI](https://travis-ci.com/xee5ch/deraja/),
the core of our CI/CD pipeline one last time. When we review your PR, don't worry,
it either pasts the tests, or we work on it together until it does pass.

Once it meets muster, and we have tagged a dev release candidate branch or the
master (AKA trunk) branch for good as ready for the public, TravisCI works with
PackageCloud to automagically publish a versioned copy of the self-contained JAR
bundle to the cloud. No muss, no fuss!

We will soon make sure, the tagged releases also get sent back to the Github
[release page, where you download tagged versions of source as needed](https://github.com/xee5ch/deraja/releases).

# How Can We Do Better? How Can I Help?

- Feel free to [open a PR](https://github.com/xee5ch/deraja/issues).
- Help us with our interest in improving [our code coverage](https://codecov.io/gh/xee5ch/).
- Any infrastructure improvements welcome: logging, modularization, you name it!
