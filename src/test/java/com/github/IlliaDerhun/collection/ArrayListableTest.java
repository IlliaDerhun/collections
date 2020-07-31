package com.github.IlliaDerhun.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ArrayListableTest {

    private Listable<Integer> integers;

    @BeforeEach
    void beforeEach() {
        integers = new ArrayListable<>();
    }

    @Test
    void addSingleElement() {
        boolean actualResponse = integers.add(1);

        assertThat(actualResponse, is(true));
    }

    @Test
    void getSingleElement() {
        Integer expectedInteger = 1;

        integers.add(expectedInteger);
        Integer actualInteger = integers.get(0);

        assertThat(actualInteger, is(expectedInteger));
    }

    @Test
    void addMoreThenInitialCapacityElements() {
        int expectedSize = 150;
        for (int i = 0; i < expectedSize; i++) {
            integers.add(i);
        }

        assertThat(integers.size(), is(expectedSize));
    }

    @Test
    void sizeInitiallyShouldBeZero() {
        int expectedSize = 0;
        int actualSize = integers.size();

        assertThat(actualSize, is(expectedSize));
    }

    @Test
    void isEmptyInitiallyShouldBeTrue() {
        boolean actualResponse = integers.isEmpty();

        assertThat(actualResponse, is(true));
    }

    @Test
    void isEmptyShouldBeFalseForNonEmptyArray() {
        integers.add(1);
        boolean actualResponse = integers.isEmpty();

        assertThat(actualResponse, is(false));
    }

    @Test
    void containsShouldBeFalseForNonExistingElementInArray() {
        integers.add(1);
        boolean actualResponse = integers.contains(123);

        assertThat(actualResponse, is(false));
    }

    @Test
    void containsShouldBeTrueForExistingElementInArray() {
        integers.add(1);
        boolean actualResponse = integers.contains(1);

        assertThat(actualResponse, is(true));
    }

    @Test
    void containsShouldBeFalseForNullInEmptyArray() {
        boolean actualResponse = integers.contains(null);

        assertThat(actualResponse, is(false));
    }

    @Test
    void containsShouldBeTrueForArrayWithNullElementInside() {
        integers.add(1);
        integers.add(null);
        integers.add(2);
        boolean actualResponse = integers.contains(null);

        assertThat(actualResponse, is(true));
    }

    @Test
    void containsShouldBeFalseForArrayWithNonNullElementInside() {
        integers.add(1);
        integers.add(2);
        boolean actualResponse = integers.contains(null);

        assertThat(actualResponse, is(false));
    }

    @Test
    void indexOfElementShouldReturnNegativeOneForEmptyArray() {
        int actualIndex = integers.indexOfElement(1);

        assertThat(actualIndex, is(-1));
    }

    @Test
    void indexOfElementShouldReturnZeroForArrayWithSingleElement() {
        integers.add(1);
        int actualIndex = integers.indexOfElement(1);

        assertThat(actualIndex, is(0));
    }

    @Test
    void indexOfElementShouldReturnNegativeOneForNonExistingElement() {
        integers.add(1);
        int actualIndex = integers.indexOfElement(10);

        assertThat(actualIndex, is(-1));
    }
}
