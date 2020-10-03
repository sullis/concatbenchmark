# String Concat Benchmark

Benchmark to analyze the impact of biased locking deprecation and potential removal.

# Build

```
mvn clean verify
```

# Results

```
java -jar target/benchmarks.jar -f 1 -wi 5 -i 5

# JMH version: 1.25.2
# VM version: JDK 15, OpenJDK 64-Bit Server VM, 15+36-1562

Benchmark                                 Mode  Cnt          Score          Error  Units
StringConcatBenchmark.testStringBuffer   thrpt    5   39366534,323 ±  2374661,524  ops/s
StringConcatBenchmark.testStringBuilder  thrpt    5  166810460,263 ± 11673046,169  ops/s
```

```
java -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 -jar target/benchmarks.jar -f 1 -wi 5 -i 5

# JMH version: 1.25.2
# VM version: JDK 15, OpenJDK 64-Bit Server VM, 15+36-1562
# VM options: -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0

Benchmark                                 Mode  Cnt          Score         Error  Units
StringConcatBenchmark.testStringBuffer   thrpt    5   86009387,696 ± 6154578,359  ops/s
StringConcatBenchmark.testStringBuilder  thrpt    5  159590813,813 ± 4191626,720  ops/s
```

# Open Questions

Why is `StringBuffer` impacted that much by biased locking deactivation, shouldn't it be subject to lock elision?

# License

This code base is available ander the Apache License, version 2.
