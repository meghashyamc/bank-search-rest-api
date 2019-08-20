package com.meghashyam.banksearch.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;

public class OffsetPageRequest implements Pageable {

    private int limit;
    private long offset;
    private final Sort sort;

    public OffsetPageRequest(int limit, long offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("Offset should be greater than or equal to zero!");
        }

        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be greater than zero!");
        }
        this.limit = limit;
        this.offset = offset;
        this.sort = new Sort(Sort.Direction.ASC, "id");
    }

    @Override
    public int getPageNumber() {
        return (int) offset / limit;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return new OffsetPageRequest(getPageSize(), getOffset() + getPageSize());
    }

    public OffsetPageRequest previous() {
        return hasPrevious() ? new OffsetPageRequest(getPageSize(), getOffset() - getPageSize()) : this;
    }


    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new OffsetPageRequest(0, getPageSize());
    }

    @Override
    public boolean hasPrevious() {
        return offset > limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!this.getClass().equals(o.getClass())) return false;

        OffsetPageRequest that = (OffsetPageRequest) o;

        return (this.limit == that.limit) &&
                (this.offset == that.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offset, limit);
    }

}
