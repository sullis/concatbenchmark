/*
 * Copyright Gunnar Morling.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package dev.morling;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.infra.Blackhole;

public class StringConcatBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OperationsPerInvocation(100)
    public void testStringBuilder(Blackhole blackhole) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            stringBuilder.append(i);
        }

        blackhole.consume(stringBuilder.toString());
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OperationsPerInvocation(100)
    public void testStringBuffer(Blackhole blackhole) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < 100; i++) {
            stringBuffer.append(i);
        }

        blackhole.consume(stringBuffer.toString());
    }
}
