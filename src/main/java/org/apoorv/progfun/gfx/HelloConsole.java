package org.apoorv.progfun.gfx;

import acm.program.*;

/**
 * A copy of <a href="https://cs.stanford.edu/people/eroberts/jtf/tutorial/Introduction.html">JTF acm tutorial hello world class</a>.
 *
 * <p>
 *     This class should be runnable in your IDE. When run it should display "Hello World" in a console window.
 <pre>
 It is tested on
 IntelliJ IDEA 2020.3.1 (Community Edition)
 * Build #IC-203.6682.168, built on December 29, 2020
 * Runtime version: 11.0.9.1+1-post-Raspbian-1deb10u2 arm
 * VM: OpenJDK Server VM by Raspbian
 * Linux 4.19.118-v7l+
 * GC: ParNew, ConcurrentMarkSweep
 * Memory: 989M
 * Cores: 4
 * Non-Bundled Plugins: Key Promoter X, org.jetbrains.kotlin
 * Current Desktop: LXDE
 * </pre>
 */
public class HelloConsole extends ConsoleProgram {

    public void run() {
        println("hello, world");
    }

    /* Standard Java entry point */
    /* This method can be eliminated in most Java environments */
    public static void main(String[] args) {
        new HelloConsole().start(args);
    }
}