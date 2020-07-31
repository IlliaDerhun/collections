package com.github.IlliaDerhun.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class LinkedListableTest {

    private Listable<Integer> linkedList;

    @BeforeEach
    void beforeEach() {
        linkedList = new LinkedListable<>();
    }

    @Test
    void addSingleElement() {
        boolean actualResponse = linkedList.add(1);

        assertThat(actualResponse, is(true));
    }

    @Test
    void getSingleElement() {
        Integer expectedInteger = 1;

        linkedList.add(expectedInteger);
        Integer actualInteger = linkedList.get(0);

        assertThat(actualInteger, is(expectedInteger));
    }

    @Test
    void addLotOfElements() {
        int expectedSize = 150;
        for (int i = 0; i < expectedSize; i++) {
            linkedList.add(i);
        }

        assertThat(linkedList.size(), is(expectedSize));
    }

    @Test
    void sizeInitiallyShouldBeZero() {
        int expectedSize = 0;
        int actualSize = linkedList.size();

        assertThat(actualSize, is(expectedSize));
    }

    @Test
    void isEmptyInitiallyShouldBeTrue() {
        boolean actualResponse = linkedList.isEmpty();

        assertThat(actualResponse, is(true));
    }

    @Test
    void isEmptyShouldBeFalseForNonEmptyArray() {
        linkedList.add(1);
        boolean actualResponse = linkedList.isEmpty();

        assertThat(actualResponse, is(false));
    }

    @Test
    void containsShouldBeFalseForNonExistingElementInArray() {
        linkedList.add(1);
        boolean actualResponse = linkedList.contains(123);

        assertThat(actualResponse, is(false));
    }

    @Test
    void containsShouldBeTrueForExistingElementInArray() {
        linkedList.add(1);
        boolean actualResponse = linkedList.contains(1);

        assertThat(actualResponse, is(true));
    }

    @Test
    void containsShouldBeFalseForNullInEmptyArray() {
        boolean actualResponse = linkedList.contains(null);

        assertThat(actualResponse, is(false));
    }

    @Test
    void containsShouldBeTrueForArrayWithNullElementInside() {
        linkedList.add(1);
        linkedList.add(null);
        linkedList.add(2);

        boolean actualResponse = linkedList.contains(null);

        assertThat(actualResponse, is(false));
    }

    @Test
    void containsShouldBeFalseForArrayWithNonNullElementInside() {
        linkedList.add(1);
        linkedList.add(2);
        boolean actualResponse = linkedList.contains(null);

        assertThat(actualResponse, is(false));
    }

    @Test
    void indexOfElementShouldReturnNegativeOneForEmptyArray() {
        int actualIndex = linkedList.indexOfElement(1);

        assertThat(actualIndex, is(-1));
    }

    @Test
    void indexOfElementShouldReturnZeroForArrayWithSingleElement() {
        linkedList.add(1);
        int actualIndex = linkedList.indexOfElement(1);

        assertThat(actualIndex, is(0));
    }

    @Test
    void indexOfElementShouldReturnNegativeOneForNonExistingElement() {
        linkedList.add(1);
        int actualIndex = linkedList.indexOfElement(10);

        assertThat(actualIndex, is(-1));
    }
}
