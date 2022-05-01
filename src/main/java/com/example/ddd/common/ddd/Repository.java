package com.example.ddd.common.ddd;

import java.util.List;

public interface Repository <A extends AggregateRoot<I>, Q extends Query, I extends Identifier>{

    A get(I id);

    List<A> batchGet(List<I> ids);

    boolean save(A aggregateRoot);

    boolean remove(I id);

    List<A> query(Q query);

    int count(Q query);
    
}
