package com.spring.sequnece;

import java.util.concurrent.atomic.AtomicInteger;

// 시퀀스 생성기
public class SequenceGenerator {

    private String prefix;
    private String suffix;
    private int init;
    private final AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator(){

    }

    public void setPrefix (String prefix){
        this.prefix = prefix;
    }

    public void setSuffix (String suffix){
        this.suffix = suffix;
    }

    public void setInit (int init){
        this.init = init;
    }

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(init)
                .append(counter.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }

}
